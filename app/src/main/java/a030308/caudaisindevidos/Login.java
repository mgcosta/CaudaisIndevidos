package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    protected Button btnLogin;
    protected Button btnSignUp;
    protected DatabaseHelper db = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.open();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText a = (EditText) findViewById(R.id.user);
                String str = a.getText().toString();
                EditText b = (EditText) findViewById(R.id.Pass);
                String pwdStr = b.getText().toString();

                String password = db.searchPass(str);

                if (pwdStr.equals(password))
                {
                    Intent i = new Intent(Login.this, Home.class);
                    i.putExtra("Username", str);
                    Toast temp = Toast.makeText(Login.this, "Welcome " +  str, Toast.LENGTH_SHORT);
                    temp.show();
                    startActivity(i);
                }
                else
                {
                    Toast temp = Toast.makeText(Login.this, "Dados Incorrectos!", Toast.LENGTH_SHORT);
                    temp.show();
                }


            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i = new Intent(Login.this, SignUp.class);
                startActivity(i);

            }
        });


    }
}
