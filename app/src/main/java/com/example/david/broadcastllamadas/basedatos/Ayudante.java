package com.example.david.broadcastllamadas.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by David on 27/01/2016.
 */
public class Ayudante extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "llamadas.sqlite";
    public static final int DATABASE_VERSION = 1;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;


        sql = "create table " + Contrato.TablaLlamadas.TABLA + "( " +
                Contrato.TablaLlamadas._ID + " integer primary key autoincrement, " +
                Contrato.TablaLlamadas.NUMERO + " text, " +
                Contrato.TablaLlamadas.FECHA + " text, " +
                Contrato.TablaLlamadas.RECIBIDA+ " boolean" +
                ")";

        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        Log.v("SQLAAD","on upgrade");
        String sql="drop table if exists "
                + Contrato.TablaLlamadas.TABLA;
        db.execSQL(sql);
        onCreate(db);
    }
}
