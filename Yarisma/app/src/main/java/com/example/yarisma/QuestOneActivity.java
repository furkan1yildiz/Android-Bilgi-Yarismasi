package com.example.yarisma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yarisma.databinding.ActivityQuestOneBinding;

public class QuestOneActivity extends AppCompatActivity {

    ActivityQuestOneBinding binding;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.cvQuestOneOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("A");
            }
        });

        binding.cvQuestOneOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("B");
            }
        });

        binding.cvQuestOneOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("C");
            }
        });

        binding.cvQuestOneOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("D");
            }
        });


    }

    private void control(String chosen) {

        if (chosen.equals("A")) {
            point += 20;
            binding.tvQuestOnePoint.setText(String.valueOf("Puan : " + point));
            Toast.makeText(getApplicationContext(), "Doğru Cevap", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuestOneActivity.this, QuestTwoActivity.class);
            intent.putExtra("EXTRA_POINT", String.valueOf(point));
            startActivity(intent);
            finish();
        } else {
            point -= 10;
            binding.tvQuestOnePoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Yanlış Cevap", Toast.LENGTH_SHORT).show();

            Intent intent;
            if (point < -1) {
                intent = new Intent(QuestOneActivity.this, EliminationActivity.class);
            } else {
                intent = new Intent(QuestOneActivity.this, QuestTwoActivity.class);
                intent.putExtra("EXTRA_POINT", point);
            }
            startActivity(intent);

            finish();

        }


    }
}