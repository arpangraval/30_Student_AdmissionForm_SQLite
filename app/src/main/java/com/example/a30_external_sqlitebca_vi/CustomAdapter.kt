package com.example.a30_external_sqlitebca_vi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(
    var form: Form,
    var sname: ArrayList<String>,
    var scourse: ArrayList<String>,
    var smobile: ArrayList<String>)
    : BaseAdapter() {
    override fun getCount(): Int {
       return sname.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inview = LayoutInflater.from(form).inflate(R.layout.listviewitem,p2, false)
        var snamee =inview.findViewById<TextView>(R.id.sname_F_TV)
        var scoursee = inview.findViewById<TextView>(R.id.scourse_F_TV)
        var smobilee = inview.findViewById<TextView>(R.id.smobile_F_TV)

        snamee.text = sname[p0]
        scoursee.text = scourse[p0]
        smobilee.text = smobile[p0]

        return inview
    }

}
