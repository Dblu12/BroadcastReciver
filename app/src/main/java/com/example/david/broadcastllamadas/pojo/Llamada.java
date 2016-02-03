package com.example.david.broadcastllamadas.pojo;

/**
 * Created by David on 27/01/2016.
 */
public class Llamada {

    private int id;
    private String numero, fecha;
    private boolean recibida;

    public Llamada(int id, String numero, String fecha) {
        this.id= id;
        this.numero = numero;
        this.fecha = fecha;
    }

    public Llamada(String numero, String fecha, boolean recibida) {
        this.numero = numero;
        this.fecha = fecha;
        this.recibida= recibida;
    }

    public Llamada() {
    }

    public Llamada(boolean recibida) {
        this.recibida = recibida;
    }

    public boolean getRecibida() {
        return recibida;
    }

    public void setRecibida(boolean recibida) {
        this.recibida = recibida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", fecha='" + fecha + '\'' +
                ", recibida='" + recibida + '\'' +
                '}';
    }
}
