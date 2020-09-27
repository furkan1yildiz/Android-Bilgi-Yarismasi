package com.example.yarisma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yarisma.databinding.ActivityEliminationBinding;

public class EliminationActivity extends AppCompatActivity {

    ActivityEliminationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEliminationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEliminationTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EliminationActivity.this, StartingActivity.class));
                finish();
            }
        });
    }
}