package com.mikesteel.alumnosfragment;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class AlumnoParser {
    private Alumno alumnos[];
    private Calificacion calificaciones[];
    private final InputStream alumnosFile;
    private final InputStream asignaturasFile;

    public AlumnoParser(Context context){
        this.alumnosFile = context.getResources().openRawResource(R.raw.alumnos_notas);
        this.asignaturasFile = context.getResources().openRawResource(R.raw.asignaturas);
    }

    public boolean parse(){
        boolean parse = false;
        String json = null;
        alumnos = null;
        calificaciones = null;
        try {
            int size = alumnosFile.available();
            byte[] buffer = new byte[size];
            alumnosFile.read(buffer);
            alumnosFile.close();
            json = new String(buffer, "UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            alumnos = new Alumno[jsonArray.length()];
            JSONTokener asigtokener = new JSONTokener(json);
            JSONArray arrayAsignaturas = new JSONArray(asigtokener);
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int nia = jsonObject.getInt("nia");
                String nombre = jsonObject.getString("name");
                String apellido1 = jsonObject.getString("apellido1");
                String apellido2 = jsonObject.getString("apelldio2");
                String fechaNacimiento = jsonObject.getString("fechaNacimiento");
                String email = jsonObject.getString("email");
                JSONArray arrayNotas = jsonObject.getJSONArray("notas");
                Nota[] notas = new Nota[arrayNotas.length()];
                for (int j = 0;j<arrayNotas.length();j++){
                    JSONObject arrayNotasAsignaturas = arrayNotas.getJSONObject(j);
                    double calificacion = jsonObject.getDouble("calificacion");
                    String codAsig = jsonObject.getString("codAsig");
                    Calificacion a = null;
                    for (int k = 0; k< calificaciones.length; k++){
                        if (calificaciones[k].getCodAsig().equals(codAsig)){
                            a = calificaciones[k];
                        }
                    }
                    notas[j] = new Nota(calificacion,codAsig);
                }
                alumnos[i] = new Alumno(nia,nombre,apellido1,apellido2,fechaNacimiento,email,notas);
            }
            parse = true;
        }catch (IOException | JSONException e) {
            Log.e("AlumnoParser", "Unknown Exception: "+e.getLocalizedMessage());
        }
        return parse;
    }

    public Alumno[] getAlumnos(){
        return this.alumnos;
    }
}
