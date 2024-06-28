package com.example.new_mentalcalcul;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.new_mentalcalcul.DAO.ScoreBaseHelper;
import com.example.new_mentalcalcul.DAO.ScoreDao;
import com.example.new_mentalcalcul.entities.Score;
import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    private ScoreDao scoreDao;
    private TextView tvscore1, tvscore2, tvscore3;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        scoreDao = new ScoreDao(new ScoreBaseHelper(this,"BDD",1));
        tvscore1 = findViewById(R.id.tv_score1);
        tvscore2 = findViewById(R.id.tv_score2);
        tvscore3 = findViewById(R.id.tv_score3);
        List<Score> items = scoreDao.TopScores();
        Score score1;
        Score score2;
        Score score3;
        switch ( items.size())
        {
            case 3 :
                score1 = items.get(0);
                score2 = items.get(1);
                score3 = items.get(2);
                tvscore1.setText(score1.getNom()+ "  :  "+ score1.getScore());
                tvscore2.setText(score2.getNom()+ "  :  "+ score2.getScore());
                tvscore3.setText(score3.getNom()+ "  :  "+ score3.getScore());
                break;
            case 2:
                score1 = items.get(0);
                score2 = items.get(1);
                tvscore1.setText(score1.getNom()+ "  :  "+ score1.getScore());
                tvscore2.setText(score2.getNom()+ "  :  "+ score2.getScore());
                break;
            case 1:
                score1 = items.get(0);
                tvscore1.setText(score1.getNom()+ "  :  "+ score1.getScore());
                break;
            default:
                break;
        }
    }
}
