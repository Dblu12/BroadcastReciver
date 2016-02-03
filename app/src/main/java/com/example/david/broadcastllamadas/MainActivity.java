package com.example.david.broadcastllamadas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.broadcastllamadas.pojo.GestorLlamada;
import com.example.david.broadcastllamadas.pojo.Llamada;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private int[] llamadas;
    private int lunes, martes, miercoles, jueves, viernes, sabado, domingo;
    private WebView webView;
    private GestorLlamada gl;
    public static long ultimo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl = new GestorLlamada(this);
        gl.open();


        webView = (WebView) findViewById(R.id.webView);




        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        contarRealizadas();
        webView.loadUrl("file:///android_asset/canvas/pruebagraficos.html");

        webView.addJavascriptInterface(this, "InterfazAndroid");

        final TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("REALIZADAS"));
        tabs.addTab(tabs.newTab().setText("RECIBIDAS"));
        tabs.addTab(tabs.newTab().setText("AMBAS"));

        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
//        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.setOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        switch (tabs.getSelectedTabPosition()) {
                            case 0:
                                contarRealizadas();
                                webView.loadUrl("file:///android_asset/canvas/pruebagraficos.html");
                                break;
                            case 1:
                                contarRecibidas();
                                webView.loadUrl("file:///android_asset/canvas/pruebagraficos.html");
                                break;
                            case 2:
                                contarAmbas();
                                webView.loadUrl("file:///android_asset/canvas/pruebagraficos2.html");
                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                }
        );
    }


    @Override
    protected void onPause() {
        super.onPause();
        gl.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gl.open();
    }

    @JavascriptInterface
    public int enviarDia(int x) {
        return llamadas[x];
    }

    private void contarRealizadas() {


        llamadas = new int[7];
        lunes = martes = miercoles = jueves = viernes = sabado = domingo = 0;
        Cursor c = gl.getCursorRealizadas();
        while (c.moveToNext()) {
            Llamada l = gl.getRow(c);
            if (l.getFecha().equalsIgnoreCase("lunes"))
                lunes++;
            else if (l.getFecha().equalsIgnoreCase("martes"))
                martes++;
            else if (l.getFecha().equalsIgnoreCase("miercoles"))
                miercoles++;
            else if (l.getFecha().equalsIgnoreCase("jueves"))
                jueves++;
            else if (l.getFecha().equalsIgnoreCase("viernes"))
                viernes++;
            else if (l.getFecha().equalsIgnoreCase("sabado"))
                sabado++;
            else if (l.getFecha().equalsIgnoreCase("domingo"))
                domingo++;
        }
        llamadas[0] = lunes;
        llamadas[1] = martes;
        llamadas[2] = miercoles;
        llamadas[3] = jueves;
        llamadas[4] = viernes;
        llamadas[5] = sabado;
        llamadas[6] = domingo;
    }

    private void contarRecibidas() {
        Log.v("Prueba", "a");
        llamadas = new int[7];
        lunes = martes = miercoles = jueves = viernes = sabado = domingo = 0;
        Cursor c = gl.getCursorRecibidas();

        while (c.moveToNext()) {

            Llamada l = gl.getRow(c);
            Log.v("Prueba", "Dia: "+l.toString());
            if (l.getFecha().equalsIgnoreCase("lunes"))
                lunes++;
            else if (l.getFecha().equalsIgnoreCase("martes"))
                martes++;
            else if (l.getFecha().equalsIgnoreCase("miercoles"))
                miercoles++;
            else if (l.getFecha().equalsIgnoreCase("jueves"))
                jueves++;
            else if (l.getFecha().equalsIgnoreCase("viernes"))
                viernes++;
            else if (l.getFecha().equalsIgnoreCase("sabado"))
                sabado++;
            else if (l.getFecha().equalsIgnoreCase("domingo"))
                domingo++;
        }
        Log.v("Prueba", lunes+"");
        Log.v("Prueba", martes+"");
        Log.v("Prueba", miercoles+"");
        Log.v("Prueba", jueves+"");
        Log.v("Prueba", viernes+"");
        Log.v("Prueba", sabado+"");
        Log.v("Prueba", domingo+"");

        //lunes=7;
        llamadas[0] = lunes;
        llamadas[1] = martes;
        llamadas[2] = miercoles;
        llamadas[3] = jueves;
        llamadas[4] = viernes;
        llamadas[5] = sabado;
        llamadas[6] = domingo;
    }

    private void contarAmbas() {


        llamadas = new int[14];
        lunes = martes = miercoles = jueves = viernes = sabado = domingo = 0;
        Cursor c = gl.getCursorRealizadas();
        while (c.moveToNext()) {
            Llamada l = gl.getRow(c);
            if (l.getFecha().equalsIgnoreCase("lunes"))
                lunes++;
            else if (l.getFecha().equalsIgnoreCase("martes"))
                martes++;
            else if (l.getFecha().equalsIgnoreCase("miercoles"))
                miercoles++;
            else if (l.getFecha().equalsIgnoreCase("jueves"))
                jueves++;
            else if (l.getFecha().equalsIgnoreCase("viernes"))
                viernes++;
            else if (l.getFecha().equalsIgnoreCase("sabado"))
                sabado++;
            else if (l.getFecha().equalsIgnoreCase("domingo"))
                domingo++;
        }
        llamadas[0] = lunes;
        llamadas[1] = martes;
        llamadas[2] = miercoles;
        llamadas[3] = jueves;
        llamadas[4] = viernes;
        llamadas[5] = sabado;
        llamadas[6] = domingo;

        lunes = martes = miercoles = jueves = viernes = sabado = domingo = 0;
         c = gl.getCursorRecibidas();
        while (c.moveToNext()) {
            Llamada l = gl.getRow(c);
            if (l.getFecha().equalsIgnoreCase("lunes"))
                lunes++;
            else if (l.getFecha().equalsIgnoreCase("martes"))
                martes++;
            else if (l.getFecha().equalsIgnoreCase("miercoles"))
                miercoles++;
            else if (l.getFecha().equalsIgnoreCase("jueves"))
                jueves++;
            else if (l.getFecha().equalsIgnoreCase("viernes"))
                viernes++;
            else if (l.getFecha().equalsIgnoreCase("sabado"))
                sabado++;
            else if (l.getFecha().equalsIgnoreCase("domingo"))
                domingo++;
        }
        llamadas[7] = lunes;
        llamadas[8] = martes;
        llamadas[9] = miercoles;
        llamadas[10] = jueves;
        llamadas[11] = viernes;
        llamadas[12] = sabado;
        llamadas[13] = domingo;

    }
}