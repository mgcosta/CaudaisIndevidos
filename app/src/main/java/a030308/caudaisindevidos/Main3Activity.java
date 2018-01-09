package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends Activity {

    protected Button btnVistoria , btnExportar, btnLista;
    protected String user;
    DatabaseHelper db;
    Cursor asVistorias;

    private void executarOutraActivity(Class<?> subActividade, ArrayList<String> oValor) {
        Intent x = new Intent(this, subActividade);
        x.putExtra("asVistorias", oValor);
        startActivity(x);
    }


    @Override
    protected void onStart() {
        super.onStart();
        // Toast.makeText(this, "InspecçãoActivity onStart()", Toast.LENGTH_SHORT).show();
        db = new DatabaseHelper(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


            Intent oIntent = getIntent();
            user = oIntent.getStringExtra("Username");

            Toast temp = Toast.makeText(Main3Activity.this, "Welcome " +  user, Toast.LENGTH_SHORT);
            temp.show();
            btnVistoria = (Button) findViewById(R.id.btnVistoria);
            btnExportar = (Button) findViewById(R.id.btnExp);
            btnLista = (Button) findViewById(R.id.btnListar);


        btnVistoria.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                    i.putExtra("Username", user);
                    startActivity(i);
                }
            });

        btnExportar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

            }
         });

        btnLista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {


            }
        });

        }
}

