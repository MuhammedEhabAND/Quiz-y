package com.mocompany.quiz_y

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName :String? = null
    private var mCorrectAnswer:Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName= intent.getStringExtra(Constants.USER_NAME)
        mQuestionList = Constants.getQuestions()
        tv_option_one?.setOnClickListener(this)
        tv_option_two?.setOnClickListener(this)
        tv_option_three?.setOnClickListener(this)
        tv_option_four?.setOnClickListener(this)
        submit_button?.setOnClickListener(this)

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()

        val question: Question = mQuestionList!![mCurrentPosition-1]
        progress?.progress = mCurrentPosition
        tv_progress?.text = "$mCurrentPosition/${progress?.max}"
        tv_question?.text = question.question
        tv_option_one?.text = question.optionOne
        tv_option_two?.text = question.optionTwo
        tv_option_three?.text = question.optionThree
        tv_option_four?.text = question.optionFour
        image?.setImageResource(question.image)
        if (mCurrentPosition == mQuestionList!!.size) {
            submit_button.setText("Finish")
        } else {
            submit_button.setText("Submit The Answer")
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tv_option_one?.let {
            options.add(0, it)

        }
        tv_option_two?.let {
            options.add(1, it)
        }
        tv_option_three?.let {
            options.add(2, it)
        }
        tv_option_four?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                tv_option_one?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option_two -> {
                tv_option_two?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option_three -> {
                tv_option_three?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option_four -> {
                tv_option_four?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.submit_button -> {
                if(mSelectedOptionPosition == 0 ){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }else->{
                            val intent = Intent(this , ResultActivity::class.java)
                            val correctAnswer : String = mCorrectAnswer.toString()
                            val totalquestions : String = mQuestionList!!.size.toString()
                            intent.putExtra(Constants.USER_NAME , mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS ,totalquestions)
                            intent.putExtra(Constants.CORRECT_ANSWERS , correctAnswer)

                        startActivity(intent)
                        }
                    }
                }else{
                    val question =mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition , R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer , R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestionList!!.size){
                        submit_button?.text = "Finish"

                    }else{
                        submit_button?.text = "go to the next question"
                    }
                    mSelectedOptionPosition=0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tv_option_two?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )


            }
            3 -> {
                tv_option_three?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )

            }
            4 -> {
                tv_option_four?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )

            }
        }
    }
}