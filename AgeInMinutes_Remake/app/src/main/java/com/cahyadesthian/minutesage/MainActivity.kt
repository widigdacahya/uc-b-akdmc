package com.cahyadesthian.minutesage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cahyadesthian.minutesage.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btnSelectdate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_selectdate -> {
                datePicker()
                Toast.makeText(this, "\uD83C\uDF89 Pick Your Birthday \uD83C\uDF89", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun datePicker() {

        val theCalendar = Calendar.getInstance()
        val year = theCalendar.get(Calendar.YEAR)
        val month = theCalendar.get(Calendar.MONTH)
        val day = theCalendar.get(Calendar.DAY_OF_MONTH)

        val dialogDatePicker = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this, "Year: $selectedYear | Month: ${selectedMonth+1} | Day: ${selectedDayOfMonth}", Toast.LENGTH_SHORT).show()

                val userBirthDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                mainBinding.tvBirthdateData.text = userBirthDate

                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = simpleDateFormat.parse(userBirthDate)
                theDate?.let {

                    val selectedDateInMinutes = theDate.time / 60000

                    val currentDate = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time/60000
                        val minutesDifference = currentDateInMinutes - selectedDateInMinutes
                        mainBinding.tvMinuteageData.text = abs(minutesDifference).toString()
                    }

                }

            },year,month,day)

        dialogDatePicker.datePicker.maxDate = System.currentTimeMillis()-86400000
        dialogDatePicker.show()

    }


}