package a030308.caudaisindevidos;

import android.view.View;

/**
 * Created by a030308 on 03/01/2018.
 */

public class Main2Activity {
    // Intent oIntent = getIntent();
    //  user = oIntent.getStringExtra("Username");


      /*  check = (CheckBox) findViewById(R.id.checkBoxC);
        nPorta = (EditText) findViewById(R.id.nPorta);
        referencia = (EditText) findViewById(R.id.ref);
        cartasig = (EditText) findViewById(R.id.carta);

        spRua = (Spinner) findViewById(R.id.spRua);
        spLocal = (Spinner) findViewById(R.id.spLocal);


        btnAr = (Button) findViewById(R.id.btnAr);
        btnAa = (Button) findViewById(R.id.btnAa);*/


       /* // Create an ArrayAdapter using the string array and a default spinner layout
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
*/

      /* btnAr.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String rua = spRua.getSelectedItem().toString();
            String local = spLocal.getSelectedItem().toString();

            String arguments[] = new String[7];
            arguments[0] = rua;
            arguments[1] = local;
            arguments[2] = nPorta.getText().toString();
            arguments[3] = referencia.getText().toString();
            arguments[4] = cartasig.getText().toString();
            arguments[5] = user;
            arguments[6] = clientePres;

              /*  backgroundTask = new AsyncGenerator();

                if (rua.equals("Seleccionar rua...")) {
                    Toast temp = Toast.makeText(SecondActivity.this,
                            "Seleccione uma rua por favor!", Toast.LENGTH_SHORT);
                    temp.show();
                }
                if (local.equals("Seleccionar localidade...")) {
                    Toast temp = Toast.makeText(SecondActivity.this,
                            "Seleccione uma localidade por favor!", Toast.LENGTH_SHORT);
                    temp.show();
                } else {
                    backgroundTask.execute(arguments);
                }
        }
    });*/

}

  /*  public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBoxC:
                if (checked)
                    clientePres = "Sim";
                else
                    clientePres = "Não";
                break;
        }
    }


    private class AsyncGenerator extends AsyncTask<String, Void, String[]> {

        @Override // runs on the GUI thread
        protected void onPreExecute() {
        }

        @Override // runs on the Back thread
        protected String[] doInBackground(String... arguments) {

           /* int userId = db.searchUserId(user);
            //Register inspecao in database
            Inspecao i = new Inspecao();
            i.setRua(arguments[0]);
            i.setLocalidade(arguments[1]);
            i.setPorta(arguments[2]);
            i.setReferencia( arguments[3]);
            i.setReferencia( arguments[4]);
            i.setCreatedBy(userId);
            i.setContato(arguments[6]);
            insp = db.insertInspecao(i);

            //Get inspecção ID
            Integer uInt = (int) (long) insp;

            String temp1[] = new String[2];
            temp1[0] = String.valueOf(userId);
            temp1[1] = String.valueOf(uInt);

            return temp1;
        }


        @Override // runs on the GUI thread
        protected void onPostExecute(String [] temp) {

            int userId, uInt;
            userId = Integer.parseInt(temp[0]);
            uInt = Integer.parseInt(temp[1]);

            Toast temp1 = Toast.makeText(SecondActivity.this,
                    "Localização registada com sucesso!" + userId + " " + uInt, Toast.LENGTH_SHORT);
            temp1.show();

            Intent ar = new Intent(SecondActivity.this, WelcomeActivity.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_USERID",userId);
            extras.putInt("EXTRA_INSPID",uInt);
            ar.putExtras(extras);
            startActivity(ar);

            cleanForm();
        }

        private void cleanForm() {
            spRua.setSelection(0);
            nPorta.setText("");
            spLocal.setSelection(0);
            cartasig.setText("");
            referencia.setText("");
            check.setChecked(false);

    }*/






