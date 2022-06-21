package com.example.practica1_interfazusuario2.ui.main

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.practica1_interfazusuario2.R
import com.example.practica1_interfazusuario2.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var borndate = ""
    private var bornDateChanged = false
    private var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(view)

        mainViewModel.hobcheck.observe(this) { check ->
            if (!check) Toast.makeText(
                this@MainActivity,
                getString(R.string.msg_hob),
                Toast.LENGTH_SHORT
            ).show()
        }
        mainViewModel.totalInfo__.observe(this){
            mainBinding.infotextView2.text = it
        }

        val dateSetListener = DatePickerDialog.OnDateSetListener {_, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(format)
            borndate = sdf.format(calendar.time).toString()
            mainBinding.dateBornButton.text = borndate
            bornDateChanged = true
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

            cleanButton.setOnClickListener{
                mainViewModel.cleanObjects()
                nameEditText.setText("")
                passwordEditText.setText("")
                confirmPasswordEditText.setText("")
                emailEditText.setText("")
                placeBirthSpinner.setSelection(0)
                paintCheckBox.isChecked = false
                seriesCheckBox4.isChecked = false
                sportCheckBox2.isChecked = false
                readCheckBox3.isChecked = false
            }

            saveButton.setOnClickListener {

                if(nameEditText.text.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_name),Toast.LENGTH_SHORT).show()
                if(emailEditText.text.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_email),Toast.LENGTH_SHORT).show()
                if(passwordEditText.text.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_password),Toast.LENGTH_SHORT).show()
                if(confirmPasswordEditText.text.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_confirm),Toast.LENGTH_SHORT).show()


                mainViewModel.obtainname(nameEditText.text.toString())
                mainViewModel.obtainemail(emailEditText.text.toString())
                mainViewModel.obtainpassword(passwordEditText.text.toString())
                mainViewModel.obtainconfirmpassword(confirmPasswordEditText.text.toString())

                if(femaleRadioButton3.isChecked) mainViewModel.obtaingenre(femaleRadioButton3.text.toString())
                else mainViewModel.obtaingenre1(maleRadioButton4.text.toString())

                if(mainViewModel.passcomprobation())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_bad), Toast.LENGTH_SHORT).show()

                if(paintCheckBox.isChecked) mainViewModel.checktrue("Dibujar")
                if(sportCheckBox2.isChecked) mainViewModel.checktrue("Deportes")
                if(readCheckBox3.isChecked) mainViewModel.checktrue("Leer")
                if(seriesCheckBox4.isChecked) mainViewModel.checktrue("Series")

                mainViewModel.obtainCity(placeBirthSpinner.selectedItem.toString())
                mainViewModel.obtainborn(borndate)

                if(mainViewModel.verifyFields(nameEditText.text.toString().isNotEmpty(), emailEditText.text.toString().isNotEmpty(),
                    passwordEditText.text.toString().isNotEmpty(), confirmPasswordEditText.text.toString().isNotEmpty())) {
                    mainViewModel.showInfo()
                }
                else Toast.makeText(this@MainActivity,getString(R.string.msg_complete),Toast.LENGTH_SHORT).show()
            }
        }
    }
}