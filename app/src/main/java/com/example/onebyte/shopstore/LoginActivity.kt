package com.example.onebyte.shopstore

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.ilhasoft.support.validation.Validator
import com.example.onebyte.shopstore.ViewModels.LoginViewModel
import com.example.onebyte.shopstore.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, Validator.ValidationListener {


    lateinit var binding: ActivityLoginBinding
    lateinit var validator: Validator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding?.loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        validator = Validator(binding)
        validator.setValidationListener(this);
        btnLogin.setOnClickListener(this)
    }

    override fun onValidationError() {
     //   Toast.makeText(this, "Boom", Toast.LENGTH_SHORT).show()
    }

    override fun onValidationSuccess() {
        Toast.makeText(this, "Validation Success", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(p0: View?) {
        if (p0 == btnLogin) {
            validator?.toValidate()
        }
    }
}
