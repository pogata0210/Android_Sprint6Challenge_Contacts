package com.example.pablo.android_sprint6challenge_contacts;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Activity activity;
    private ListAdapter listAdapter;
    private ArrayList<MyContacts> arrayList;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        listAdapter = new ListAdapter(arrayList, activity);
        recyclerView.setAdapter(listAdapter);
        ApiDao.getAllContacts(new ApiDao.ObjectCallback<ArrayList<MyContacts>>() {
            @Override
            public void returnObjects(ArrayList<MyContacts> result) {
                for (final MyContacts i : result) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            arrayList.add(i);
                            listAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }
}