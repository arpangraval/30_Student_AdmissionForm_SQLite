package com.example.a30_external_sqlitebca_vi

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form.*

class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        var helper = ConnectionHelper(applicationContext)
        var db: SQLiteDatabase = helper.readableDatabase
        var rss: Cursor = db.rawQuery("SELECT * FROM ADMISSIONS",null)
        if(rss.count>0) {
            val sname = ArrayList<String>()
            val scourse = ArrayList<String>()
            val smobile = ArrayList<String>()
            rss.moveToFirst()
            while (rss.moveToNext()) {
                sname.add(rss.getString(0))
                scourse.add(rss.getString(4))
                smobile.add(rss.getString(2))
            }
            var myadapter = CustomAdapter(this, sname, scourse,smobile)
            lview.adapter = myadapter
        }
        else
        {
            Toast.makeText(this, "No Records Found", Toast.LENGTH_LONG).show()

        }
        logoutBTN_F.setOnClickListener { startActivity(Intent(this,Login::class.java)) }
    }
}