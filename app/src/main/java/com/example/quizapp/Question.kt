package com.example.quizapp

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val optiionOne: String,
    val optiionTwo: String,
    val optiionThree: String,
    val optiionFour: String,
    val correctAnswer: Int
) {

}