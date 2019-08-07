package com.example.foodanalyzerbot.infrastructure

import android.support.annotation.LayoutRes
import java.lang.annotation.Inherited

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Inherited
annotation class ContentView(@LayoutRes val value: Int)
