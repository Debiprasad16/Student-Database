package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText dEtStudentID;
    private EditText dEtStudentName;
    private EditText dEtStudentRollNumber;
    private EditText dEtStudentRegistrationNumber;
    private EditText dEtStudentPhoneNumber;
    private EditText dEtStudentEmailAddress;

    private String SelectedBloodGroup = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dEtStudentID = findViewById(R.id.et_stu_id);
        dEtStudentName = findViewById(R.id.et_stu_name);
        dEtStudentRollNumber = findViewById(R.id.et_stu_roll_number);
        dEtStudentRegistrationNumber = findViewById(R.id.et_stu_registration_number);
        dEtStudentPhoneNumber = findViewById(R.id.et_stu_phone_number);
        dEtStudentEmailAddress = findViewById(R.id.et_stu_email_address);

        Spinner BloodGroup = findViewById(R.id.spn_blood_group);
        String[] dBloodGroups = getResources().getStringArray(R.array.blood_group);

        ArrayAdapter<String> BloodGroupAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dBloodGroups);
        BloodGroup.setAdapter(BloodGroupAdapter);

        BloodGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("Select Student Blood Group")){
                    Toast.makeText(MainActivity.this, "Please Select the Student Blood Group.", Toast.LENGTH_LONG).show();
                }else{
                    SelectedBloodGroup = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(MainActivity.this, SelectedBloodGroup+"Selected", Toast.LENGTH_LONG).show();
                }
                    /*SelectedBloodGroup = dBloodGroups[i];*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void onAdmitStudentClicked(View view){
        String stuID = dEtStudentID.getText().toString();
        String stuName = dEtStudentName.getText().toString();
        String stuRollNumber = dEtStudentRollNumber.getText().toString();
        long stuRegistrationNumber = !dEtStudentRegistrationNumber.getText().toString().isEmpty() ?
                Long.parseLong(dEtStudentRegistrationNumber.getText().toString()):0;
        long stuPhoneNumber = !dEtStudentPhoneNumber.getText().toString().isEmpty() ?
                Long.parseLong(dEtStudentPhoneNumber.getText().toString()):0;
        String stuEmailAddress = dEtStudentEmailAddress.getText().toString();

        if(stuID.isEmpty()){
            Toast.makeText(MainActivity.this, "Please Enter the Student ID.", Toast.LENGTH_LONG).show();
        }else if(stuName.isEmpty()){
            Toast.makeText(MainActivity.this, "Please Enter the Student Name.", Toast.LENGTH_LONG).show();
        }else if(stuRollNumber.isEmpty()){
            Toast.makeText(MainActivity.this, "Please Enter the Student Roll Number.", Toast.LENGTH_LONG).show();
        }else if(stuEmailAddress.isEmpty()){
            Toast.makeText(MainActivity.this, "Please Enter the Student Email Address.", Toast.LENGTH_LONG).show();
        }else if(stuRegistrationNumber==0){
            Toast.makeText(MainActivity.this, "Please Enter the Student Registration Number.", Toast.LENGTH_LONG).show();
        }else if(stuPhoneNumber==0){
            Toast.makeText(MainActivity.this, "Please Enter the Student Phone Number.", Toast.LENGTH_LONG).show();
        }/*else if(SelectedBloodGroup == "Select Student Blood Group"){
            Toast.makeText(MainActivity.this, "Please Select the Student Blood Group.", Toast.LENGTH_LONG).show();
        }*/else{
            Toast.makeText(MainActivity.this, "Successfully Entered Details. Thank you.", Toast.LENGTH_LONG).show();
        }

        if(!stuID.isEmpty() && !stuName.isEmpty() && !stuRollNumber.isEmpty() && stuRegistrationNumber!=0 && stuPhoneNumber!=0 && !stuEmailAddress.isEmpty()) {
            Intent StudentInfo = new Intent(MainActivity.this, ResultActivity.class);
            StudentInfo.putExtra("STUID", stuID);
            StudentInfo.putExtra("STUNAME", stuName);
            StudentInfo.putExtra("STUROLL", stuRollNumber);
            StudentInfo.putExtra("STUREGD", stuRegistrationNumber);
            StudentInfo.putExtra("STUPHONE", stuPhoneNumber);
            StudentInfo.putExtra("STUEMAIL", stuEmailAddress);
            StudentInfo.putExtra("STUBLOOD", SelectedBloodGroup);
            startActivity(StudentInfo);
        }
    }
}