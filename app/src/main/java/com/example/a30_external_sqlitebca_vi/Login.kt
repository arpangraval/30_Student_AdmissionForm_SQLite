package com.example.a30_external_sqlitebca_vi

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var conhelper = ConnectionHelper(applicationContext)
        var db: SQLiteDatabase =conhelper.writableDatabase

        loginBTN.setOnClickListener {
            if(usridET.text.toString()=="" || passwordET.text.toString()==""){
                Toast.makeText(this,"Enter All Credentials",Toast.LENGTH_LONG).show()
            }
            else{
                var args = listOf<String>(usridET.text.toString(), passwordET.text.toString()).toTypedArray()
                var rs = db.rawQuery("SELECT * FROM LOGIN WHERE ID = ? AND PASSWORD = ?",args)
                if(rs.moveToNext()){
                    startActivity(Intent(this,AdmissionForm::class.java))
                }
                else
                {
                    Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_LONG).show()
                }
            }
        }
       signupTV.setOnClickListener {
           startActivity(Intent(this,SignUp::class.java))
       }
   }
}

