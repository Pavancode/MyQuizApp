package com.pavan.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView



class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView = findViewById(R.id.tvusername)
        val tvScore:TextView = findViewById(R.id.tvScore)
        val btnFinish:Button = findViewById(R.id.btn_finish)
        val totalQuestions= intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer= intent.getIntExtra(Constants.CORRECT_ANSWER,0)


       tvName.text = intent.getStringExtra(Constants.USER_NAME)
        tvScore.text = "Your Score is $correctAnswer out of $totalQuestions"
        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }




    }
}