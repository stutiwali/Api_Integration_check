package com.example.api_integration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Helooooo", Toast.LENGTH_SHORT).show();

        api=RetrofitInstance.getRetrofit().create(Api.class);

        api.getPosts().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {

                if(response.body().size()>0)
                {
                    Toast.makeText(getApplicationContext(),"List is not empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"List is empty",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {


                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),"Please turn on internet connection", Toast.LENGTH_LONG).show();


            }
        });


    }
}