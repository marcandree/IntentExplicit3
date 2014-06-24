
package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("email", "john@doe.com");
        intent.putExtra("nom", "john");
        intent.putExtra("prenom", "doe");
        startActivityForResult(intent, 1);

    }

    // récupère les informations envoyées par l'activité s'étant fermé
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1 && requestCode == 1) {
            if (data.hasExtra("returnKey")) {
                Toast.makeText(this, data.getExtras().getString("returnKey"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}