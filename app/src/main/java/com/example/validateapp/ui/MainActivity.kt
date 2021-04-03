package com.example.validateapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.validateapp.api.MakeNetworkCall
import com.example.validateapp.api.PasswordValidator
import com.example.validateapp.api.RulesBuilder
import com.example.validateapp.data.Rules
import com.example.validateapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MakeNetworkCall.GetTheResponse {

    private val makeNetworkCall = MakeNetworkCall(this)
    private lateinit var binding: ActivityMainBinding
    private lateinit var rules: Rules
    private val duration = Toast.LENGTH_LONG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        makeNetworkCall.getTheRule()

        binding.apply {
            button.setOnClickListener {
                if (oldPass.text.toString() != newPass.text.toString()) {
                    if (newPass.text.toString() == newPass2.text.toString()) {

                        val rulesBuilder = RulesBuilder(rules, newPass.text.toString(), newPass2.text.toString())
                        val passwordValidator = PasswordValidator()
                        if (passwordValidator.validatePassword(rulesBuilder.createPasswordPolicy())) {
                            val toast = Toast.makeText(applicationContext, "password changed", duration)
                            toast.show()
                        } else {
                            val toast = Toast.makeText(applicationContext, "there is problem", duration)
                            toast.show()
                        }

                    } else {
                        val toast = Toast.makeText(applicationContext, "new passwords do not match", duration)
                        toast.show()
                    }
                } else {
                    val toast = Toast.makeText(applicationContext, "old password cannot be new password", duration)
                    toast.show()
                }
            }
        }
    }

    override fun getResponse(rules: Rules) {
        this.rules = rules
    }
}
