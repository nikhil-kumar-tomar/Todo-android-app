package com.example.myapplication.activities;
import com.example.myapplication.R;
import com.example.myapplication.adapters.CustomAdapter;
import  com.example.myapplication.tasks.Task;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Task task = Task.getTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CustomAdapter customAdapter = new CustomAdapter(this, task.allTasks(), task.allTasksIds());
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void SwitchToMainActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }


}
