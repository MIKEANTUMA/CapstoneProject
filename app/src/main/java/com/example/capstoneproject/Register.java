package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.capstoneproject.R;

import java.sql.Date;

public class Register extends AppCompatActivity {

    private EditText editFirstName,editLastName,editEmail,editDoB,editAddress,editZipCode,editUsername,editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editFirstName = findViewById(R.id.editTextFirstName);
        editLastName = findViewById(R.id.editTextLastName);
        editEmail = findViewById(R.id.editTextEmail);
        editDoB = findViewById(R.id.editTextDoB);
        editAddress = findViewById(R.id.editTextAddress);
        editZipCode = findViewById(R.id.editTextZipCode);
        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);
        findViewById(R.id.button_register).setOnClickListener(v -> {
            saveUserOrg();
        });
    }

    private void saveUserOrg(){
        final String firstname = editFirstName.getText().toString().trim();
        final String lastname = editLastName.getText().toString().trim();
        final String email = editEmail.getText().toString().trim();
        final String DoB = editDoB.getText().toString().trim();
        final String address = editAddress.getText().toString().trim();
        final String zipcode = editZipCode.getText().toString().trim();
        final String username = editUsername.getText().toString().trim();
        final String password = editPassword.getText().toString().trim();

        if(firstname.isEmpty()){
            editFirstName.setError("Field required");
            editFirstName.requestFocus();
        }
        if(lastname.isEmpty()){
            editLastName.setError("Field required");
            editLastName.requestFocus();
        }
        if(email.isEmpty()){
            editEmail.setError("Field required");
            editEmail.requestFocus();
        }
        if(username.isEmpty()){
            editEmail.setError("Field required");
            editEmail.requestFocus();
        }
        if(password.isEmpty()){
            editPassword.setError("Field required");
            editPassword.requestFocus();
        }

        class SaveUserOrg extends AsyncTask<Void, Void, Void>{
            @Override
            protected Void doInBackground(Void... voids){
                //creating user
                UserOrgRoom user = new UserOrgRoom();
                user.setFname(firstname);
                user.setLname(lastname);
                user.setEmail(email);
                user.setDob(DoB);
                user.setAddress(address);
                user.setZipcode(zipcode);
                user.setUsername(username);
                user.setPassword(password);

                //adding to database
                DataBaseClient.getInstance(getApplication()).getAppDatabase()
                        .userOrgDAO()
                        .insert(user);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplication(), showUsers.class));
                Toast.makeText(getApplication(), "User Saved", Toast.LENGTH_LONG).show();
            }
        }
        SaveUserOrg st = new SaveUserOrg();
        st.execute();

    }
}