package com.example.new_mentalcalcul;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button boutonJouer,boutonScores,boutonAPropos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonJouer = findViewById(R.id.button_play);
        boutonJouer.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });
        boutonScores = findViewById(R.id.button_scores);
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
