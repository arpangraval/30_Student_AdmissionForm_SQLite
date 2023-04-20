package com.example.a30_external_sqlitebca_vi

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admission_form.*


class AdmissionForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admission_form)
        var conhelper = ConnectionHelper(applicationContext)
        var db: SQLiteDatabase =conhelper.writableDatabase
        var courses = arrayOf("Select Course","BCA","BSc.IT","MCA","MSc.IT")
        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,courses)

        scourse_AF_SP.adapter = adapter
        var course =""
        scourse_AF_SP.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                course =scourse_AF_SP.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        button.setOnClickListener {

            var gen= ""
            var genid = sgender_AF_RG.checkedRadioButtonId
            when(genid)
            {

                R.id.male_AF_RB -> gen = "Male"
                R.id.female_AF_RB -> gen = "Female"
                else-> gen=""

            }

            if(gen=="" || course == "" || course == "Select Course" || snameAF_ET.text.toString() == "" || semail_AF_ET.text.toString() == "" || smobile_AF_ET.text.toString()=="")
            {
                Toast.makeText(this, "Enter all the Details or select course or gender",Toast.LENGTH_LONG).show()
            }
            else
            {
                var cv = ContentValues()
                cv.put("SNAME",snameAF_ET.text.toString())
                cv.put("EMAIL",semail_AF_ET.text.toString())
                cv.put("MOBILE",smobile_AF_ET.text.toString())
                cv.put("GENDER",gen)
                cv.put("COURSE",course)
                var rs = db.rawQuery("SELECT * FROM ADMISSIONS",null)
                var binsert = rs.count
                db.insert("ADMISSIONS",null,cv)
                rs.requery()
                var rs2 = db.rawQuery("SELECT * FROM ADMISSIONS",null)
                var ainsert = rs2.count
                if(ainsert > binsert)
                {
                    Toast.makeText(this,"Form Submitted",Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,Form::class.java))
                }
                else
                {
                    Toast.makeText(this,"Form not Submitted",Toast.LENGTH_LONG).show()
                }



            }
        }
    }
}