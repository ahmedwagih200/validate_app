package com.example.validateapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.validateapp.api.CheckPasswordRules
import com.example.validateapp.api.DisplayRules
import com.example.validateapp.api.MakeNetWorkCall
import com.example.validateapp.data.Rules
import com.example.validateapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MakeNetWorkCall.GetTheResponse, DisplayRules.DisplayTheRule,
        CheckPasswordRules.CheckForPass {

    private val makeNetWorkCall = MakeNetWorkCall(this)
    private lateinit var binding: ActivityMainBinding
    private lateinit var rules: Rules
    private val duration = Toast.LENGTH_LONG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        makeNetWorkCall.getTheRule()

        binding.apply {
            button.setOnClickListener {
                if (oldPass.text.toString() != newPass2.text.toString()) {
                    if (newPass.text.toString() == newPass2.text.toString()) {
                        CheckPasswordRules(rules, this@MainActivity, binding.oldPass.toString(), newPass.text.toString())
                                .validateThePass()
                    } else {
                        val toast = Toast.makeText(applicationContext, "new passwords do not match", duration)
                        toast.show()
                    }
                } else {
                    val toast = Toast.makeText(applicationContext, "old pass cannot be new pass", duration)
                    toast.show()
                }
            }
        }
    }

    override fun getResponse(rules: Rules) {
        this.rules = rules
        DisplayRules(rules, this).displayPasswordRules()
    }

    override fun displayPassRule(passRule: String) {
        binding.textView.text = passRule
    }

    override fun checkForPass(isPasswordNotValid: Boolean, string: String) {
        if (isPasswordNotValid) {
            val toast = Toast.makeText(applicationContext, string, duration)
            toast.show()
        } else {
            val toast = Toast.makeText(applicationContext, string, duration)
            toast.show()
        }
    }
}
