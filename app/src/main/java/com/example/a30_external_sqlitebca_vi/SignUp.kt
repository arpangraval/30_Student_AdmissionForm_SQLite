package com.example.a30_external_sqlitebca_vi

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var conhelper = ConnectionHelper(applicationContext)
        var db: SQLiteDatabase = conhelper.readableDatabase
        signupSP_BTN.setOnClickListener {
            if (useridSP_ET.text.toString() == "" || password_SP_ET.text.toString() == "" || password2_SP_ET.text.toString() == "") {
                Toast.makeText(this, "Enter All Credentials", Toast.LENGTH_LONG).show()
            } else if (password_SP_ET.text.toString() != password2_SP_ET.text.toString()) {
                Toast.makeText(this, "Passwords Mismatched", Toast.LENGTH_LONG).show()
            } else {
                var cv = ContentValues()
                cv.put("ID", useridSP_ET.text.toString())
                cv.put("PASSWORD", password_SP_ET.text.toString())
                db.insert("LOGIN", null, cv)

                Toast.makeText(this, "User Created successfully", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, Login::class.java))
            }

        }
        login_SP_TV.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }}
