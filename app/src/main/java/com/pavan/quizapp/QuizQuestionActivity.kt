package com.pavan.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition:Int = 1
    private var mQuestionsList:ArrayList<Questions>? = null
    private  var mSelectedOptionPosition:Int = 0
    private var progressBar:ProgressBar? = null
    private var tvQuestion:TextView? = null
    private var tvprogress :TextView? = null
    private var ivImage:ImageView?=null
    private var tvoption1:TextView?=null
    private var tvoption2:TextView?=null
    private var tvoption3:TextView?=null
    private var tvoption4:TextView?=null
    private var submit:Button? = null
    private  var mUserName:String? = null
    private var mCorrectAnswer:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        progressBar = findViewById(R.id.progressBar)
        tvprogress = findViewById(R.id.tvprogress)
        ivImage = findViewById(R.id.iv_image)
        tvoption1 = findViewById(R.id.option1)
        tvoption2 = findViewById(R.id.option2)
        tvoption3 = findViewById(R.id.option3)
        tvoption4 = findViewById(R.id.option4)
        tvQuestion = findViewById(R.id.tvQuestion)
        submit= findViewById(R.id.submit_btn)
        tvoption1?.setOnClickListener(this)
        tvoption2?.setOnClickListener(this)
        tvoption3?.setOnClickListener(this)
        tvoption4?.setOnClickListener(this)
        submit?.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()
        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Questions = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        ivImage?.setImageResource(question.image)
        tvprogress?.text = "${mCurrentPosition}/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvoption1?.text = question.optionOne
        tvoption2?.text = question.optionTwo
        tvoption3?.text = question.optionThree
        tvoption4?.text = question.optionFour

        if(mCurrentPosition == mQuestionsList!!.size){
            submit?.text = "Finish"
        }else{
            submit?.text = "Submit"
        }

    }
    private  fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvoption1?.let {
            options.add(0,it)
        }
        tvoption2?.let {
            options.add(1, it)
        }
        tvoption3?.let {
            options.add(2, it)
        }
        tvoption4?.let {
            options.add(3, it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                   R.drawable.option_border
//                  R.drawable.selected_border


                )
        }


    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.MAGENTA)
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
                R.drawable.selected_border
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1 -> {
                tvoption1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.option2 -> {
                tvoption2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.option3 -> {
                tvoption3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.option4 -> {
                tvoption4?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.submit_btn -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                             val intent = Intent(this,ResultActivity::class.java)
                             intent.putExtra(Constants.USER_NAME,mUserName)
                             intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer)
                             intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                             startActivity(intent)
                             finish()
                         }
                    }
                }else {
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionsList!!.size){
                        submit?.text = "Finish"
                    }else{
                        submit?.text = "Next Question"

                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1 -> {
                tvoption1?.background = ContextCompat.getDrawable(this@QuizQuestionActivity,
                    drawableView)
            }
            2 -> {
                tvoption2?.background = ContextCompat.getDrawable(this@QuizQuestionActivity,
                    drawableView)
            }
            3 -> {
                tvoption3?.background = ContextCompat.getDrawable(this@QuizQuestionActivity,
                    drawableView)
            }
            4 -> {
                tvoption4?.background = ContextCompat.getDrawable(this@QuizQuestionActivity,
                    drawableView)
            }
        }
    }
}