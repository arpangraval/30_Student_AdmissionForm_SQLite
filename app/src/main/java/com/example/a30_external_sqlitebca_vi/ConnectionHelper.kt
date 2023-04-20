package com.example.a30_external_sqlitebca_vi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConnectionHelper(context: Context): SQLiteOpenHelper(context,"CHARUSAT",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE LOGIN(ID TEXT,PASSWORD TEXT)")
        p0?.execSQL("CREATE TABLE ADMISSIONS(SNAME TEXT, EMAIL TEXT, MOBILE TEXT, GENDER TEXT, COURSE TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}