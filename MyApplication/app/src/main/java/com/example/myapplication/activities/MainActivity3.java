package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.tasks.Task;

public class MainActivity3 extends AppCompatActivity {

    Task task = Task.getTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Task task = Task.getTask();

        int id = getIntent().getIntExtra("id", -1);
        String str_task = getIntent().getStringExtra("text");

        EditText editText = findViewById(R.id.textbox2);
        editText.setText(str_task);

        TextView idTextView = findViewById(R.id.textview3);
        idTextView.setText(String.valueOf(id));

        Button updatebutton = findViewById(R.id.updatebutton);
        Button deletebutton = findViewById(R.id.deletebutton);
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                updateTask(id, editText.getText().toString(), view);
            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                deleteTask(id, view);
            }
        });

    }

    public void switchToMainActivity1(View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(intent);
    }
    public void deleteTask(int id, View view)
    {
//        Task task = Task.getTask();
        task.deleteTask(id);
        switchToMainActivity1(view);
    }
    public void updateTask(int id, String to_do_task, View view)
    {
//        Task task = Task.getTask();
        task.updateTask(id, to_do_task);
        switchToMainActivity1(view);
    }
}