package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUSTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        tv_score.text = "Your Score $correctAnswer / $totalQuestions"

        val score = Score(username!!, correctAnswer)

        btn_restart.setOnClickListener {
            saveFireStore(score)
            val intent = Intent(this, Ranking::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            intent.putExtra(Constants.CORRECT_ANSWER, correctAnswer)
            startActivity(intent)
            finish()
        }
    }

    fun saveFireStore(score: Score) {
        val db = FirebaseFirestore.getInstance()
        db.collection("user_scores").document().set(score)
//        val user: MutableMap<String, Any> = HashMap()
//        user["username"] = username
//        user["score"] = score
//        db.collection("user_scores").add(user)
    }
}