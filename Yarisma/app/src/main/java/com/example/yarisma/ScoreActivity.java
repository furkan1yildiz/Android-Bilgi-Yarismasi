package com.example.yarisma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yarisma.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("EXTRA_POINT") != null) {
            binding.tvScoreTotalPoint.setText("Puan : " + bundle.getString("EXTRA_POINT"));
        }
        binding.BtnScoreEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreActivity.this, StartingActivity.class));
                finish();
            }
        });


    }
}