package com.example.new_mentalcalcul.DAO;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.new_mentalcalcul.R;

public class ScoreBaseHelper extends DataBaseHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ScoreBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS "+ ScoreDao.TABLE_NAME+" ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ScoreDao.COLUMN_NOM + " INTEGER NOT NULL,"+
                ScoreDao.COLUMN_SCORE + " INTEGER NOT NULL"+
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS "+ ScoreDao.TABLE_NAME;
    }

}