package com.daemon.android.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.daemon.android.criminalintent.database.CrimeDbSchema.CrimeTable;

/**
 * Created by Chang on 05/28/16.
 */
public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CrimeTable.NAME +"("+
            " _id integer primary key autoincrement, "+
            CrimeTable.Cols.UUID + ", "+
            CrimeTable.Cols.TITLE + ", "+
            CrimeTable.Cols.DATE + ", "+
            CrimeTable.Cols.SOLVED + ", "+
            CrimeTable.Cols.SUSPECT +
                ")"
             );//SQLite采用动态数据类型,根据录入类型来确定哪种类型
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
