package com.mocompany.quiz_y

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.system.exitProcess

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name : String? =  intent.getStringExtra(Constants.USER_NAME)
        val questions : String? = intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        val correct : String? = intent.getStringExtra(Constants.CORRECT_ANSWERS)
        val activity :ResultActivity = ResultActivity()
        tv_result.setText("Congrats $name , \n your score is $correct out of $questions")
        btn_finish.setOnClickListener(){
            val intent = Intent (this , MainActivity::class.java)
            startActivity(intent)
        }
    }
}