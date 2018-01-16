package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UpdateVistoria extends Activity {

    protected Spinner spRua, spLocal, spEstado;
    protected Button button;
    protected EditText nPort;
    protected String user,rua, localidade, cliente, crl, anomalia,tamponamento, ligado, estado, bombagem;
    protected CheckBox cbCliente, cbCrl, cbTamp, cbLigado, cbBomb, cbAnomalia, cbFotos;
    DatabaseHelper db;

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        db = new DatabaseHelper(this).open();
        Intent x = getIntent();
        String aVistoria = x.getStringExtra("aVistoria");


        String[]dados = db.getAVistoria(aVistoria);

        Toast temp1 = Toast.makeText(UpdateVistoria.this,
                "rua "+ dados[3], Toast.LENGTH_SHORT);
        temp1.show();

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



    }
}
