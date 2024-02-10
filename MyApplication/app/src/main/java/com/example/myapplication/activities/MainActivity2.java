package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.tasks.Task;

public class MainActivity2 extends AppCompatActivity {

    Task task = Task.getTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void SwitchToMainActivity1(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
     public void AddItem(View view){
         EditText editTextInput = findViewById(R.id.editTextText2);
         String inp = editTextInput.getText().toString();
         if (!inp.isEmpty())
         {
             task.addTask(inp);
         }
         SwitchToMainActivity1(view);
     }

}