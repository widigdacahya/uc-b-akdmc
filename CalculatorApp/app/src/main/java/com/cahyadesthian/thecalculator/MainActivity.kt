package com.cahyadesthian.thecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private var tvInput : TextView? = null
    var lastNumeric: Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tv_input)
    }

    fun onDigitBtn(view: View) {
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false

        //var theNumberInputed = tvInput?.text


    }

    fun onClearBtn(view: View) {
        tvInput?.text = ""
    }

    fun onDecimalBtn(view:View) {

        if(lastNumeric && !lastDot) {
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }


    }



    fun onEqualBtn(view: View) {
        if(lastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""

            try {

                if(tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                /*Negative Operation*/
                if(tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()) {
                        one = prefix+one
                    }

                    tvInput?.text = removeZeroAfterDot((one.toDouble().minus(two.toDouble())).toString())
                }

                /*Positive Operation*/
                if(tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()) {
                        one = prefix+one
                    }

                    tvInput?.text =removeZeroAfterDot((one.toDouble().plus(two.toDouble())).toString())
                }

                /*Division Operation*/
                if(tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()) {
                        one = prefix+one
                    }

                    tvInput?.text =  removeZeroAfterDot( (one.toDouble().div(two.toDouble())).toString())
                }

                /*Multiplication Operation*/
                if(tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()) {
                        one = prefix+one
                    }

                    tvInput?.text = removeZeroAfterDot((one.toDouble().times(two.toDouble())).toString())
                }



            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }

        }
    }

    private fun isOperatorAdded(value: String) : Boolean {
        return if(value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }

    fun onOperator(view: View) {

        tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }

            if(!lastNumeric && !isOperatorAdded(it.toString()) && (view as Button).text.toString() == "-" && !it.contains("-") ) {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }

        }


    }

    private fun removeZeroAfterDot(result: String) : String {
        var value = result
        if(result.contains(".0")) value = result.substring(0, (result.length-2))
        return value
    }

}