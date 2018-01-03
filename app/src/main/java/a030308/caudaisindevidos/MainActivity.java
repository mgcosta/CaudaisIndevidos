package a030308.caudaisindevidos;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    protected Button btnLogin;
    protected Button btnSignUp;
    //protected DatabaseHelper db = new DatabaseHelper(this);

    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "ArActivity onPause()", Toast.LENGTH_SHORT).show();
        // db.close();
    }
    @Override
    protected void onStop(){
        super.onStop();
        // Toast.makeText(this, "MainActivity onStop()", Toast.LENGTH_SHORT).show();
      //  db.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //db.open();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText a = (EditText) findViewById(R.id.user);
                String str = a.getText().toString();
                EditText b = (EditText) findViewById(R.id.pass);
                String pwdStr = b.getText().toString();

           //     String password = db.searchPass(str);

               // if (pwdStr.equals(password))
                {
                  Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                //    i.putExtra("Username", str);
                   startActivity(i);
                }
               // else
                {
                    Toast temp = Toast.makeText(MainActivity.this, "Dados Incorrectos! Verifique username e password!", Toast.LENGTH_SHORT);
                    temp.show();
                }


            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
             //   Intent i = new Intent(MainActivity.this, SignUpActivity.class);
             //   startActivity(i);
            }
        });


    }


}
