package com.example.onebyte.shopstore

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.ilhasoft.support.validation.Validator
import com.example.onebyte.shopstore.ViewModels.CheckoutViewModel
import com.example.onebyte.shopstore.databinding.ActivityCheckoutBinding
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity(), View.OnClickListener, Validator.ValidationListener {


    lateinit var binding: ActivityCheckoutBinding
    lateinit var validator: Validator
    override fun onClick(p0: View?) {
        if (p0 === btnCheckout) {
            validator.toValidate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_checkout)
        binding = DataBindingUtil.setContentView<ActivityCheckoutBinding>(this, R.layout.activity_checkout)
        binding?.checkoutViewModel = ViewModelProviders.of(this).get(CheckoutViewModel::class.java)

        setSupportActionBar(toolbar)
        //toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_left)
        toolbar.navigationIcon= getDrawable(R.drawable.ic_left)
        toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }

        validator = Validator(binding)
        validator.setValidationListener(this)
        btnCheckout.setOnClickListener(this)
//        btnLogin.setOnClickListener(this)
    }

    override fun onValidationError() {
    //    Toast.makeText(this, "Boom", Toast.LENGTH_SHORT).show()
    }

    override fun onValidationSuccess() {
        Toast.makeText(this, "Validation Success", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
