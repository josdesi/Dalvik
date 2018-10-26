package com.example.jos.demorest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;



public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    ListView list;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,titles);
        list = findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        getPosts();

    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        PostService postService = retrofit.create(PostService.class);


        Call<List<Post>> call = postService.getPost();




        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://52.1.210.173:8081/flex-api/services/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        PostService postService2 = retrofit2.create(PostService.class);
        Call<List<ResponseUser>> call2 = postService2.getUser();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                for(Post post : response.body()) {
                    titles.add(post.getTitle());
                }
                Log.d( TAG, "isServiceOk: SUCCESS ... "+ titles);

                arrayAdapter.notifyDataSetChanged();
                // list.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });


        call2.enqueue(new Callback<List<ResponseUser>>() {
            @Override
            public void onResponse(Call<List<ResponseUser>> call, Response<List<ResponseUser>> response) {

                Log.d( TAG, "isServiceOk: SUCCESS 2 ... "+ response.body());

                arrayAdapter.notifyDataSetChanged();
                // list.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<ResponseUser>> call, Throwable t) {
            }
        });
    }

}
