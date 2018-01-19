package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Home extends Activity {

    protected Button btnVistoria, btnListar, btnBack;
    protected Spinner spRua;
    protected String user;
    private com.google.firebase.storage.StorageReference mStorageRef;
    DatabaseHelper db;
    protected File dbpath;

    private void executarOutraActivity(Class<?> subActividade, ArrayList<String> oValor) {
        Intent x = new Intent(this, subActividade);
        x.putExtra("asVistorias", oValor);
        startActivity(x);
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = new DatabaseHelper(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        Context ctx = this; // for Activity, or Service. Otherwise simply get the context.
        String dbname = "ci.db";
        dbpath = ctx.getDatabasePath(dbname);

        Intent oIntent = getIntent();
        user = oIntent.getStringExtra("Username");



        spRua = (Spinner) findViewById(R.id.spRuaL);

        btnVistoria = (Button) findViewById(R.id.btnVistoria);
        btnListar = (Button) findViewById(R.id.btnListar);
        btnBack = (Button) findViewById(R.id.btnBackup);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterRua = ArrayAdapter.createFromResource(this,
                R.array.ruas_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterRua.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spRua.setAdapter(adapterRua);

        btnVistoria.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    Intent i = new Intent(Home.this, InsertVistoria.class);
                    i.putExtra("Username", user);
                    startActivity(i);
                }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String rua = spRua.getSelectedItem().toString();
                List<String> asVistorias;
                asVistorias=db.obterTodasVistorias(rua);
                executarOutraActivity(ListVistorias.class, (ArrayList)asVistorias);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                new UploadFilesTask().execute();
            }
        });
    }

    class UploadFilesTask extends AsyncTask <String, Void, String> {


        @Override
        protected String doInBackground(String...dados) {

            Long date = System.currentTimeMillis();
            Uri file = Uri.fromFile(new File(String.valueOf(dbpath)));
            StorageReference riversRef = mStorageRef.child("dbBackup/"+date+"-ci.db");

            riversRef.putFile(file)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Get a URL to the uploaded content
                            //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                            Toast temp1 = Toast.makeText(Home.this, "File Uploaded!", Toast.LENGTH_SHORT);
                            temp1.show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle unsuccessful uploads
                            Toast temp = Toast.makeText(Home.this, "File Not Uploaded!", Toast.LENGTH_SHORT);
                            temp.show();
                        }
                    });
            return null;
        }
    }


}

