package com.cahyadesthian.thequiz.model

import com.cahyadesthian.thequiz.R

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        //question 1
        val que1 = Question(
            id = 1,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Austria", "Indonesia", "India",
            1
        )
        questionList.add(que1)

        //question 2
        val que2 = Question(
            id = 2,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_australia,
            "Argentina", "Australia", "Armenia", "Arab",
            2
        )
        questionList.add(que2)

        //question 3
        val que3 = Question(
            id = 3,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_belgium,
            "Belgium", "India", "Indonesia", "Kuwait",
            1
        )
        questionList.add(que3)

        //question 4
        val que4 = Question(
            id = 4,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_brazil,
            "Kuwait", "Brazil", "Denmark", "Argentina",
            2
        )
        questionList.add(que4)

        //question 5
        val que5 = Question(
            id = 5,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_denmark,
            "Brazil", "French", "Denmark", "Philippines",
            3
        )
        questionList.add(que5)

        //question 6
        val que6 = Question(
            id = 6,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_fiji,
            "Fiji", "America", "China", "Argentina",
            1
        )
        questionList.add(que6)

        //question 7
        val que7 = Question(
            id = 7,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_germany,
            "China", "German", "China", "Arab",
            2
        )
        questionList.add(que7)

        //question 8
        val que8 = Question(
            id = 8,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_india,
            "Rusia", "Indonesia", "Turkey", "India",
            4
        )
        questionList.add(que8)

        //question 9
        val que9 = Question(
            id = 9,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_kuwait,
            "Turkey", "Kuwait", "Arab", "India",
            2
        )
        questionList.add(que9)

        //question 10
        val que10 = Question(
            id = 10,
            question = "Do you recognize this flag?",
            R.drawable.ic_flag_of_new_zealand,
            "Kuwait", "Argentina", "Fiji", "New Zealand",
            4
        )
        questionList.add(que10)


        return questionList
    }

}