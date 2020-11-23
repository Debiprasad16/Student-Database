package com.example.database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private RecyclerView dRcStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        /*TextView dTvStudentID = findViewById(R.id.tv_stu_id);
        TextView dTvStudentName = findViewById(R.id.tv_stu_name);
        TextView dTvStudentRoll = findViewById(R.id.tv_stu_roll_number);
        TextView dTvStudentRegd = findViewById(R.id.tv_stu_registration_number);
        TextView dTvStudentPhone = findViewById(R.id.tv_stu_phone_number);
        TextView dTvEmail = findViewById(R.id.tv_stu_email_address);
        TextView dTvStudentBloodGroup = findViewById(R.id.tv_stu_blood_group);

        Bundle StudentData = getIntent().getExtras();

        if(StudentData!=null) {
            Student studentDetails = (Student) StudentData.getSerializable("STUDENT");
            Toast.makeText(ViewActivity.this, "Welcome " + studentDetails.getStudentName() + ".", Toast.LENGTH_LONG).show();

            dTvStudentID.setText(studentDetails.getStudentID());
            dTvStudentName.setText(studentDetails.getStudentName());
            dTvStudentRoll.setText(studentDetails.getStudentRollNumber());
            dTvStudentRegd.setText(String.valueOf(studentDetails.getStudentRegistrationNumber()));
            dTvStudentPhone.setText(String.valueOf(studentDetails.getStudentPhoneNumber()));
            dTvEmail.setText(studentDetails.getStudentEmailAddress());
            dTvStudentBloodGroup.setText(studentDetails.getStudentBloodGroup());
        }*/

        dRcStudents = findViewById(R.id.rc_student_list);
        dRcStudents.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        dbHelper = new DatabaseHelper(ViewActivity.this);
        setDataToAdapter();
    }

    public void onAddStudentClicked(View view){
        startActivityForResult(new Intent(ViewActivity.this, MainActivity.class), 555);
    }

    private void setDataToAdapter(){
        ArrayList<Student> students = dbHelper.getStudentsFromDatabase(dbHelper.getReadableDatabase());
        StudentListAdapter adapter = new StudentListAdapter(ViewActivity.this, students);

        dRcStudents.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 555 && resultCode == Activity.RESULT_OK){
            setDataToAdapter();
        }
    }
}