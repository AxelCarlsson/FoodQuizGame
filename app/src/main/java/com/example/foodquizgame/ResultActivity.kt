package com.example.foodquizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val context = this
        val db = DatabaseHandler(context)

        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_score = findViewById<TextView>(R.id.tv_score)
        val btn_finish = findViewById<Button>(R.id.btn_finish)

        // Receive and use the Username
        val username = intent.getStringExtra(Constants.USER_NAME)
        val age = intent.getIntExtra("User age", 0)
        tv_name.text = username

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra("score", 0)

        tv_score.text = "Your Score is $score out of $totalQuestions"



        btn_finish.setOnClickListener{
            val user = username?.let { it1 -> User(it1, age, score) }
            if (user != null) {
                db.insertData(user)
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}