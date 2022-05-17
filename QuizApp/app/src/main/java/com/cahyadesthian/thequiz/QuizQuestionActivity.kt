package com.cahyadesthian.thequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cahyadesthian.thequiz.model.Constants

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionList = Constants.getQuestions()
        Log.i("Question list size is", "${questionList.size}")
    }
}