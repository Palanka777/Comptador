package me.davidpont.dam.comptador

import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    internal lateinit var tapMeButton : Button
    internal lateinit var timeTextView : TextView
    internal lateinit var counterTextView: TextView
    internal var counter=0;
    internal var time= 10;

    internal var appStarted=false
    internal  lateinit var countDownTimer : CountDownTimer
    internal val initialCountDownTimer:Long= time.toLong() * 1000
    internal val intervalCountDownTimer:Long=1000

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"Hola mon! oncreate")
        Log.d(TAG, counter.toString())
        Log.d(TAG, time.toString())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCountDown()

        tapMeButton = findViewById(R.id.tapMeButton)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)


        tapMeButton.setOnClickListener{
            if (!appStarted){
                startGame()

            }
            incrementCounter()

        }
        timeTextView.text=getString(R.string.timeText,time)
    }


    private fun initCountDown(){
        countDownTimer=object :CountDownTimer(initialCountDownTimer,intervalCountDownTimer){
            override fun onTick(millisUntilFinished: Long) {
                val TimeLeft =millisUntilFinished / 1000
                timeTextView.text = TimeLeft.toString()
            }

            override fun onFinish() {
                endGame()
            }
        }
    }
    private fun startGame() {
        countDownTimer.start()
        appStarted = true
    }
    private fun endGame(){
        Toast.makeText(this,getString(R.string.restartGame,counter)+" "+getString(R.string.endGame),  Toast.LENGTH_LONG).show()
        restartGame()
    }

    private fun restartGame() {
        appStarted=false
        counter=0
        timeTextView.text=getString(R.string.timeText,time)
        counterTextView.text=counter.toString()

    }
    private fun incrementCounter(){

        counter++
        counterTextView.text = counter.toString()

    }

}