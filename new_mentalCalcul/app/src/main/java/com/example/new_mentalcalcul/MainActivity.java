package com.example.new_mentalcalcul;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button boutonJouer;
    private Button boutonScores;
    private Button boutonAPropos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonJouer = findViewById(R.id.button_play);
        boutonJouer.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });
        boutonScores = findViewById(R.id.button_score);
        boutonScores.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, ScoresActivity.class);
            startActivity(intent);
        });
        boutonAPropos = findViewById(R.id.button_apropos);
        boutonAPropos.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }
}