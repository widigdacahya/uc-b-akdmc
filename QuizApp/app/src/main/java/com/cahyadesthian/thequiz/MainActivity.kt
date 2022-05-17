package com.cahyadesthian.thequiz

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cahyadesthian.thequiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        bg_animate()

        mainBinding.btnStart.setOnClickListener {
            if(mainBinding.etEdt.text?.isEmpty() == true) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun bg_animate() {
        val animationDrawable: AnimationDrawable = mainBinding.bgMain.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }
    }
}