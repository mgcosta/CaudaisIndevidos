package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateVistoria extends Activity {

    protected Spinner spRua, spLocal, spEstado;
    protected Button button;
    protected EditText nPort;
    protected String user,rua, localidade, cliente, crl, anomalia,tamponamento, ligado, estado, bombagem;
    protected CheckBox cbCliente, cbCrl, cbTamp, cbLigado, cbBomb, cbAnomalia, cbFotos;
    DatabaseHelper db;
    protected String[]dados;
    @Override
    protected void onStart() {
        super.onStart();
        db = new DatabaseHelper(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        spRua = (Spinner) findViewById(R.id.oSpRua);
        spLocal =  (Spinner) findViewById(R.id.oSpLoc);
        spEstado = (Spinner) findViewById(R.id.oSpEst);
        cbCliente = (CheckBox) findViewById(R.id.oCbClient);
        cbCrl = (CheckBox) findViewById(R.id.oCbCrlE);
        cbTamp = (CheckBox) findViewById(R.id.oCbTP);
        cbLigado = (CheckBox) findViewById(R.id.oCbLig);
        cbBomb = (CheckBox) findViewById(R.id.oCbBb);
        cbAnomalia = (CheckBox) findViewById(R.id.oCbAno);
        cbFotos = (CheckBox) findViewById(R.id.oCbFoto);
        button = (Button) findViewById(R.id.btnUpadte);
        nPort = (EditText) findViewById(R.id.oNPorta);

        db = new DatabaseHelper(this).open();

        Intent x = getIntent();
        String aVistoria = x.getStringExtra("aVistoria");

        String CurrentString = aVistoria;
        String[] separated = CurrentString.split(":");
        String tempVistoria = separated[0]; // this will contain _id

        //get data from db
        dados = db.getAVistoria(tempVistoria);

        //fill checkbox according to db
        setboxChecked(cbCliente, dados[4]);
        setboxChecked(cbCrl, dados[5]);
        setboxChecked(cbBomb, dados[6]);
        setboxChecked(cbTamp, dados[7]);
        setboxChecked(cbAnomalia, dados[8]);
        setboxChecked(cbLigado, dados[10]);
        setboxChecked(cbFotos, dados[11]);
        nPort.setText(dados[2]);

        //set ArrayAdapter according to db
        String compareValueR =dados[1];
        ArrayAdapter<CharSequence> adapterRua = ArrayAdapter.createFromResource(this, R.array.ruas_array, android.R.layout.simple_spinner_item);
        adapterRua.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRua.setAdapter(adapterRua);
        if (compareValueR != null) {
            int spinnerPosition = adapterRua.getPosition(compareValueR);
            spRua.setSelection(spinnerPosition);
        }

        String compareValueL =dados[3];
        ArrayAdapter<CharSequence> adapterLocal = ArrayAdapter.createFromResource(this, R.array.localidades_array, android.R.layout.simple_spinner_item);
        adapterLocal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLocal.setAdapter(adapterLocal);
        if (compareValueL != null) {
            int spinnerPosition = adapterLocal.getPosition(compareValueL);
            spLocal.setSelection(spinnerPosition);
        }

        String compareValueE =dados[9];
        ArrayAdapter<CharSequence> adapterEstado = ArrayAdapter.createFromResource(this, R.array.estado_array, android.R.layout.simple_spinner_item);
        adapterEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEstado.setAdapter(adapterEstado);
        if (compareValueE != null) {
            int spinnerPosition = adapterEstado.getPosition(compareValueE);
            spEstado.setSelection(spinnerPosition);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rua = spRua.getSelectedItem().toString();
                localidade = spLocal.getSelectedItem().toString();
                estado = spEstado.getSelectedItem().toString();

                if (rua.equals("Seleccionar rua...") || localidade.equals("Seleccionar localidade...") || estado.equals("Seleccione Estado...") ) {
                    Toast temp = Toast.makeText(UpdateVistoria.this,
                            "Seleccione uma rua por favor!", Toast.LENGTH_SHORT);
                    temp.show();
                }else {
                    String arguments[] = new String[13];
                    arguments[0] = dados[0];
                    arguments[1] = rua;
                    arguments[2] = nPort.getText().toString();
                    arguments[3] = localidade;
                    arguments[4] = checkboxChecked(cbCliente);
                    arguments[5] = checkboxChecked(cbCrl);
                    arguments[6] = checkboxChecked(cbBomb);
                    arguments[7] = checkboxChecked(cbTamp);
                    arguments[8] = checkboxChecked(cbAnomalia);
                    arguments[9] = estado;
                    arguments[10] = checkboxChecked(cbLigado);
                    arguments[11] =checkboxChecked(cbFotos);
                    arguments[12] = user;

                    new AsyncGenerator().execute(arguments);
                    
                }
            }
        });

    }


    private void setboxChecked(CheckBox box, String data){

        CheckBox temp = box;

        if(data.equals("Sim")) {
            box.setChecked(true);
        }else
            box.setChecked(false);
        return;
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
            i.setId(Integer.parseInt(arguments[0]));
            i.setRua(arguments[1]);
            i.setPorta(arguments[2]);
            i.setLocalidade(arguments[3]);
            i.setClientePresente( arguments[4]);
            i.setCrl( arguments[5]);
            i.setBombagem(arguments[6]);
            i.setTamponamento(arguments[7]);
            i.setAnomalia(arguments[8]);
            i.setEstado(arguments[9]);
            i.setLigado(arguments[10]);
            i.setFotos(arguments[11]);

            Long vistoria = db.updateVistoria(i);

            String[] temp1 = new String[1];
            temp1[0]=String.valueOf(i.getUserId());

            return temp1;
        }


        @Override // runs on the GUI thread
        protected void onPostExecute(String[] finalString) {

            int userId, uInt;
            userId = Integer.parseInt(finalString[0]);


            Toast temp1 = Toast.makeText(UpdateVistoria.this,
                    "Vistoria atualizada com sucesso!", Toast.LENGTH_SHORT);
            temp1.show();

            Intent ar = new Intent(UpdateVistoria.this, Home.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_USERID",userId);
            ar.putExtras(extras);
            startActivity(ar);

        }
    }


    private String checkboxChecked(CheckBox box){

        String temp = "Não";

        if(box.isChecked()){
            temp = "Sim";
        }

        return temp;
    }
}
