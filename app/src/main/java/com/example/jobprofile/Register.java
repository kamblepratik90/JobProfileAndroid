package com.example.jobprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
EditText name,email,password;
Button registerX;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        onClickListener();
    }
    private void onClickListener() {

        registerX.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().length() == 0) {
                    name.setError("name not entered");
                    name.requestFocus();

                } else if (email.getText().toString().length() == 0) {
                    email.setError("email not entered");
                    email.requestFocus();
                } else if (password.getText().toString().length() == 0) {
                    password.setError("password required");
                    password.requestFocus();

                } else {
                    /*Intent intent = new Intent(Registration.this, Login.class);
                    intent.putExtra("name", ""+name.getText().toString());
                    intent.putExtra("mobileNumber", ""+mobile.getText().toString());
                    intent.putExtra("address", ""+address.getText().toString());
                    intent.putExtra("email", ""+email.getText().toString());

                    intent.putExtra("password", ""+password.getText().toString());
                    startActivity(intent);*/

                    onSubmit();

                }

            }
        });
    }
        private void onSubmit() {
        Log.d("in method on click","on submit");
            String Name, Email, Password;
            Name = name.getText().toString();
            Email = email.getText().toString();
            Password = password.getText().toString();



            Call<LoginResponce> call = RetrifitClient.getInstance().getApiInterface().create(new RegisterInfo(Name,Email,Password));
            Log.d("call", String.valueOf(call.request()));
            call.enqueue(new Callback<LoginResponce>() {

                @Override
                public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {

                    LoginResponce loginResponce = response.body();

                    Log.d("call click", String.valueOf(response));
                    if (response.isSuccessful()) {

                       if (response.body().getMessage().equalsIgnoreCase("true")) {
                            Log.d("message", response.body().getMessage());
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(getApplicationContext(), loginResponce.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                }
                @Override
                public void onFailure(Call<LoginResponce> call, Throwable t) {
                    Log.d("failure",t.getMessage());
                    Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                }
            });

        }
        public void initView(){

            name = findViewById(R.id.name);
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);
            registerX = findViewById(R.id.registerX);

    }
}