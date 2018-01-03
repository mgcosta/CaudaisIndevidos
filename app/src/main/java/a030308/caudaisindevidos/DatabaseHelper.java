package a030308.caudaisindevidos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a030308 on 03/01/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "ci.db";
    //Database Version
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase dbHelper;

    //Database TABLES
    private static final String TABLE_USER = "users";
    private static final String TABLE_INSPECAO = "inspecoes";

    //Common column names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CREATED_AT = "created_at";
    private static final String COLUMN_CREATED_BY = "created_by";


    // users column names
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";

    // inspecoes column names
    private static final String COLUMN_RUA = "rua";
    private static final String COLUMN_NPORTA = "nporta";
    private static final String COLUMN_LOCALIDADE = "localidade";
    private static final String COLUMN_REFERENCIA = "referencia";
    private static final String COLUMN_CARTASIG = "cartasig";
    private static final String COLUMN_CONTACTO = "clientePresente";
    private static final String COLUMN_CRL = "crl";
    private static final String COLUMN_BOMBAGEM = "bombagem";
    private static final String COLUMN_TAMPONAMENTO = "tamponamento";
    private static final String COLUMN_ANOMALIA = "anomalia";
    private static final String COLUMN_FECHO = "fecho";
    private static final String COLUMN_DIAMETRO = "diametro";
    private static final String COLUMN_PROFUNDIDADE = "profundidade";
    private static final String COLUMN_ESTADO = "estado";
    private static final String COLUMN_FOTOS = "fotos";
    private static final String COLUMN_OBS = "obs";
    private static final String COLUMN_LIGADO = "ligado";
    private static final String COLUMN_LOCALIZACAO = "localizacao";
    private static final String COLUMN_INSTALADOR = "instalador";
    private static final String COLUMN_MATERIAL = "material";






    //TABLE CREATE STATEMENTS
    //Users table create STATEMENT
    private static final String TABLE_USERS = "CREATE TABLE "
            + TABLE_USER + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
            + " TEXT   not null," + COLUMN_EMAIL + " TEXT not null," + COLUMN_UNAME
            + " TEXT not null," + COLUMN_PASS + " TEXT not null," + COLUMN_CREATED_AT
            + " DATETIME" + ")";

    //Inspecao table create STATEMENT
    private static final String TABLE_INSPECOES = "CREATE TABLE "
            + TABLE_INSPECAO + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_RUA +
            " TEXT not null,"+ COLUMN_NPORTA + " TEXT,"  + COLUMN_LOCALIDADE + " TEXT not null,"
            + COLUMN_REFERENCIA + " TEXT," + COLUMN_CARTASIG + " TEXT," + COLUMN_CONTACTO + " TEXT,"+ COLUMN_INSTALADOR + " TEXT ," + COLUMN_CRL+ " TEXT ,"+ COLUMN_BOMBAGEM
            + " TEXT ," + COLUMN_LIGADO + " TEXT ," + COLUMN_LOCALIZACAO
            + " TEXT ,"+ COLUMN_TAMPONAMENTO + " TEXT ," + COLUMN_MATERIAL
            + " TEXT ,"+ COLUMN_ANOMALIA + " TEXT ,"+ COLUMN_FECHO + " TEXT,"
            + COLUMN_DIAMETRO + " INTEGER,"+ COLUMN_PROFUNDIDADE + " INTEGER,"+ COLUMN_FOTOS
            + " TEXT ," + COLUMN_ESTADO + " TEXT,"+ COLUMN_OBS + " TEXT,"
            + COLUMN_CREATED_BY + " INTEGER,"  + COLUMN_CREATED_AT + " DATETIME" + ");";


    //DatabaseHelper Constructor
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USERS);
        db.execSQL(TABLE_INSPECOES);
        this.dbHelper=db;

    }

    public DataBaseHelper open() {
        dbHelper = this.getWritableDatabase();
        return this;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INSPECAO);
        this.onCreate(db);
    }


   /* public void insertUser(User u)
    {
        dbHelper = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, u.getName());
        values.put(COLUMN_UNAME, u.getUname());
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PASS, u.getPass());
        //values.put(COLUMN_CREATED_AT, getDateTime());

        dbHelper.insert(TABLE_USER, null, values);
        dbHelper.close();
    }

    public String searchPass(String uname)
    {
        dbHelper = this.getReadableDatabase();
        String query = "select uname, pass from "+ TABLE_USER;
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

   /* public long insertInspecao(Inspecao i)
    {
        dbHelper = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_RUA, i.getRua());
        values.put(COLUMN_NPORTA, i.getPorta());
        values.put(COLUMN_LOCALIDADE, i.getLocalidade());
        values.put(COLUMN_REFERENCIA, i.getReferencia());
        values.put(COLUMN_CARTASIG, i.getCartasig());
        values.put(COLUMN_CREATED_BY, i.getUserId());
        values.put(COLUMN_CONTACTO, i.getContato());
        values.put(COLUMN_INSTALADOR , i.getInstalador());
        values.put(COLUMN_CRL, i.getCrl());
        values.put(COLUMN_BOMBAGEM, i.getBombagem());
        values.put(COLUMN_LIGADO, i.getLigado());
        values.put(COLUMN_LOCALIZACAO, i.getLocalizacao());
        values.put(COLUMN_TAMPONAMENTO, i.getTamponamento());
        values.put(COLUMN_MATERIAL, i.getMaterial());
        values.put(COLUMN_ANOMALIA, i.getAnomalia());
        values.put(COLUMN_FECHO, i.getFecho());
        values.put(COLUMN_DIAMETRO, i.getDiametro());
        values.put(COLUMN_PROFUNDIDADE, i.getProfundidade());
        values.put(COLUMN_FOTOS, i.getFoto());
        values.put(COLUMN_OBS, i.getObs());
        //values.put(COLUMN_CREATED_AT, getDateTime());

        Long id = dbHelper.insert(TABLE_INSPECAO, null, values);
        dbHelper.close();
        return id;

    }

    public Integer searchUserId(String uname)
    {
        dbHelper = this.getReadableDatabase();
        String query = "select uname, id from "+ TABLE_USER;
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


  /*  private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }*/

}