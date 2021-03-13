package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_ranking.*

class Ranking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        readFireStore()

        btn_return.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    fun readFireStore() {
        val scores = ArrayList<Result>()

        val db = FirebaseFirestore.getInstance()
        db.collection("user_scores")
            .orderBy(Score::score.name, Query.Direction.DESCENDING)
            .limit(5)
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    scores.add(Result("UserName", "Score"))
                    for (doc in it.result!!) {
                        var result = Result(doc.data.getValue("username").toString(), "${doc.data.getValue("score")} / 10")
                        scores.add(result)
                    }
                    val Adapter = ListAdapter(this, scores)
                    list_view.adapter = Adapter
                } else {
                    Toast.makeText(this, "ランキングを取得失敗", Toast.LENGTH_SHORT).show()
                }
            }

    }
}