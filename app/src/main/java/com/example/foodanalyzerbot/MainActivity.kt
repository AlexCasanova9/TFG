package com.example.foodanalyzerbot

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        PButton.setOnClickListener {
            d("alex", "Button was pressed!")
            startActivity(Intent(this, Results::class.java))
        }

        WPButton.setOnClickListener {
            val r = Random()
            val number = r.nextInt(5) + 1

            //d("alex", "Number ${number}")

            if(number == 1){
                customeWallpaper.setImageResource(R.drawable.chuche)
            } else if(number == 2){
                customeWallpaper.setImageResource(R.drawable.fruta)
            } else if(number == 3){
                customeWallpaper.setImageResource(R.drawable.manzana)
            } else if(number == 4){
                customeWallpaper.setImageResource(R.drawable.sandia)
            } else if(number == 5){
                customeWallpaper.setImageResource(R.drawable.uva)
            }

        }
    }
}
