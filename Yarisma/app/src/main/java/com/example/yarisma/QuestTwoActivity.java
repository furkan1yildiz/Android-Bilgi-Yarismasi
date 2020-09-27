package com.example.yarisma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yarisma.databinding.ActivityQuestTwoBinding;

public class QuestTwoActivity extends AppCompatActivity {

    ActivityQuestTwoBinding binding;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("EXTRA_POINT") != null) {

            point = Integer.valueOf(bundle.getString("EXTRA_POINT"));
            binding.tvQuestTwoPoint.setText(bundle.getString("EXTRA_POINT"));

        }

        binding.cvQuestTwoOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("A");
            }
        });

        binding.cvQuestTwoOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("B");
            }
        });

        binding.cvQuestTwoOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("C");
            }
        });

        binding.cvQuestTwoOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("D");
            }
        });
    }

    private void control(String chosen) {

        if (chosen.equals("C")) {
            point += 20;
            binding.tvQuestTwoPoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Doğru Cevap", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuestTwoActivity.this, QuestThreeActivity.class);
            intent.putExtra("EXTRA_POINT", String.valueOf(point));
            startActivity(intent);
            finish();
        } else {
            point -= 10;
            binding.tvQuestTwoPoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Yanlış Cevap", Toast.LENGTH_SHORT).show();
            Intent intent;

            if (point < -1) {
                intent = new Intent(QuestTwoActivity.this, EliminationActivity.class);
            } else {
                intent = new Intent(QuestTwoActivity.this, QuestThreeActivity.class);
                intent.putExtra("EXTRA_POINT", String.valueOf(point));
            }

            startActivity(intent);
            finish();
        }

    }
}