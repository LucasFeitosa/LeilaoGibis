package com.example.lucas.leilaogibis.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.lucas.leilaogibis.modelo.entidade.Gibi;
import com.example.lucas.leilaogibis.modelo.entidade.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 23/12/14.
 */
public class GibiDAO extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String TABELA = "Gibi";
    private static final String DATABASE = "LeilaoGibis";

    private static final String TAG = "CADASTRO_GIBI";


    public GibiDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl = "CREATE TABLE "
                +  TABELA
                + "("
                +"id INTEGER PRIMARY KEY,"
                +"nome TEXT)";

        db.execSQL(ddl);

        Log.i(TAG, "Banco Criado");

    }

    public void cadastrarGibi(Gibi gibi){

        ContentValues values = new ContentValues();

        values.put("nome", gibi.getNome());

        getWritableDatabase().insert(TABELA, null, values);
        Log.i(TAG, "Gibi cadastrado:" + gibi.getNome());


    }

    public List<Gibi> listar(){

        List<Gibi> lista = new ArrayList<Gibi>();

        String sql = "Select * from " +  TABELA + " order by nome";

        Cursor cursor = getReadableDatabase().rawQuery(sql,null);

        try{
            while(cursor.moveToNext()){
                Gibi gibi = new Gibi();

                gibi.setId(cursor.getLong(0));
                gibi.setNome(cursor.getString(1));

                lista.add(gibi);
            }
        } finally {
            cursor.close();
        }
        return lista;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " +  TABELA;
        db.execSQL(sql);

        onCreate(db);

        Log.i(TAG, "Upgrade Realizado");

    }
}
