package com.example.foodquizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Highscores : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highscores)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val tv_place = findViewById<TextView>(R.id.tv_place)


        val tv_high_name = findViewById<TextView>(R.id.tv_high_name)
        val tv_high_age = findViewById<TextView>(R.id.tv_high_age)
        val tv_high_score = findViewById<TextView>(R.id.tv_high_score)

        val btn_delete = findViewById<Button>(R.id.btn_delete)
        val btn_go_back = findViewById<Button>(R.id.btn_go_back)

        val context = this
        val db = DatabaseHandler(context)

        var data = db.readData()

        tv_place.text = ""
        tv_high_name.text = ""
        tv_high_age.text = ""
        tv_high_score.text = ""

        for (i in 0 until data.size) {
            tv_high_name.append(data[i].name + "\n")
            tv_high_age.append( data[i].age.toString() + "\n")
            tv_high_score.append(data[i].score.toString() + "\n")
            tv_place.append("${i + 1}" + "\n")

        }

        btn_go_back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_delete.setOnClickListener{

            db.deleteData()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}