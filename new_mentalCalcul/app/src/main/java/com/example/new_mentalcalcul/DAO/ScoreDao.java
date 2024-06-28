package com.example.new_mentalcalcul.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.new_mentalcalcul.R;
import com.example.new_mentalcalcul.entities.Score;

public class ScoreDao extends BaseDao<Score> {


    public ScoreDao(DataBaseHelper helper) {
        super(helper);
    }

    public static String TABLE_NAME="Resultats";
    public static String COLUMN_NOM="Nom";
    public static String COLUMN_SCORE="Score";


    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
        values.put(COLUMN_NOM,entity.getNom());
        values.put(COLUMN_SCORE,entity.getScore());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Integer indexPremierElement = cursor.getColumnIndex(COLUMN_NOM);
        Integer indexDeuxiemeElement = cursor.getColumnIndex(COLUMN_SCORE);

        Score monScore = new Score();
        monScore.setNom(cursor.getString(indexPremierElement));
        monScore.setScore(cursor.getInt(indexDeuxiemeElement));
        return monScore;
    }

}