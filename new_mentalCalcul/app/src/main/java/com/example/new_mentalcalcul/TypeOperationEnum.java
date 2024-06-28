package com.example.new_mentalcalcul;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TypeOperationEnum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ADD(" + "),
    SUBSTRACT(" - "),
    MULTIPLY(" * "),
    DIVIDE(" / ");

    TypeOperationEnum(String symbole){
        this.symbole = symbole;
    }
    public String getSymbole(){
        return symbole;
    }
    private String symbole;
}