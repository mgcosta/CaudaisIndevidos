package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class InsertVistoria extends Activity {

    protected Spinner spRua, spLocal, spEstado;
    protected Button button;
    protected EditText nPort;
    protected String user,rua, localidade, estado;
    protected CheckBox cbCliente, cbCrl, cbTamp, cbLigado, cbBomb, cbAnomalia, cbFotos;
    DatabaseHelper db;


    @Override
    protected void onStart() {
        super.onStart();
        // Toast.makeText(this, "InspecçãoActivity onStart()", Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_main4);
        db.open();
        Intent oIntent = getIntent();
        user = oIntent.getStringExtra("Username");

        spRua = (Spinner) findViewById(R.id.spRua);
        spLocal =  (Spinner) findViewById(R.id.spLoc);
        spEstado = (Spinner) findViewById(R.id.spEst);
        cbCliente = (CheckBox) findViewById(R.id.cbClient);
        cbCrl = (CheckBox) findViewById(R.id.cbCrlE);
        cbTamp = (CheckBox) findViewById(R.id.cbTP);
        cbLigado = (CheckBox) findViewById(R.id.cbLig);
        cbBomb = (CheckBox) findViewById(R.id.cbBb);
        cbAnomalia = (CheckBox) findViewById(R.id.cbAno);
        cbFotos = (CheckBox) findViewById(R.id.cbFoto);
        button = (Button) findViewById(R.id.btnSave);
        nPort = (EditText) findViewById(R.id.nPorta);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterRua = ArrayAdapter.createFromResource(this,
                R.array.ruas_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterRua.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spRua.setAdapter(adapterRua);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterLocal = ArrayAdapter.createFromResource(this,
                R.array.localidades_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterLocal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spLocal.setAdapter(adapterLocal);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterEstado = ArrayAdapter.createFromResource(this,
                R.array.estado_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spEstado.setAdapter(adapterEstado);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            rua = spRua.getSelectedItem().toString();
            localidade = spLocal.getSelectedItem().toString();
            estado = spEstado.getSelectedItem().toString();

            if (rua.equals("Seleccionar rua...") || localidade.equals("Seleccionar localidade...") || estado.equals("Seleccione Estado...") ) {
                Toast temp = Toast.makeText(InsertVistoria.this,
                        "Seleccione uma rua por favor!", Toast.LENGTH_SHORT);
                temp.show();
            }else {
                String arguments[] = new String[12];
                arguments[0] = rua;
                arguments[1] = nPort.getText().toString();
                arguments[2] = localidade;
                arguments[3] = checkboxChecked(cbCliente);
                arguments[4] = checkboxChecked(cbCrl);
                arguments[5] = checkboxChecked(cbBomb);
                arguments[6] = checkboxChecked(cbTamp);
                arguments[7] = checkboxChecked(cbAnomalia);
                arguments[8] = estado;
                arguments[9] = checkboxChecked(cbLigado);
                arguments[10] =checkboxChecked(cbFotos);
                arguments[11] = user;

                new AsyncGenerator().execute(arguments);
            }
            }
        });

    }

    protected class AsyncGenerator extends AsyncTask <String, Void, String[]>{

        @Override // runs on the GUI thread
        protected void onPreExecute() {

        }

        @Override // runs on the Back thread
        protected String[] doInBackground(String... arguments) {
            int userId = db.searchUserId(user);
            //Register inspecao in database
            Vistoria i = new Vistoria();
            i.setRua(arguments[0]);
            i.setPorta(arguments[1]);
            i.setLocalidade(arguments[2]);
            i.setClientePresente( arguments[3]);
            i.setCrl( arguments[4]);
            i.setBombagem(arguments[5]);
            i.setTamponamento(arguments[6]);
            i.setAnomalia(arguments[7]);
            i.setEstado(arguments[8]);
            i.setLigado(arguments[9]);
            i.setFotos(arguments[10]);
            i.setCreatedBy(userId);

            Long vistoria = db.insertVistoria(i);
            //Get inspecção ID
            Integer uInt = (int) (long) vistoria;

            String temp1[] = new String[2];
            temp1[0] = String.valueOf(userId);
            temp1[1] = String.valueOf(uInt);
            return temp1;
        }


        @Override // runs on the GUI thread
        protected void onPostExecute(String[] finalString) {

            int userId, uInt;
            userId = Integer.parseInt(finalString[0]);
            uInt = Integer.parseInt(finalString[1]);

            Toast temp1 = Toast.makeText(InsertVistoria.this,
                    "Vistoria registada com sucesso!", Toast.LENGTH_SHORT);
            temp1.show();

            Intent ar = new Intent(InsertVistoria.this, Home.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_USERID",userId);
            extras.putInt("EXTRA_INSPID",uInt);
            ar.putExtras(extras);
            startActivity(ar);

            cleanForm();

        }
    }

    private void cleanForm() {
        spRua.setSelection(0);
        nPort.setText("");
        spLocal.setSelection(0);
        spEstado.setSelection(0);
        cbCliente.setChecked(false);
        cbCrl.setChecked(false);
        cbTamp.setChecked(false);
        cbLigado.setChecked(false);
        cbBomb.setChecked(false);
        cbAnomalia.setChecked(false);
        cbFotos.setChecked(false);

    }

    private String checkboxChecked(CheckBox box){

        String temp = "Não";

        if(box.isChecked()){
            temp = "Sim";
        }

        return temp;
    }
}
