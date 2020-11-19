package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "student_info";

    private static final String COL_ID = "id";
    private static final String COL_STU_ID = "stu_id";
    private static final String COL_STU_NAME = "stu_name";
    private static final String COL_STU_ROLL = "stu_roll";
    private static final String COL_STU_REGN = "stu_regn";
    private static final String COL_STU_PHONE = "stu_phone";
    private static final String COL_STU_EMAIL = "stu_email";
    private static final String COL_STU_BLOOD = "stu_blood";

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_STU_ID+" TEXT,"+
            COL_STU_NAME + " TEXT,"+COL_STU_ROLL+" TEXT,"+COL_STU_REGN+" INTEGER,"+COL_STU_PHONE+" INTEGER,"+COL_STU_EMAIL+" TEXT,"+COL_STU_BLOOD+" TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "studentinfo.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertDataToDatabase(SQLiteDatabase db, Student student){
        ContentValues contentValues = new ContentValues();
    }
}
