package com.example.capstoneproject;

import java.io.Serializable;
import java.sql.Date;

import androidx.room.*;

@Entity(tableName = "Users")
public class UserOrgRoom implements Serializable{
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "First_Name")
    private String fname;

    @ColumnInfo(name = "Last_name")
    private String lname;

    @ColumnInfo(name = "Emial")
    private String email;

    @ColumnInfo(name = "Date_of_birth")
    private Date dob;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "Zip_code")
    private String zipcode;

    @ColumnInfo(name = "User_name")
    private String username;

    @ColumnInfo(name = "Password")
    private String password;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
