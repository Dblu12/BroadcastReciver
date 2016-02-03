package com.example.david.broadcastllamadas.basedatos;

import android.provider.BaseColumns;

/**
 * Created by David on 27/01/2016.
 */
public class Contrato {

    private Contrato (){
    }

    public static abstract  class TablaLlamadas implements BaseColumns {
        public static final String TABLA = "llamadas";
        public static final String NUMERO = "numero";
        public static final String FECHA = "fecha";
        public static final String RECIBIDA= "recibida";
    }
}
