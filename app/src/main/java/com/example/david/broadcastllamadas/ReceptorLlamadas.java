package com.example.david.broadcastllamadas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.example.david.broadcastllamadas.pojo.GestorLlamada;
import com.example.david.broadcastllamadas.pojo.Llamada;

import java.util.GregorianCalendar;

/**
 * Created by David on 27/01/2016.
 */
public class ReceptorLlamadas extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        Toast toast = Toast.makeText(context, "LLAMADA ", Toast.LENGTH_LONG);
        toast.show();


        Log.v("prueba", "llamada");
        Bundle extras = intent.getExtras();
        final GestorLlamada gestorLlamada = new GestorLlamada(context);
        final Context c = context;

        /*
         Se guarda varias veces porque lo detecta varias veces, asi que vamos a intentar hacer una solucion
         que yo creo que es un poco chapucera, pero es la unica que se me ocurre.

         La solución es la siguiente, en el metodo hoy() se comprueba cada vez que entra la resta de ambos tiempos y se compara con
         ultimo, que es public static en Main, la razón de que sea public static en Main es porque si la declaro en esta clase
         cada vez que se active dicha clase se activa con valor 0, y no hace para nada lo esperado.
         */



        PhoneStateListener listener = new PhoneStateListener() {
            public void onCallStateChanged(int state,
                                           String incomingNumber) {
                if (state == android.telephony.TelephonyManager.
                        CALL_STATE_RINGING) {
                    Log.v("Prueba", incomingNumber);
                    gestorLlamada.open();
                    Llamada llamada = new Llamada(true);

                    llamada.setNumero(incomingNumber);
                    if(!llamada.getNumero().equals("")) {
                        llamada.setFecha(hoy());
                        if(!llamada.getFecha().equals("desechar")) {

                            Log.v("Prueba", "Recibida: " + llamada.getRecibida());
                            gestorLlamada.insert(llamada);
                        }
                    }
                    gestorLlamada.close();
                } else {
                    gestorLlamada.open();
                    Llamada llamada = new Llamada(false);

                    llamada.setNumero(incomingNumber);
                    if(!llamada.getNumero().equals("")) {
                        llamada.setFecha(hoy());
                        if(!llamada.getFecha().equals("desechar")) {

                            Log.v("Prueba", "Recibida: " + llamada.toString());
                            gestorLlamada.insert(llamada);
                        }
                    }
                        gestorLlamada.close();
                        Log.v("Prueba", incomingNumber);
                }
            }
        };


        TelephonyManager tm = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);



        /*
        if (s.equals(TelephonyManager.)) {
            String telefono = extras
                    .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            gestorLlamada.open();
            Llamada llamada = new Llamada();
            llamada.setNumero(telefono);
            llamada.setFecha(hoy());
            gestorLlamada.insert(llamada);
            gestorLlamada.close();

        }

        */

    }

    private String hoy() {

        GregorianCalendar a = new GregorianCalendar();
        Log.v("prueba", a.getTimeInMillis()+ " "+" ahora");
        Log.v("prueba", MainActivity.ultimo+ " "+" ultimo");
        if (a.getTimeInMillis()- MainActivity.ultimo>7000) {
            Log.v("prueba", "desechar");
            MainActivity.ultimo= a.getTimeInMillis();
            return "desechar";
        } else if (a.getTime().getDay() == 1) {
            MainActivity.ultimo= a.getTimeInMillis();
            return "lunes";
        } else if (a.getTime().getDay() == 2) {
            MainActivity.ultimo= a.getTimeInMillis();
            return "martes";
        } else if (a.getTime().getDay() == 3) {
            MainActivity.ultimo= a.getTimeInMillis();
            return "miercoles";
        } else if (a.getTime().getDay() == 4) {
            MainActivity.ultimo= a.getTimeInMillis();
            return "jueves";
        } else if (a.getTime().getDay() == 5) {
            MainActivity.ultimo= a.getTimeInMillis();
            return "viernes";
        } else if (a.getTime().getDay() == 6) {
            MainActivity.ultimo= a.getTimeInMillis();
            return "sabado";
        } else if (a.getTime().getDay() == 7) {
            MainActivity.ultimo= a.getTimeInMillis();
            return "domingo";
        }
        return "aaaa";
    }
}
