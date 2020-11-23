package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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

        if(StudentData!=null) {
            Student studentDetails = (Student) StudentData.getSerializable("STUDENT");
            Toast.makeText(ResultActivity.this, "Welcome " + studentDetails.getStudentName() + ".", Toast.LENGTH_LONG).show();

            dTvStudentID.setText(studentDetails.getStudentID());
            dTvStudentName.setText(studentDetails.getStudentName());
            dTvStudentRoll.setText(studentDetails.getStudentRollNumber());
            dTvStudentRegd.setText(String.valueOf(studentDetails.getStudentRegistrationNumber()));
            dTvStudentPhone.setText(String.valueOf(studentDetails.getStudentPhoneNumber()));
            dTvEmail.setText(studentDetails.getStudentEmailAddress());
            dTvStudentBloodGroup.setText(studentDetails.getStudentBloodGroup());
        }
    }
}