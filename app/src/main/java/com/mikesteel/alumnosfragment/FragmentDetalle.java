package com.mikesteel.alumnosfragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentDetalle extends Fragment {
    private Calificacion[] calificaciones;
    private IAlumnoListener listener;

    public FragmentDetalle(){
        super(R.layout.fragment_detalle);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert calificaciones != null && listener != null;
        RecyclerView rvDetalle = view.findViewById(R.id.rvDetalle);
        rvDetalle.setAdapter(new AdaptadorCalificaciones(calificaciones,listener));
        rvDetalle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    public void setCalificacionesListener(Calificacion[] calificaciones, IAlumnoListener listener){
        this.calificaciones = calificaciones;
        this.listener = listener;
    }
}
