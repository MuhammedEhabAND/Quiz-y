package com.mocompany.quiz_y

object Constants {
    const val USER_NAME :String ="user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionList  = ArrayList<Question>()
        val q1 = Question(
            1 ,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        questionList.add(q1)
        val q2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "New Zealand",
            "Ireland",
            "England",
            2
        )

        questionList.add(q2)
        val q3 = Question(
            3 ,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "France",
            "Finland",
            "Austria",
            "Brazil",
            4
        )

        questionList.add(q3)
        val q4 = Question(
            4 ,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Netherlands",
            "England",
            "Poland",
            1
        )

        questionList.add(q4)
        val q5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "France",
            "Denmark",
            "Brazil",
            3
        )

        questionList.add(q5)
        val q6 = Question(
            6 ,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "India",
            "Poland",
            "France",
            2
        )

        questionList.add(q6)
        val q7 = Question(
            7 ,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Germany",
            "Fiji",
            "Armenia",
            "Austria",
            2
        )

        questionList.add(q7)
        val q8 = Question(
            8 ,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "France",
            "Armenia",
            "England",
            1
        )
        questionList.add(q8)
        val q9 = Question(
            9 ,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Brazil",
            "Poland",
            "Kuwait",
            "Netherlands",
            3
        )
        questionList.add(q9)
        return questionList
    }
}