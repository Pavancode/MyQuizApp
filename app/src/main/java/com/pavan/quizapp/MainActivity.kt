package com.pavan.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            if (name_of_player.text.toString().isNotEmpty()){
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,name_of_player.text.toString())
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Please enter the name", Toast.LENGTH_LONG).show()
            }
        }



    }
}