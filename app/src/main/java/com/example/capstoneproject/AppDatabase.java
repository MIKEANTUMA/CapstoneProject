package com.example.capstoneproject;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserOrgRoom.class},version = 1)
abstract class AppDatabse extends RoomDatabase{
    public abstract UserOrgDAO userOrgDAO();
}