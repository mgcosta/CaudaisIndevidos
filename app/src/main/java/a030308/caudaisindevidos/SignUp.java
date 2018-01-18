package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {

    protected EditText username;
    protected EditText email;
    protected EditText name;
    protected EditText pwd1;
    protected EditText pwd2;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.user);
        pwd1 = (EditText) findViewById(R.id.pass);
        pwd2 = (EditText) findViewById(R.id.pass);



    }

    public void onSignUpClick(View v) {

        if(v.getId() == R.id.btnSignUp)
        {
            name.getText().toString();
            email.getText().toString();
            username.getText().toString();
            String pwd1Srt = pwd1.getText().toString();
            String pwd2Srt = pwd2.getText().toString();

            if(!pwd1Srt.equals(pwd2Srt))
            {
                //popup msg
                Toast pass = Toast.makeText(SignUp.this, "Password incorrecta!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //Register user in database
                User u = new User();
                u.setName(name.getText().toString());
                u.setEmail(email.getText().toString());
                u.setUname(username.getText().toString());
                u.setPass(pwd1Srt);

                db.insertUser(u);

                Toast pass = Toast.makeText(SignUp.this, "You're Signed Up!", Toast.LENGTH_SHORT);
                pass.show();

                //returns to Login
                Intent i = new Intent(SignUp.this, Login.class);
                startActivity(i);
            }
        }
    }

}

