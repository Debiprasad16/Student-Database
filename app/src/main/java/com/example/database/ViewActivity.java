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

public class ViewActivity extends AppCompatActivity implements StudentListAdapter.StudentClickListener {

    private DatabaseHelper dbHelper;
    private RecyclerView dRcStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

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
        adapter.setListener(ViewActivity.this);

        dRcStudents.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 555 && resultCode == Activity.RESULT_OK) {
            setDataToAdapter();
        }else if(requestCode == 900 &&  resultCode == Activity.RESULT_OK) {
            setDataToAdapter();
        }
    }

    @Override
    public void onEditStudentClicked(Student student) {
        Intent editIntent = new Intent(ViewActivity.this, MainActivity.class);
        editIntent.putExtra(MainActivity.BUNDLE_IS_EDIT, true);
        editIntent.putExtra(MainActivity.BUNDLE_STUDENT, student);
        startActivityForResult(editIntent, 900);
    }

    @Override
    public void onDeleteStudentClicked(Student student) {
        dbHelper.deleteStudent(student, dbHelper.getWritableDatabase());
        setDataToAdapter();
    }
}