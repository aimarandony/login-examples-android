package com.example.ec02_mobiledevelopment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var etUser:TextInputLayout? = null
    var etPass:TextInputLayout? = null
    var btnLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setReferences()
    }

    private fun setReferences() {
        etUser = findViewById(R.id.etUser)
        etPass = findViewById(R.id.etPass)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun validateUser(): Boolean {
        val user = etUser!!.editText!!.text.toString().trim()
        return when{
            user.isEmpty() -> { etUser!!.error = "Username is empty"; false }
            user.length > 15 -> { etUser!!.error = "Username is empty"; false }
            else -> { etUser!!.error = null; true }
        }
    }

    private fun validatePass(): Boolean {
        val pass = etPass!!.editText!!.text.toString().trim()

        return when{
            pass.isEmpty() -> { etPass!!.error = "Password is empty"; false }
            pass.length > 8 -> { etPass!!.error = "Password is too long"; false }
            else -> { etPass!!.error = null; true }
        }
    }

    fun login(view: View) {
        if (!validateUser() or !validatePass()) return
        Toast.makeText(this, "Successfully Logged In " + etUser!!.editText!!.text, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
