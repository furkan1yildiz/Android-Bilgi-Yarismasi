package com.example.yarisma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yarisma.databinding.ActivityStartingBinding;

public class StartingActivity extends AppCompatActivity {

    ActivityStartingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityStartingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnStartingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartingActivity.this, QuestOneActivity.class));
            }
        });
    }
}