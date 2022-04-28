package com.example.splashscreen


import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.fragments.LoginFragment.Companion.BUNDLE_KEY_NAME
import com.example.splashscreen.repository.LoginRepository
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class LoginViewModel():ViewModel() {

    val emailLiveData:MutableLiveData<String?> = MutableLiveData()
     val passwordLiveData:MutableLiveData<String?> = MutableLiveData()
    val loginLiveData:MutableLiveData<Boolean> = MutableLiveData()
    val loginRepository:LoginRepository = LoginRepository()
    val fullScreenLoader:MutableLiveData<Boolean> = MutableLiveData()
    fun validateEmail(email:String): Boolean {
        /*
        It validate email entered in the input
         */

        //if the email input field is empty
        if (email.isEmpty()){
            emailLiveData.postValue ("Field can not be empty")
            return false

        }
        //Matching the input email to a predefined email Pattern
//        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            emailLiveData.postValue ( "Please enter a valid email Address")
//            return false
//
//        }
        else{
            emailLiveData.postValue( null)
            return true

        }

    }
    fun validatePassword(password:String):Boolean{
        /*
        It validate email entered in the input
         */

        //if the email input field is empty
        if (password.isEmpty()){
            passwordLiveData.postValue ("Field can not be empty")
            return false

        }
        //Matching the input email to a predefined email Pattern
//        else if (!PASSWORD_PATTERN.matcher(password).matches()){
//            passwordLiveData.postValue ( "Password is too weak")
//            return false
//
//        }
        else{
            passwordLiveData.postValue( null)
            return true
        }

    }


    fun confirmInput(email: String, password: String){
        /*
        It validate email entered in the input
         */


        if (validateEmail(email) and validatePassword(password) ) {
            fullScreenLoader.postValue(true)

            viewModelScope.launch {

                val response = loginRepository.validateCreditanials(email, password)
                fullScreenLoader.postValue(false)
               if(response.isSuccessful){
                   loginLiveData.postValue(true)
               }else{
                   loginLiveData.postValue(false)

               }

            }

        }

    }

    companion object{
        private  var  PASSWORD_PATTERN: Pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")

    }






}