package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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
        contentValues.put(COL_STU_ID, student.getStudentID());
        contentValues.put(COL_STU_NAME, student.getStudentName());
        contentValues.put(COL_STU_ROLL, student.getStudentRollNumber());
        contentValues.put(COL_STU_REGN, student.getStudentRegistrationNumber());
        contentValues.put(COL_STU_PHONE, student.getStudentPhoneNumber());
        contentValues.put(COL_STU_EMAIL, student.getStudentEmailAddress());
        contentValues.put(COL_STU_BLOOD, student.getStudentBloodGroup());

        db.insert(TABLE_NAME, null, contentValues);
    }
    public  ArrayList<Student> getStudentsFromDatabase(SQLiteDatabase db) {
        ArrayList<Student> studentList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);

        if(cursor.moveToFirst()){
            do{
                Student studentInfo = new Student();
                studentInfo.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                studentInfo.setStudentID(cursor.getString(cursor.getColumnIndex(COL_STU_ID)));
                studentInfo.setStudentName(cursor.getString(cursor.getColumnIndex(COL_STU_NAME)));
                studentInfo.setStudentRollNumber(cursor.getString(cursor.getColumnIndex(COL_STU_ROLL)));
                studentInfo.setStudentRegistrationNumber(cursor.getLong(cursor.getColumnIndex(COL_STU_REGN)));
                studentInfo.setStudentPhoneNumber(cursor.getLong(cursor.getColumnIndex(COL_STU_PHONE)));
                studentInfo.setStudentEmailAddress(cursor.getString(cursor.getColumnIndex(COL_STU_EMAIL)));
                studentInfo.setStudentBloodGroup(cursor.getString(cursor.getColumnIndex(COL_STU_BLOOD)));
                studentList.add(studentInfo);
            }while (cursor.moveToNext());
        }

        return studentList;
    }

    public void deleteStudent(Student student, SQLiteDatabase database){
        database.delete(TABLE_NAME, COL_ID+"="+student.getId(), null);
    }

    public void updateStudent(Student student, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_STU_ID, student.getStudentID());
        contentValues.put(COL_STU_NAME, student.getStudentName());
        contentValues.put(COL_STU_ROLL, student.getStudentRollNumber());
        contentValues.put(COL_STU_REGN, student.getStudentRegistrationNumber());
        contentValues.put(COL_STU_PHONE, student.getStudentPhoneNumber());
        contentValues.put(COL_STU_EMAIL, student.getStudentEmailAddress());
        contentValues.put(COL_STU_BLOOD, student.getStudentBloodGroup());

        database.update(TABLE_NAME, contentValues, COL_ID+"="+student.getId(), null);
    }
}
