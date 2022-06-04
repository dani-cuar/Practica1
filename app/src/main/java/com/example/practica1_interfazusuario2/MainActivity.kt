package com.example.practica1_interfazusuario2

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import com.example.practica1_interfazusuario2.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : Activity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var borndate = ""
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        val dateSetListener = DatePickerDialog.OnDateSetListener {_, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(format)
            borndate = sdf.format(calendar.time).toString()
            mainBinding.dateBornButton.text = borndate
        }

        with(mainBinding) {
            dateBornButton.setOnClickListener {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

            saveButton.setOnClickListener {

                if(nameEditText.text.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_name),Toast.LENGTH_SHORT).show()

                if(emailEditText.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_email),Toast.LENGTH_SHORT).show()

                if(passwordEditText.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_password),Toast.LENGTH_SHORT).show()

                if(confirmPasswordEditText.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_confirm),Toast.LENGTH_SHORT).show()

                val name = nameEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val confirmpassword = confirmPasswordEditText.text.toString()

                if(password != confirmpassword)
                    Toast.makeText(this@MainActivity,getString(R.string.msg_bad), Toast.LENGTH_SHORT).show()

                val genre = if(femaleRadioButton3.isChecked) getString(R.string.female)
                else getString(R.string.male)

                var hobbies = ""
                if(paintCheckBox.isChecked) hobbies += getString(R.string.paint) + " "
                if(sportCheckBox2.isChecked) hobbies += getString(R.string.sport) + " "
                if(readCheckBox3.isChecked) hobbies += getString(R.string.read) + " "
                if(seriesCheckBox4.isChecked) hobbies += getString(R.string.series) + " "

                val borncity = placeBirthSpinner.selectedItem.toString()

                infotextView2.text = getString(R.string.info, name, email, password, confirmpassword, genre, hobbies, borncity, borndate)
            }
        }
    }
}