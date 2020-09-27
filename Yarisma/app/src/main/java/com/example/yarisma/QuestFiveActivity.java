package com.example.yarisma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yarisma.databinding.ActivityQuestFiveBinding;

public class QuestFiveActivity extends AppCompatActivity {

    ActivityQuestFiveBinding binding;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestFiveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("EXTRA_POINT") != null) {
            point = Integer.valueOf(bundle.getString("EXTRA_POINT"));
            binding.tvQuestFivePoint.setText(bundle.getString("EXTRA_POINT"));

        }

        binding.cvQuestFiveOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("A");
            }
        });

        binding.cvQuestFiveOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("B");
            }
        });

        binding.cvQuestFiveOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("C");
            }
        });

        binding.cvQuestFiveOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("D");
            }
        });

    }

    private void control(String chosen) {

        if (chosen.equals("B")) {
            point += 20;
            binding.tvQuestFivePoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Doğru Cevap", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuestFiveActivity.this, ScoreActivity.class);
            intent.putExtra("EXTRA_POINT", String.valueOf(point));
            startActivity(intent);
            finish();
        } else {
            point -= 10;
            binding.tvQuestFivePoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Yanlış Cevap", Toast.LENGTH_SHORT).show();
            Intent intent;

            if (point < -1) {
                intent = new Intent(QuestFiveActivity.this, EliminationActivity.class);
            } else {
                intent = new Intent(QuestFiveActivity.this, ScoreActivity.class);
                intent.putExtra("EXTRA_POINT", String.valueOf(point));
            }

            startActivity(intent);
            finish();

        }

    }

}