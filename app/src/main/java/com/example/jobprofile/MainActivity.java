package com.example.jobprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button button1, button2;
    ListView joblist;
//    ArrayList<Model> arrayList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.flogin);
        button2 = findViewById(R.id.fregister);
        recyclerView= findViewById(R.id.recycle);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        getpublicjob();

    }
        private void getpublicjob() {
            Call<JobResponses> call = RetrifitClient.getInstance().getApiInterface().getpublicjob();
            Log.d("call getpublicjob: ", String.valueOf(call.request()));
            call.enqueue(new Callback<JobResponses>() {
                @Override
                public void onResponse(Call<JobResponses> call, Response<JobResponses> response) {
                    JobResponses heroList = response.body();
                    Log.d("list size: ", String.valueOf(heroList.getJobs().size()));
                    //Creating an String array for the ListView
//                    String[] heroes = new String[heroList.getJobs().size()];
//
//
//
//                    for (int i = 0; i < heroList.getJobs().size(); i++) {
//                        heroes[i] = heroList.getJobs().get(i).getId() + " \n ID :" +
//                                heroList.getJobs().get(i).getCompany()+"\n Company :"+
//                                heroList.getJobs().get(i).getPosition() +" \n Position :"+
//                                heroList.getJobs().get(i).getJobtype()+"\n job type :"+
//                                heroList.getJobs().get(i).getCreatedBy()+"\n job created by:"+
//                                heroList.getJobs().get(i).getCreatedAt()+"  \n job created at :";
//
//                    }

                    Log.d("heroList: ", heroList.toString());
                    recyclerView.setAdapter(new JobAdapter<JobResponses>(getApplicationContext(), android.R.layout.simple_list_item_1, heroList.getJobs()));
                }

                @Override
                public void onFailure(Call<JobResponses> call, Throwable t) {
                    Log.d("getpublicjob error: ", t.getMessage());
                    t.printStackTrace();
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
}