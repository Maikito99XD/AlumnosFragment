package com.mikesteel.alumnosfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorCalificaciones extends RecyclerView.Adapter<AdaptadorCalificaciones.CalificacionesViewHolder>{
    private final Calificacion[] datosCalificaciones;
    private final IAlumnoListener listener;

    public AdaptadorCalificaciones(Calificacion[] datosCalificaciones, IAlumnoListener listener) {
        this.datosCalificaciones = datosCalificaciones;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CalificacionesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_detalle,viewGroup,false);
        return new CalificacionesViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalificacionesViewHolder calificacionesViewHolder, int position) {
        Calificacion calificacion = datosCalificaciones[position];
        calificacionesViewHolder.bindCalificaciones(calificacion);
    }

    @Override
    public int getItemCount() {
        return datosCalificaciones.length;
    }

    public class CalificacionesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombreAsig;
        private TextView siglasAsig;
        private TextView notaAsig;
        private final IAlumnoListener listener;
        public CalificacionesViewHolder(@NonNull View itemView, IAlumnoListener listener) {
            super(itemView);
            siglasAsig = itemView.findViewById(R.id.tvSiglasAsig);
            nombreAsig = itemView.findViewById(R.id.tvNombreAsig);
            notaAsig = itemView.findViewById(R.id.tvNota);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.onAlumnoSeleccionado(getAdapterPosition());
            }
        }

        public void bindCalificaciones(Calificacion calificacion){
            siglasAsig.setText(calificacion.getCodAsig());
            nombreAsig.setText(calificacion.getNomAsig());
            notaAsig.setText((int) calificacion.getNotaAsig());
        }
    }
}
