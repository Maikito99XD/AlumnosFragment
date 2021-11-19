package com.mikesteel.alumnosfragment;

public class Nota {
    private double calificacion;
    private String codAsignatura;

    public Nota(double calificacion, String codAsignatura) {
        this.calificacion = calificacion;
        this.codAsignatura = codAsignatura;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }
}
