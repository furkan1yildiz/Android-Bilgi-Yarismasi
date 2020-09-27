package com.example.yarisma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yarisma.databinding.ActivityQuestThreeBinding;

import java.io.Console;

public class QuestThreeActivity extends AppCompatActivity {

    ActivityQuestThreeBinding binding;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestThreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if (bundle.getString("EXTRA_POINT") != null) {
            point = Integer.valueOf(bundle.getString("EXTRA_POINT"));
            binding.tvQuestThreePoint.setText(bundle.getString("EXTRA_POINT"));

        }

        binding.cvQuestThreeOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("A");
            }
        });

        binding.cvQuestThreeOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("B");
            }
        });

        binding.cvQuestThreeOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("C");
            }
        });

        binding.cvQuestThreeOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control("D");
            }
        });

    }

    private void control(String chosen) {

        if (chosen.equals("D")) {
            point += 20;
            binding.tvQuestThreePoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Doğru Cevap", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuestThreeActivity.this, QuestFourActivity.class);
            intent.putExtra("EXTRA_POINT", String.valueOf(point));
            startActivity(intent);

        } else {
            point -= 10;
            binding.tvQuestThreePoint.setText(String.valueOf(point));
            Toast.makeText(getApplicationContext(), "Yanlış Cevap", Toast.LENGTH_SHORT).show();
            Intent intent;
            if (point < -1) {
                intent = new Intent(QuestThreeActivity.this, EliminationActivity.class);
            } else {
                intent = new Intent(QuestThreeActivity.this, QuestFourActivity.class);
                intent.putExtra("EXTRA_POINT", String.valueOf(point));
            }

            startActivity(intent);

        }
        finish();

    }

}