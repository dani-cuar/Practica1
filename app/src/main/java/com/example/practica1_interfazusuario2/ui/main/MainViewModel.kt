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


    private var hobselected_: MutableLiveData<Boolean> = MutableLiveData()
    var hobcheck: LiveData<Boolean> = hobselected_

    private var listhobbies : MutableLiveData<String> = MutableLiveData()
    var listHob: LiveData<String> = listhobbies

    private var name_ : MutableLiveData<String> = MutableLiveData()
    var name__: LiveData<String> = name_

    private var email_ : MutableLiveData<String> = MutableLiveData()
    var email__: LiveData<String> = email_

    private var password_ : MutableLiveData<String> = MutableLiveData()
    var password__: LiveData<String> = password_

    private var genre_ : MutableLiveData<String> = MutableLiveData()
    var genre__: LiveData<String> = genre_

    private var confirmpassword_ : MutableLiveData<String> = MutableLiveData()
    var confirmpassword__: LiveData<String> = confirmpassword_

    private var borncity_ : MutableLiveData<String> = MutableLiveData()
    var borncity__: LiveData<String> = borncity_

    private var borndate_ : MutableLiveData<String> = MutableLiveData()
    var borndate__: LiveData<String> = borndate_

    fun passcomprobation (password:String, confirmpassword:String): Boolean {
        return password != confirmpassword
    }

    fun checktrue(hobbies:String) {
        hobby += hobbies + " "
        hobselected = true
        hobselected_.value = hobselected
        listhobbies.value = hobby
    }

    fun cleanObjects() {
        hobby = " "
        listhobbies.value = hobby
        name = " "
        name_.value = name
        email = " "
        email_.value = email
        password = " "
        password_.value = password
        confirmpassword = " "
        confirmpassword_.value = confirmpassword
        genre = ""
        genre_.value = genre
        borncity = " "
        borncity_.value = borncity
        born_date = " "
        borndate_.value = born_date
    }

    fun obtainname(names: String) {
        name = names
        name_.value = name
    }

    fun obtainemail(emails: String) {
        email = emails
        email_.value = email
    }

    fun obtainpassword(passwords: String) {
        password = passwords
        password_.value = password
    }

    fun obtainconfirmpassword(confirm: String) {
        confirmpassword = confirm
        confirmpassword_.value = confirmpassword
    }

    fun obtainborn(borndate: String) {
        born_date = borndate
        borndate_.value = born_date
    }

    fun obtaingenre(genero: String) {
        genre = genero
        genre_.value = genre
    }

    fun obtaingenre1(genero: String) {
        genre = genero
        genre_.value = genre
    }
}