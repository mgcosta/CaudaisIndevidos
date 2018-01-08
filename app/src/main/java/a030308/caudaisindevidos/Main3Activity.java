package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends Activity {

    protected Button btnVistoria;
    protected String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


            Intent oIntent = getIntent();
            user = oIntent.getStringExtra("Username");

            Toast temp = Toast.makeText(Main3Activity.this, "Welcome " +  user, Toast.LENGTH_SHORT);
            temp.show();
            btnVistoria = (Button) findViewById(R.id.btnVistoria);

        btnVistoria.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                    i.putExtra("Username", user);
                    startActivity(i);
                }
            });


        }
}

