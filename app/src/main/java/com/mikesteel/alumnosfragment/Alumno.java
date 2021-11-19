package com.mikesteel.alumnosfragment;

public class Alumno {
    private final int nia;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNacimiento;
    private String email;
    private Nota[] notas;

    public Alumno(int nia, String nombre, String apellido1, String apellido2, String fechaNacimiento,
                  String email, Nota[] notas) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.notas = notas;
    }

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public Nota[] getNotas() {
        return notas;
    }

}
