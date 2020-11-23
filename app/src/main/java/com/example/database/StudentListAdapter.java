package com.example.database;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;
import java.util.Random;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentListHolder> {

    private Context context;
    private ArrayList<Student> studentList;

    public StudentListAdapter(Context context1, ArrayList<Student> studentLists){
        this.context = context1;
        this.studentList = studentLists;
    }

    @NonNull
    @Override
    public StudentListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StudentListHolder holder = new StudentListHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_student_info, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListHolder holder, int position) {
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.dLlrndColor.setBackgroundColor(currentColor);
        Student currentStudent = studentList.get(position);
        holder.dTvStudentID.setText(currentStudent.getStudentID());
        holder.dTvStudentName.setText(currentStudent.getStudentName());
        holder.dTvStudentRoll.setText(currentStudent.getStudentRollNumber());
        holder.dTvStudentRegn.setText(String.valueOf(currentStudent.getStudentRegistrationNumber()));
        holder.dTvStudentPhone.setText(String.valueOf(currentStudent.getStudentPhoneNumber()));
        holder.dTvStudentEmail.setText(currentStudent.getStudentEmailAddress());
        holder.dTvStudentBloodGroup.setText(currentStudent.getStudentBloodGroup());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentListHolder extends RecyclerView.ViewHolder{

       private TextView dTvStudentID;
       private TextView dTvStudentName;
       private TextView dTvStudentRoll;
       private TextView dTvStudentRegn;
       private TextView dTvStudentPhone;
       private TextView dTvStudentEmail;
       private TextView dTvStudentBloodGroup;
       private LinearLayout dLlrndColor;

        public StudentListHolder(@NonNull View itemView) {
            super(itemView);
            dLlrndColor = itemView.findViewById(R.id.rnd_color);
            dTvStudentID = itemView.findViewById(R.id.tv_stu_id);
            dTvStudentName = itemView.findViewById(R.id.tv_stu_name);
            dTvStudentRoll = itemView.findViewById(R.id.tv_stu_roll_number);
            dTvStudentRegn = itemView.findViewById(R.id.tv_stu_registration_number);
            dTvStudentPhone = itemView.findViewById(R.id.tv_stu_phone_number);
            dTvStudentEmail = itemView.findViewById(R.id.tv_stu_email_address);
            dTvStudentBloodGroup = itemView.findViewById(R.id.tv_stu_blood_group);
        }
    }
}
