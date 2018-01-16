package a030308.caudaisindevidos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class ListVistorias extends ListActivity {
    protected ArrayList<String> osItensDaLista;
    DatabaseHelper db;


    private void executarOutraActivity(Class<?> subActividade, String oValor) {
        Intent x = new Intent(this, subActividade);
        x.putExtra("aVistoria", oValor);
        startActivity(x);
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = new DatabaseHelper(this).open();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Intent oIntent = getIntent();
        osItensDaLista = oIntent.getStringArrayListExtra("asVistorias");

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osItensDaLista);
        setListAdapter(adaptador);

    }
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id) {
        Toast.makeText(this, osItensDaLista.get(position), Toast.LENGTH_LONG).show();
        // finish();
        executarOutraActivity(UpdateVistoria.class, osItensDaLista.get(position));
    }
}
