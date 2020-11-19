package com.example.database;

import java.io.Serializable;
import java.security.PublicKey;

public class Student implements Serializable{
    /*public String StudentID;
    public String StudentName;
    public String StudentRollNumber;
    public long StudentRegistrationNumber;
    public long  StudentPhoneNumber;
    public String StudentEmailAddress;
    public String StudentBloodGroup;*/

    private String StudentID;
    private String StudentName;
    private String StudentRollNumber;
    private long StudentRegistrationNumber;
    private long  StudentPhoneNumber;
    private String StudentEmailAddress;
    private String StudentBloodGroup;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentRollNumber() {
        return StudentRollNumber;
    }

    public void setStudentRollNumber(String studentRollNumber) {
        StudentRollNumber = studentRollNumber;
    }

    public long getStudentRegistrationNumber() {
        return StudentRegistrationNumber;
    }

    public void setStudentRegistrationNumber(long studentRegistrationNumber) {
        StudentRegistrationNumber = studentRegistrationNumber;
    }

    public long getStudentPhoneNumber() {
        return StudentPhoneNumber;
    }

    public void setStudentPhoneNumber(long studentPhoneNumber) {
        StudentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentEmailAddress() {
        return StudentEmailAddress;
    }

    public void setStudentEmailAddress(String studentEmailAddress) {
        StudentEmailAddress = studentEmailAddress;
    }

    public String getStudentBloodGroup() {
        return StudentBloodGroup;
    }

    public void setStudentBloodGroup(String studentBloodGroup) {
        StudentBloodGroup = studentBloodGroup;
    }
}
