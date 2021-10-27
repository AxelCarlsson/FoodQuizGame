package com.example.foodquizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start = findViewById<Button>(R.id.btn_start)
        val et_name = findViewById<EditText>(R.id.et_name)
        val btn_highscore = findViewById<Button>(R.id.btn_highscore)
        val et_age = findViewById<EditText>(R.id.et_age)

        btn_highscore.setOnClickListener{
            val intent = Intent(this, Highscores::class.java)
            startActivity(intent)
            finish()
        }

        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty() || et_age.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name and age", Toast.LENGTH_SHORT).show()
            } else {
                val age = et_age.text.toString().toInt()
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                intent.putExtra("User age", age)
                startActivity(intent)
                finish()
            }
        }
    }
}