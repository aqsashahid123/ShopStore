package com.example.onebyte.shopstore.ViewModels

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.generated.callback.OnClickListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.ilhasoft.support.validation.Validator
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.SignupViewModel
import com.example.onebyte.shopstore.databinding.ActivityLoginBinding
import com.example.onebyte.shopstore.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() ,View.OnClickListener, Validator.ValidationListener{

    lateinit var binding: ActivityRegisterBinding
    lateinit var validator: Validator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register)
        binding = DataBindingUtil.setContentView<ActivityRegisterBinding>(this, R.layout.activity_register)
        binding?.signupModel = ViewModelProviders.of(this).get(SignupViewModel::class.java)
        validator = Validator(binding)
        validator.setValidationListener(this)
        btnLogin.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        if (p0 == btnSignup) {
            validator?.toValidate()
        }
    }
    override fun onValidationError() {
        Toast.makeText(this, "Boom", Toast.LENGTH_SHORT).show()
    }

    override fun onValidationSuccess() {
        Toast.makeText(this, "Validation Success", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
