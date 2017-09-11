package com.example.aff02.newrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewActivity extends AppCompatActivity {

    private Button btnshow;
    private DatabaseHelper databaseHelper;
    private RecyclerView recycler;
    private RecycleAdapter recycleAdapter;
    List<DataModel> dataModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

       btnshow = (Button)findViewById(R.id.btnshowlist);
        dataModelsList = new ArrayList<DataModel>();
        recycler = (RecyclerView) findViewById(R.id.recyclerview);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseHelper = new DatabaseHelper(RecycleviewActivity.this);
                dataModelsList = databaseHelper.getData();
                recycleAdapter = new RecycleAdapter(dataModelsList);

                RecyclerView.LayoutManager llm = new LinearLayoutManager(getApplicationContext());
                recycler.setLayoutManager(llm);
                recycler.setItemAnimator(new DefaultItemAnimator());
                recycler.setAdapter(recycleAdapter);
            }
        });
    }
}
