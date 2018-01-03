package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by a030308 on 03/01/2018.
 */

public class WelcomeActivity extends Activity {

    protected Button btnInsp;
    protected String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent oIntent = getIntent();
        user = oIntent.getStringExtra("Username");

        Toast temp = Toast.makeText(WelcomeActivity.this, "Welcome " +  user, Toast.LENGTH_SHORT);
        temp.show();
        btnInsp = (Button) findViewById(R.id.btnInspecao);

        btnInsp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
               // Intent i = new Intent(WelcomeActivity.this, InspecaoActivity.class);
              //  i.putExtra("Username", user);
               // startActivity(i);
            }
        });


    }
}
