package com.mikesteel.alumnosfragment;

public class Calificacion {
    private String codAsig;
    private String nomAsig;
    private double notaAsig;

    public Calificacion(String codAsig, String nomAsig, double notaAsig) {
        this.codAsig = codAsig;
        this.nomAsig = nomAsig;
        this.notaAsig = notaAsig;
    }

    public String getCodAsig() {
        return codAsig;
    }

    public double getNotaAsig() {
        return notaAsig;
    }

    public String getNomAsig() {
        return nomAsig;
    }
}
