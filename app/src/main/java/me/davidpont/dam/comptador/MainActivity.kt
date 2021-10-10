package me.davidpont.dam.comptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton : Button
    internal lateinit var timeTextView : TextView
    internal lateinit var counterTextView: TextView
    internal var counter=0;
    internal var time= 60;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.tapMeButton)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)

        //Actualizar o definir el valor del inicial de counterTextView -> counterTextView = score -> 0

        //TODO en algun moment haurem d'executar incementCounter

        tapMeButton.setOnClickListener{
            incrementCounter()
            //TODO iniciar el comptador
        }
        timeTextView.text=getString(R.string.timeText, time)
    }

    private fun incrementCounter(){

        counter++
        counterTextView.text = counter.toString()

    }
}