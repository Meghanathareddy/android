package com.example.splashscreen.fragments


import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.*



class LoginFragment:Fragment(){
    private lateinit var password: EditText
    private lateinit var email:EditText
    private lateinit var button:Button
    private lateinit var dialog: LoadingDialog





    //    private var emailLiveData = MutableLiveData<String>()
    private lateinit var viewModel:LoginViewModel
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.


    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, parent, false)
        email = view.findViewById(R.id.etEmail)
        password = view.findViewById(R.id.etPassword)
        button = view.findViewById(R.id.loginBtn)
        dialog = activity?.let { LoadingDialog(it) }!!


        button.setOnClickListener {
            viewModel.confirmInput(email.text.toString(), password.text.toString())

        }
        // Defines the xml file for the fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.emailLiveData.observe(viewLifecycleOwner) {
            email.error = it
        }

        viewModel.passwordLiveData.observe(viewLifecycleOwner) {
            password.error = it
        }
        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            if(it){
                navigationToDashboard()
            }else{
                Toast.makeText(activity, "Invalid Crentials", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.fullScreenLoader.observe(viewLifecycleOwner){
                if(it){
                    Log.d("startLoading","startloading")
                    dialog.startLoadingDialog()
                }else{

                        Log.d("startLoading","dismissloading")
                        dialog.dismissDialog()



                }
        }

    }

    private fun navigationToDashboard(){
        val intent = Intent(activity, DashBoardActivity::class.java)
        val bundle= Bundle()
        bundle.putString(BUNDLE_KEY_NAME,"${email.text}")
        intent.putExtras(bundle)
        startActivity(intent)
    }



    companion object{
        var BUNDLE_KEY_NAME:String = "email"
    }


}




//    private fun validateEmail():Boolean{
//        /*
//        It validate email entered in the input
//         */
//
//        //Extract input from EditText
//        var emailInput:String = email.text.toString().trim()
//
//        //if the email input field is empty
//        if (emailInput.isEmpty()){
//            email.error = "Field can not be empty"
//            return false
//        }
//        //Matching the input email to a predefined email Pattern
//        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
//            email.error = "Please enter a valid email Address"
//            return false
//        }else{
//            email.error = null
//            return true
//        }
//    }
//    private fun validatePassword():Boolean{
//        /*
//        It validate password entered in the input
//         */
//
//        //Extract input from EditText
//        var passwordInput:String = password.text.toString().trim()
//
//        //if the email input field is empty
//        if (passwordInput.isEmpty()){
//            password.error = "Field can not be empty"
//            return false
//        }
//        //Matching the input email to a predefined email Pattern
//        else if (! (PASSWORD_PATTERN.matcher(passwordInput).matches())){
//            password.error = "Password is too weak"
//            return false
//        }else{
//            email.error = null
//            return true
//        }
//    }

//    fun confirmInput(){
//        /*
//        It validate email entered in the input
//         */
//
//        if (!validateEmail() or !validatePassword()){
//            return
//        }
//        //if the email and password matches, a toast message
//        // with email and password is displayed
//        var input:String = "Email:"+email.text.toString()
//        input += "\n"
//        input += "Password:"+password.text.toString()
//        Toast.makeText(activity,input, Toast.LENGTH_SHORT).show()
//        navigationToDashboard()



//    private fun navigationToDashboard(){
//        val intent = Intent(activity, DashBoardActivity::class.java)
//        val bundle= Bundle()
//        bundle.putString(BUNDLE_KEY_NAME,"${email.text}")
//        intent.putExtras(bundle)
//        startActivity(intent)
//    }

//    /*
//public static final Pattern Email_ADDRESS
//            =Pattern.compile(
//            "[a-zA-z0-9\\+\\.\\_\\%\\+]{1,256}"+
//            "\\@"+
//            "[a-zA-z0-9][a-zA-Z0-9\\-]{0,64}"+
//            "(" +
//            "\\." +
//            "[a-zA-z0-9][a-zA-Z0-9\\-]{0,25}"+
//            ")+"
//            )
// */


//}