package com.example.capstoneproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.capstoneproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.AsyncTask;

import java.util.List;
public class showUsers extends AppCompatActivity {

    private FloatingActionButton buttonAddUser;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        recyclerView = findViewById(R.id.recyclerview_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonAddUser = findViewById(R.id.fabRooM);
        buttonAddUser.setOnClickListener(v -> {
            Intent intent = new Intent(showUsers.this,Register.class);
            startActivity(intent);
        });
        getUsers();
    }

    private void getUsers(){
        class GetUsers extends AsyncTask<Void, Void, List<UserOrgRoom>>{

            @Override
            protected List<UserOrgRoom> doInBackground(Void... voids) {
                List<UserOrgRoom> userList = DataBaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .userOrgDAO()
                        .getAll();
                return userList;
            }
            @Override
            protected void onPostExecute(List<UserOrgRoom> usr){
                super.onPostExecute(usr);
                UserOrgAdapter adapter = new UserOrgAdapter(showUsers.this, usr);
                recyclerView.setAdapter(adapter);

            }
        }

        GetUsers gt = new GetUsers();
        gt.execute();
    }



}