package com.example.david.broadcastllamadas.pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.david.broadcastllamadas.basedatos.Ayudante;
import com.example.david.broadcastllamadas.basedatos.Contrato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 27/01/2016.
 */
public class GestorLlamada {private Ayudante abd;
    private SQLiteDatabase bd;

    public GestorLlamada(Context c){
        Log.v("SQLAAD", "constructor del gestor de películas");
        abd = new Ayudante(c);
    }
    public void open() {
        bd = abd.getWritableDatabase();
    }
    public void openRead() {
        bd = abd.getReadableDatabase();
    }
    public void close() {
        abd.close();
    }

    public long insert(Llamada p) {
        ContentValues valores = new ContentValues();
        valores.put(Contrato.TablaLlamadas.NUMERO, p.getNumero());
        valores.put(Contrato.TablaLlamadas.FECHA, p.getFecha());
        valores.put(Contrato.TablaLlamadas.RECIBIDA, p.getRecibida());

        long id = bd.insert(Contrato.TablaLlamadas.TABLA, null, valores);
        return id;
    }

    public int delete(Llamada r) {
        return delete(r.getId());
    }

    public int delete(long id){
        String condicion = Contrato.TablaLlamadas._ID + " = ?";
        String[] argumentos = {id + ""};
        int cuenta = bd.delete(
                Contrato.TablaLlamadas.TABLA, condicion, argumentos);
        return cuenta;
    }

    public int update(Llamada r){
        ContentValues valores = new ContentValues();
        valores.put(Contrato.TablaLlamadas.NUMERO, r.getNumero());
        valores.put(Contrato.TablaLlamadas.FECHA, r.getFecha());
        String condicion = Contrato.TablaLlamadas._ID + " = ?";
        String[] argumentos = { r.getId() + "" };
        int cuenta = bd.update(Contrato.TablaLlamadas.TABLA, valores,
                condicion, argumentos);
        return cuenta;
    }

    public Llamada getRow(Cursor c) {
        Llamada r = new Llamada();
        r.setId((int) c.getLong(c.getColumnIndex(Contrato.TablaLlamadas._ID)));
        r.setNumero(c.getString(c.getColumnIndex(Contrato.TablaLlamadas.NUMERO)));
        r.setFecha(c.getString(c.getColumnIndex(Contrato.TablaLlamadas.FECHA)));
        return r;
    }

    public Llamada getRow(long id) {
        Cursor c = getCursor("_id = ?", new String[]{id+""});
        return getRow(c);
    }

    public Cursor getCursor(){
        return getCursor(null, null);
    }

    public Cursor getCursorLlamadas(String cadena){
        //"SELECT COUNT(*) FROM llamadas WHERE fecha=?"
        //"select count(*) from llamadas where fecha=
        Cursor c = bd.rawQuery("SELECT COUNT(*) FROM llamadas WHERE fecha=?",null);
        return c;
    }

    public Cursor getCursor(String condicion, String[] parametros) {
        Cursor cursor = bd.query(
                Contrato.TablaLlamadas.TABLA, null, condicion, parametros, null,
                null, Contrato.TablaLlamadas.NUMERO + ", " + Contrato.TablaLlamadas.FECHA);
        return cursor;
    }

    public List<Llamada> select(String condicion, String[] parametros) {
        List<Llamada> la = new ArrayList<>();
        Cursor cursor = getCursor(condicion, parametros);
        Llamada p;
        while (cursor.moveToNext()) {
            p = getRow(cursor);
            la.add(p);
        }
        cursor.close();
        return la;
    }

    public List<Llamada> select() {
        return select(null,null);
    }



    public Cursor getCursorRecibidas() {

        Cursor cursor = bd.rawQuery("SELECT * FROM llamadas where recibida=1",null);

        return cursor;
    }

    public Cursor getCursorRealizadas() {
        Cursor cursor = bd.rawQuery("SELECT * FROM llamadas where recibida=0",null);
        return cursor;
    }
}
