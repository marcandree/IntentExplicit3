package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends Activity
{

    TextView  txtNom;
    TextView  txtPrenom;
    TextView  txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        //récupration des textview
        txtNom = (TextView)findViewById(R.id.textNom);
        txtPrenom = (TextView)findViewById(R.id.textPrenom);
        txtEmail = (TextView)findViewById(R.id.textEmail);

        Intent i = getIntent();

        // recuperation des données
        String nom = i.getStringExtra("nom");
        String prenom = i.getStringExtra("prenom");
        String email = i.getStringExtra("email");

        // Assignation des données
        txtNom.setText(nom);
        txtPrenom.setText(prenom);
        txtEmail.setText(email);
    }

    // appeler lorsque l'activité s'arrête en cliquant sur le boutton back
    @Override
    public void finish()
    {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("returnKey", "Operation reussi");
        // Activity finished ok, return the data
        setResult(1, data);
        super.finish();
    }

}

