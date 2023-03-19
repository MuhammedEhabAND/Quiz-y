package com.mocompany.quiz_y

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var name : String ="john"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start_btn.setOnClickListener(){
          if(name_text.text.toString().isEmpty()){
           Toast.makeText(this , "Please enter your name " ,Toast.LENGTH_SHORT).show()
              name_text.setError("Please enter your name!")
          }else {

              name = name_text.text.toString()
              val intent =  Intent(this , QuizQuestionActivity::class.java)
              intent.putExtra(Constants.USER_NAME , name)
              startActivity(intent)
              finish()
          }
        }
    }
}