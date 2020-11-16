package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView dTvStudentID = findViewById(R.id.tv_stu_id);
        TextView dTvStudentName = findViewById(R.id.tv_stu_name);
        TextView dTvStudentRoll = findViewById(R.id.tv_stu_roll_number);
        TextView dTvStudentRegd = findViewById(R.id.tv_stu_registration_number);
        TextView dTvStudentPhone = findViewById(R.id.tv_stu_phone_number);
        TextView dTvEmail = findViewById(R.id.tv_stu_email_address);
        TextView dTvStudentBloodGroup = findViewById(R.id.tv_stu_blood_group);

        Bundle StudentData = getIntent().getExtras();

        if(StudentData!=null){
            String StudentID = StudentData.getString("STUID");
            String StudentName = StudentData.getString("STUNAME");
            String StudentRollNumber = StudentData.getString("STUROLL");
            long  StudentRegistrationNumber = StudentData.getLong("STUREGD");
            long StudentPhoneNumber = StudentData.getLong("STUPHONE");
            String StudentEmail = StudentData.getString("STUEMAIL");
            String StudentBloodGroup = StudentData.getString("STUBLOOD");

            dTvStudentID.setText(StudentID);
            dTvStudentName.setText(StudentName);
            dTvStudentRoll.setText(StudentRollNumber);
            dTvStudentRegd.setText(String.valueOf(StudentRegistrationNumber));
            dTvStudentPhone.setText(String.valueOf(StudentPhoneNumber));
            dTvEmail.setText(StudentEmail);
            dTvStudentBloodGroup.setText(StudentBloodGroup);
        }
    }
}