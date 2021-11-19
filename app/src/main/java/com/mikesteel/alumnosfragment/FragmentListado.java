package com.mikesteel.alumnosfragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentListado extends Fragment {
    private Alumno[] datosAlumno;
    private IAlumnoListener listener;

    public FragmentListado(){
        super(R.layout.fragment_listado);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert datosAlumno != null && listener != null;
        RecyclerView rvListado = view.findViewById(R.id.rvListado);
        rvListado.setAdapter(new AdaptadorAlumnos(datosAlumno,listener));
        rvListado.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
    }

    public void setAlumnoListener(Alumno[] alumnos,IAlumnoListener listener){
        this.datosAlumno = alumnos;
        this.listener = listener;
    }
}
