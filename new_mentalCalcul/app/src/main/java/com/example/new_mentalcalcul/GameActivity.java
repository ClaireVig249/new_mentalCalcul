package com.example.new_mentalcalcul;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView textViewCalcul;
    private TextView textViewResultat;

    private MenuItem score;
    private Integer nbScore=0;
    private MenuItem vies;
    private Integer nbVies=3;

    private Button boutonUn,boutonDeux,boutonTrois,boutonQuatre,boutonCinq,boutonSix,boutonSept,boutonHuit,boutonNeuf,boutonZero,boutonCheck,boutonSupp;

    private Integer premierTerme,secondTerme,resultat, calculResultat = 0;

    private TypeOperationEnum typeOperation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewCalcul=findViewById(R.id.textView_calcul);
        textViewResultat=findViewById(R.id.textView_resultat);

        boutonUn=findViewById(R.id.button_1);
        boutonDeux=findViewById(R.id.button_2);
        boutonTrois=findViewById(R.id.button_3);
        boutonQuatre=findViewById(R.id.button_4);
        boutonCinq=findViewById(R.id.button_5);
        boutonSix=findViewById(R.id.button_6);
        boutonSept=findViewById(R.id.button_7);
        boutonHuit=findViewById(R.id.button_8);
        boutonNeuf=findViewById(R.id.button_9);
        boutonZero=findViewById(R.id.button_0);
        boutonCheck=findViewById(R.id.button_confirm);
        boutonSupp=findViewById(R.id.button_delete);

        boutonUn.setOnClickListener(view ->{
            ajouterChiffre(1);
        });
        boutonDeux.setOnClickListener(view ->{
            ajouterChiffre(2);
        });
        boutonTrois.setOnClickListener(view ->{
            ajouterChiffre(3);
        });
        boutonQuatre.setOnClickListener(view ->{
            ajouterChiffre(4);
        });
        boutonCinq.setOnClickListener(view ->{
            ajouterChiffre(5);
        });
        boutonSix.setOnClickListener(view ->{
            ajouterChiffre(6);
        });
        boutonSept.setOnClickListener(view ->{
            ajouterChiffre(7);
        });
        boutonHuit.setOnClickListener(view ->{
            ajouterChiffre(8);
        });
        boutonNeuf.setOnClickListener(view ->{
            ajouterChiffre(9);
        });
        boutonZero.setOnClickListener(view ->{
            ajouterChiffre(0);
        });
        boutonCheck.setOnClickListener(view ->{
            verification();
        });
        boutonSupp.setOnClickListener(view ->{
            calculResultat= calculResultat/10;
            majTextCalcul();
        });

        generateCalcul();
        majTextGame();
        calculResultat=0;
        majTextCalcul();
    }

    private void generateCalcul(){
        Random hasard = new Random();
        Integer typeOpe;
        secondTerme = hasard.nextInt(10)+1;
        premierTerme = hasard.nextInt(10)+secondTerme;
        typeOpe = hasard.nextInt(4);
        switch(typeOpe){
            case 0:
                typeOperation = TypeOperationEnum.ADD;
                resultat=premierTerme+secondTerme;
                break;
            case 1:
                typeOperation = TypeOperationEnum.SUBSTRACT;
                resultat=premierTerme-secondTerme;
                break;
            case 2:
                typeOperation = TypeOperationEnum.MULTIPLY;
                resultat=premierTerme*secondTerme;
                break;
            case 3:
                typeOperation = TypeOperationEnum.DIVIDE;
                resultat=premierTerme;
                premierTerme=resultat*secondTerme;
                break;
        }
    }

    private void majTextGame(){
        textViewCalcul.setText(premierTerme + typeOperation.getSymbole() + secondTerme);
    }

    private void ajouterChiffre(Integer chiffre){
        if(calculResultat<=999){
            calculResultat=10*calculResultat+chiffre;
            majTextCalcul();
        }else{
            Toast.makeText(this,getString(R.string.ERROR_NUMBER_TOO_HIGH), Toast.LENGTH_LONG).show();
        }
    }

    private void majTextCalcul(){
        textViewResultat.setText(""+calculResultat);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar,menu);
        score = menu.findItem(R.id.toolbar_score);
        this.score.setTitle("Score : "+nbScore);
        vies = menu.findItem(R.id.toolbar_vies);
        this.vies.setTitle("Vies : "+nbVies);
        return super.onCreateOptionsMenu(menu);
    }

    private void verification(){
        if(calculResultat==resultat){
            nbScore++;
            this.score.setTitle("Score : "+nbScore);
        }else{
            nbVies--;
            this.vies.setTitle("Vies : "+nbVies);
        }

        if(nbVies<=0){
            Intent intent = new Intent(GameActivity.this, InputActivity.class);
            intent.putExtra("SCORE", nbScore.toString());
            startActivity(intent);
        }

        generateCalcul();
        majTextGame();
        calculResultat=0;
        majTextCalcul();
    }
}