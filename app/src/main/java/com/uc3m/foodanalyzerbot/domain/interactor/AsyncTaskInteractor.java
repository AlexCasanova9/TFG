package com.uc3m.foodanalyzerbot.domain.interactor;

import android.os.AsyncTask;

import com.uc3m.foodanalyzerbot.domain.exception.HttpException;
import com.uc3m.foodanalyzerbot.domain.exception.RepositoryException;
import com.uc3m.foodanalyzerbot.infrastructure.Supplier;


public abstract class AsyncTaskInteractor<T> implements Interactor {

    private InteractorEventListener eventListener;

    public void execute(InteractorCallback<T> callback, Object... param) {
        execute(null, callback, param);
    }

    protected void execute(Supplier<T> cacheSupplier, InteractorCallback<T> callback, final Object... param) {
        if (callback == null)
            throw new IllegalStateException("The callback is null!!!");
        try {
            InnerTask innerTask = new InnerTask(callback, eventListener);
            innerTask.execute(param);

        } catch (Exception e) {
            callback.fail(e);
        }
    }

    protected abstract T runInBackground(Object... params);

    protected Throwable handleErrors(Exception e) {
        if (e instanceof HttpException) {
            int errorCode = (((HttpException) e).getResponse() != null) ? ((HttpException) e).getResponse().code() : 0;
            return new RepositoryException(String.valueOf(errorCode), e.getMessage(), "");
        }
        return e;
    }

    @Override
    public void setEventListener(InteractorEventListener eventListener) {
        this.eventListener = eventListener;
    }

    private class InnerTask extends AsyncTask<Object, Void, T> {
        private final InteractorCallback<T> callback;
        private final InteractorEventListener eventListener;
        private Throwable error;

        InnerTask(InteractorCallback<T> callback, InteractorEventListener eventListener) {
            this.callback = callback;
            this.eventListener = eventListener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (eventListener != null) {
                eventListener.onStartProcess();
            }
        }

        @Override
        protected T doInBackground(Object... params) {
            try {
                return runInBackground(params);
            } catch (Exception e) {
                error = handleErrors(e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(T t) {
            super.onPostExecute(t);
            notifyOnFinishProcess();
            try {
                responseToCallback(t);
            } catch (Exception ignored) {

            }
        }

        private void notifyOnFinishProcess() {
            if (eventListener != null) {
                eventListener.onFinishProcess();
            }
        }

        private void responseToCallback(T t) {
            if (error == null) {
                callback.success(t);
            } else {
                callback.fail(error);
            }
        }
    }
}
