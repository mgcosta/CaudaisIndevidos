package a030308.caudaisindevidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
;

import java.util.ArrayList;

public class Main5Activity extends Activity {
    protected ArrayList<String> osItensDaLista;
    protected ListView list;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }


}
