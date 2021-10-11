package me.davidpont.dam.comptador

import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton : Button
    internal lateinit var timeTextView : TextView
    internal lateinit var counterTextView: TextView
    internal var counter=0;
    internal var time= 5;

    internal var appStarted=false
    internal  lateinit var countDownTimer : CountDownTimer
    internal val initialCountDownTimer:Long=5000
    internal val intervalCountDownTimer:Long=1000

    override fun onCreate(savedInstanceState: Bundle?) {
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
        Toast.makeText(this, getString(R.string.endGame), Toast.LENGTH_LONG).show()
        restartGame()
    }

    private fun restartGame() {
        appStarted=false
        Toast.makeText(this,getString(R.string.restartGame,counter),  Toast.LENGTH_LONG).show()
        counter=0
        timeTextView.text=getString(R.string.timeText,time)
        counterTextView.text=counter.toString()


    }
    private fun incrementCounter(){

        counter++
        counterTextView.text = counter.toString()

    }

}