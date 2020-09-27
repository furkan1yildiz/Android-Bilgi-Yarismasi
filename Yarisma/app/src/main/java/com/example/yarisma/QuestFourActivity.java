package com.example.yarisma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yarisma.databinding.ActivityQuestFourBinding;

public class QuestFourActivity extends AppCompatActivity {

    ActivityQuestFourBinding binding;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestFourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("EXTRA_POINT") != null) {
            point = Integer.valueOf(bundle.getString("EXTRA_POINT"));
            binding.tvQuestFourPoint.setText(bundle.getString("EXTRA_POINT"));

        }

        binding.cvQuestFourOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("A");
            }
        });

        binding.cvQuestFourOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("B");
            }
        });

        binding.cvQuestFourOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("C");
            }
        });

        binding.cvQuestFourOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("D");
            }
        });
    }

    private void control(String chosen) {

        if (chosen.equals("C")) {
            point += 20;
            binding.tvQuestFourPoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Doğru Cevap", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuestFourActivity.this, QuestFiveActivity.class);
            intent.putExtra("EXTRA_POINT", String.valueOf(point));
            startActivity(intent);
            finish();
        } else {
            point -= 10;
            binding.tvQuestFourPoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Yanlış Cevap", Toast.LENGTH_SHORT).show();
            Intent intent;

            if (point < -1) {
                intent = new Intent(QuestFourActivity.this, EliminationActivity.class);
            } else {
                intent = new Intent(QuestFourActivity.this, QuestFiveActivity.class);
                intent.putExtra("EXTRA_POINT", String.valueOf(point));
            }

            startActivity(intent);
            finish();

        }

    }

}