package com.cahyadesthian.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.StrictMath.abs
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null
    private var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnSelectDate : Button = findViewById(R.id.btn_selectdate_mainUI)
        tvSelectedDate = findViewById(R.id.tv_selected_date_data_mainUI)
        tvResult = findViewById(R.id.tv_result_mainUI)

        btnSelectDate.setOnClickListener {
            Toast.makeText(this, "Pick a date", Toast.LENGTH_SHORT).show()
            clickDatePicker()
        }

    }


    //a function to select the date
    private fun clickDatePicker() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this, "A Date Picked\nYear : $selectedYear\nMonth: ${selectedMonth+1}\nDay: $selectedDayOfMonth", Toast.LENGTH_LONG).show()

                val selectedDateByUser = "$selectedDayOfMonth/${selectedMonth+1}/${selectedYear}"
                tvSelectedDate?.text = selectedDateByUser

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDateByUser)
                theDate?.let {

                    val selectedDateInMinutes = theDate.time / 60000


                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {

                        val currentDateInMinutes = currentDate.time / 60000

                        val differenceInMinutes =  currentDateInMinutes - selectedDateInMinutes

                        //tvResult?.text = differenceInMinutes.toString()
                        tvResult?.text = abs(differenceInMinutes).toString()

                    }


                }




            },
            year,
            month,
            day)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }

}