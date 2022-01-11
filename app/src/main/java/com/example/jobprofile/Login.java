package com.example.jobprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
EditText Email, Password;
Button buttonl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email =findViewById(R.id.email);
        Password=findViewById(R.id.password);
        buttonl=findViewById(R.id.login);

//        buttonl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Login.this,Myjobs.class);
//                startActivity(intent);
//            }
//        });


        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<LoginResponce> call = RetrifitClient.getInstance().getApiInterface().login(Email.getText().toString(), Password.getText().toString());
                call.enqueue(new Callback<LoginResponce>() {
                    @Override
                    public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {

                        if (response.isSuccessful()) {

                               Intent intent=new Intent(Login.this,MainActivity.class);
                                startActivity(intent);

                                Toast.makeText(getApplicationContext(), ""+response.body().getUser(), Toast.LENGTH_SHORT).show();

                            }
                        else {
                            Toast.makeText(getApplicationContext(), "" + response.body().getUser(), Toast.LENGTH_SHORT).show();

                       }
                    }

                //}

                    @Override
                    public void onFailure(Call<LoginResponce> call, Throwable t) {
                        Log.e("userListError", ""+t.getMessage());

                    }
                });

            }
        });
    }
}