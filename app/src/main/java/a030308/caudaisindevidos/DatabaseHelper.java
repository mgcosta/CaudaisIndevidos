package a030308.caudaisindevidos;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by marcia on 08-01-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "ci.db";
    //Database Version
    private static final int DATABASE_VERSION = 8;

    private SQLiteDatabase dbHelper;


    //TABLE CREATE STATEMENTS
    private static final String TABLE_USER = "CREATE TABLE users(_id integer primary key autoincrement," +
            " name varchar(40)," + " uname varchar(10) not null," + " email varchar(40)," +
            " pass varchar(8) not null, " + " created_at DATETIME);";


    private static final String TABLE_VISTORIA =
            "CREATE TABLE vistorias(_id integer primary key autoincrement, rua varchar(100)," +
                    " porta varchar(20), localidade varchar(60), clientePresente varchar(4), " +
                    "crl varchar(4), bombagem varchar(4), tamponamento varchar(4), anomalia varchar(80)" +
                    ", estado varchar(60), ligado varchar(4), fotos varchar(4), created_by integer," +
                    " created_at DATETIME);";



    //DatabaseHelper Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER);
        db.execSQL(TABLE_VISTORIA);
        this.dbHelper=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "users");
        db.execSQL("DROP TABLE IF EXISTS " + "vistorias");
        this.onCreate(db);
    }


    public DatabaseHelper open() {
        dbHelper = this.getWritableDatabase();
        return this;
    }


    public String searchPass(String uname) {

        dbHelper = this.getReadableDatabase();
        String query = "select uname, pass from users";

        Cursor c = dbHelper.rawQuery(query, null);
        String a,b;

        b = "not found";

        if(c.moveToFirst())
        {
            do{
                a= c.getString(0);


                if(a.equals(uname))
                {
                    b=c.getString(1);
                    break;
                }
            }
            while(c.moveToNext());
            c.close();
        }
        return b;
    }


    public void insertUser(User u) {

        dbHelper = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", u.getName());
        values.put("uname", u.getUname());
        values.put("email", u.getEmail());
        values.put("pass", u.getPass());

        dbHelper.insert("users", null, values);
        dbHelper.close();

    }


    public int searchUserId(String uname) {

        dbHelper = this.getReadableDatabase();
        String query = "select uname, _id from "+ "users";
        Cursor c = dbHelper.rawQuery(query, null);
        String a;
        int b;
        b = 0;
        if(c.moveToFirst())
        {
            do{
                a= c.getString(0);
                if(a.equals(uname))
                {
                    b=c.getInt(1);
                    break;
                }
            }
            while(c.moveToNext());
            c.close();
        }
        return b;
    }


    public Long insertVistoria(Vistoria i) {

        dbHelper = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rua", i.getRua());
        values.put("porta", i.getPorta());
        values.put("localidade", i.getLocalidade());
        values.put("clientePresente", i.getClientePresente());
        values.put("crl", i.getCrl());
        values.put("bombagem", i.getBombagem());
        values.put("tamponamento", i.getTamponamento());
        values.put("anomalia", i.getAnomalia());
        values.put("estado", i.getEstado());
        values.put("ligado", i.getLigado());
        values.put("fotos", i.getFotos());
        values.put("created_By", i.getUserId());

        Long id = dbHelper.insert("vistorias", null, values);
        dbHelper.close();
        return id;
    }


    public List<String> obterTodasVistorias(String rua) {
        dbHelper = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        ArrayList<String> moradas = new ArrayList<String>();
        Cursor cursor = obterTodosRegistos(rua);
        if (cursor.moveToFirst()) {
            do {
                moradas.add(cursor.getString(0) +":"+ cursor.getString(1)+" "+ cursor.getString(2)+"-" + cursor.getString(3));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return moradas;
    }

    private Cursor obterTodosRegistos(String rua) {
        dbHelper = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        String whereClause = "rua = ?";
        String[] whereArgs = new String[1];
        whereArgs[0] = rua;

        String[] colunas = new String[4];
        colunas[0] = "_id";
        colunas[1] = "rua";
        colunas[2] = "porta";
        colunas[3] = "localidade";

        return dbHelper.query("vistorias", colunas, whereClause, whereArgs, null, null, "rua");
    }



    public String[] getAVistoria(String aVistoria) {
        dbHelper = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String[] colunas = new String[12];
        String whereClause = "_id = ?";
        String[] whereArgs = new String[1];
        whereArgs[0] = aVistoria;
        Cursor c = dbHelper.query("vistorias", null, whereClause, whereArgs, null, null, null);
        c.moveToFirst();
        colunas[0] = c.getString(0);
        colunas[1] = c.getString(1);
        colunas[2] = c.getString(2);
        colunas[3] = c.getString(3);
        colunas[4] = c.getString(4);
        colunas[5] = c.getString(5);
        colunas[6] = c.getString(6);
        colunas[7] = c.getString(7);
        colunas[8] = c.getString(8);
        colunas[9] = c.getString(9);
        colunas[10] = c.getString(10);
        colunas[11] = c.getString(11);
        return colunas;
    }


    public Long updateVistoria(Vistoria i) {
        dbHelper = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String whereClause = "_id = ?";
        String[] whereArgs = new String[1];
        whereArgs[0] =""+i._id;
        values.put("rua", i.getRua());
        values.put("porta", i.getPorta());
        values.put("localidade", i.getLocalidade());
        values.put("clientePresente", i.getClientePresente());
        values.put("crl", i.getCrl());
        values.put("bombagem", i.getBombagem());
        values.put("tamponamento", i.getTamponamento());
        values.put("anomalia", i.getAnomalia());
        values.put("estado", i.getEstado());
        values.put("ligado", i.getLigado());
        values.put("fotos", i.getFotos());

        dbHelper.update("vistorias", values, whereClause,whereArgs);
        dbHelper.close();
        return null;



    }
}
