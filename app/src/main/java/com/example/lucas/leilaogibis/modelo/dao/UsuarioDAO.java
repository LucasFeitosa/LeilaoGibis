package com.example.lucas.leilaogibis.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.lucas.leilaogibis.modelo.entidade.Usuario;

import java.net.ContentHandler;

/**
 * Created by lucas on 23/12/14.
 */
public class UsuarioDAO extends SQLiteOpenHelper{

    private static final int VERSAO = 1;
    private static final String TABELA = "Usuario";
    private static final String DATABASE = "LeilaoGibis";

    private static final String TAG = "CADASTRO_USUARIO";


    public UsuarioDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl = "CREATE TABLE "
                +  TABELA
                + "("
                +"id INTEGER PRIMARY KEY,"
                +"nome TEXT, email TEXT)";

        db.execSQL(ddl);

        Log.i(TAG, "Banco Criado");

    }

    public void cadastrarUsuario(Usuario usuario){

        ContentValues values = new ContentValues();

        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());

        Log.i("Usuario cadastrado:", usuario.getNome());
        Log.i("Email cadastrado:", usuario.getEmail());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " +  TABELA;
        db.execSQL(sql);

        onCreate(db);

        Log.i(TAG, "Upgrade Realizado");

    }
}
