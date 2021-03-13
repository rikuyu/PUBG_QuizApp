package com.example.quizapp

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.MarginLayoutParams
import android.widget.BaseAdapter
import android.widget.TextView


class Result(val username: String, val score: String)

class ListAdapter(val context: Context, val ScoreList: ArrayList<Result>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_score, null)
        val username = view.findViewById<TextView>(R.id.tv_username)
        val score = view.findViewById<TextView>(R.id.tv_score)

        val scores = ScoreList[position]

        username.text =
            if (position != 0) "${position}  ${scores.username}" else "${scores.username}"
        score.text = scores.score


        if (position == 0) {
            username.setTextColor(Color.rgb(255, 127, 0))
            username.setTypeface(username.typeface, Typeface.BOLD)
            score.setTextColor(Color.rgb(255, 127, 50))
            score.setTypeface(score.typeface, Typeface.BOLD)
            username.setTextSize(25.0f)
            score.setTextSize(25.0f)

            val lp: LayoutParams = username.getLayoutParams()
            val mlp = lp as MarginLayoutParams
            mlp.setMargins(170, mlp.topMargin, mlp.rightMargin, mlp.bottomMargin)
            username.setLayoutParams(mlp)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return ScoreList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return ScoreList.size
    }
}