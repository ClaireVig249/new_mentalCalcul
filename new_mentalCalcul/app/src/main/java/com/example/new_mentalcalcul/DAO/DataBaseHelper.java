package com.example.new_mentalcalcul.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.new_mentalcalcul.R;

public class DataBaseHelper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private final int dataBaseVersion;
    private final String dataBaseName;

    public DataBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, null, dataBaseVersion);

        this.dataBaseName = dataBaseName;
        this.dataBaseVersion = dataBaseVersion;
    }

    protected abstract String getCreationSql();
    protected abstract String getDeleteSql();

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreationSql());
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(getDeleteSql());
        onCreate(db);
    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}