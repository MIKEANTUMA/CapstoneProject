package com.example.capstoneproject;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

public class DataBaseClient {

    private Context mCtx;
    private static DataBaseClient mInstance;

    //our app database object
    private AppDatabse appDatabase;

    private DataBaseClient(Context mCtx){
        this.mCtx = mCtx;

        //creating the app database with room database builder
        //Users is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabse.class, "Cheesy").build();
    }

    public static synchronized  DataBaseClient getInstance(Context mCtx){
        if(mInstance == null){
            mInstance = new DataBaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabse getAppDatabase(){return appDatabase;}
}
