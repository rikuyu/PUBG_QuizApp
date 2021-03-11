package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUSTIONS: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestions(): ArrayList<Question> {
        val Q_SENTENSE: String = "この武器の名前は？"

        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1, Q_SENTENSE, R.drawable.scar,
            "SCAR-L", "AKM", "SCAT", "チェコ", 1
        )
        questionsList.add(que1)

        val que2 = Question(
            2, Q_SENTENSE, R.drawable.m416,
            "SCAR-L", "M416", "M16A4", "G36C", 2
        )
        questionsList.add(que2)
        val que3 = Question(
            3, Q_SENTENSE, R.drawable.m249,
            "M249", "M762", "M416", "MK47", 1
        )
        questionsList.add(que3)
        val que4 = Question(
            4, Q_SENTENSE, R.drawable.kar,
            "Mk12", "M24", "Kar98K", "mini14", 3
        )
        questionsList.add(que4)
        val que5 = Question(
            5, Q_SENTENSE, R.drawable.s686,
            "P90", "S12K", "Win-94", "S686", 4
        )
        questionsList.add(que5)
        val que6 = Question(
            6, Q_SENTENSE, R.drawable.m24,
            "Mk14", "M24", "SKS", "QBU", 2
        )
        questionsList.add(que6)
        val que7 = Question(
            7, Q_SENTENSE, R.drawable.uzi,
            "Vector", "DBS", "Micro UZI", "MP5K", 3
        )
        questionsList.add(que7)
        val que8 = Question(
            8, Q_SENTENSE, R.drawable.sks,
            "P92", "SKS", "SLR", "R45", 2
        )
        questionsList.add(que8)
        val que9 = Question(
            9, Q_SENTENSE, R.drawable.akm,
            "M1014", "AKM", "Groza", "AUG", 2
        )
        questionsList.add(que9)
        val que10 = Question(
            10, Q_SENTENSE, R.drawable.awm,
            "AWM", "M24", "M762", "UMP45", 1
        )
        questionsList.add(que10)

        return questionsList
    }
}