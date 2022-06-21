package com.example.practica1_interfazusuario2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practica1_interfazusuario2.R

class MainViewModel : ViewModel() {

    private var hobselected: Boolean = false
    private var hobby: String = ""
    private var name = " "
    private var email = ""
    private var password = ""
    private var confirmpassword = ""
    private var genre =""
    private var borncity = ""
    private var born_date = ""
    private var checked: Boolean = false
    private var totalInfo = ""


    private var totalInfo_: MutableLiveData<String> = MutableLiveData()
    var totalInfo__: LiveData<String> = totalInfo_

    private var hobselected_: MutableLiveData<Boolean> = MutableLiveData()
    var hobcheck: LiveData<Boolean> = hobselected_

    fun passcomprobation (): Boolean {
        return password != confirmpassword
    }

    fun checktrue(hobbies:String) {
        hobby += hobbies + " "
        hobselected = true
        hobselected_.value = hobselected
    }

    fun cleanObjects() {
        hobby = " "
        name = " "
        email = " "
        password = " "
        confirmpassword = " "
        genre = ""
        borncity = " "
        born_date = " "
        showInfo()
    }

    fun obtainname(names: String) {
        name = names
    }

    fun obtainemail(emails: String) {
        email = emails
    }

    fun obtainpassword(passwords: String) {
        password = passwords
    }

    fun obtainconfirmpassword(confirm: String) {
        confirmpassword = confirm
    }

    fun obtainborn(borndate: String) {
        born_date = borndate
    }

    fun obtaingenre(genero: String) {
        genre = genero
    }

    fun obtaingenre1(genero: String) {
        genre = genero
    }

    fun obtainCity(born: String) {
        borncity = born
    }

    fun verifyFields(names: Boolean, emails: Boolean, passwords: Boolean, confirm: Boolean): Boolean{
        if (names && emails && passwords && confirm){
            checked = true
            return checked
        }
        return false
    }

    fun showInfo() {
        totalInfo = "Nombre: "+ name + "\n" + "Correo: " + email + "\n" + "Contraseña: "+ password + "\n" +
                "Confirmar contraseña: "+ confirmpassword + "\n" + "Hobbies: " + hobby + "\n"+
        "Ciudad de Nacimiento: "+ borncity + "\n" + "Fecha de Nacimiento: " + born_date
        totalInfo_.value = totalInfo
    }
}