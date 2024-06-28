package com.example.new_mentalcalcul;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.new_mentalcalcul.DAO.ScoreBaseHelper;
import com.example.new_mentalcalcul.DAO.ScoreDao;
import com.example.new_mentalcalcul.entities.Score;

public class InputActivity extends AppCompatActivity {

    private String nomJoueur;
    private Integer score;
    private Button boutonSave;
    private TextView textViewScore;
    private ScoreDao scoreDao;
    private Button name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        scoreDao =new ScoreDao(new ScoreBaseHelper(this,"BDD",1));
        boutonSave = findViewById(R.id.button_input);
        textViewScore = findViewById(R.id.textViewScore);
        name = findViewById(R.id.textInputName);
        Intent intent =getIntent();
        String afficheScore = intent.getStringExtra("SCORE");
        textViewScore.setText("Score : "+afficheScore);
        score = Integer.parseInt(afficheScore);

        boutonSave.setOnClickListener(view ->{
            nomJoueur = name.getText().toString();
            ajouterBDD();
            Intent intention = new Intent(InputActivity.this, MainActivity.class);
            startActivity(intention);
        });
    }

    private boolean ajouterBDD(){
        Score monScore = new Score();
        monScore.setScore(score);
        monScore.setNom(nomJoueur);
        scoreDao.create(monScore);

        return true;
    }
}