package com.mikesteel.alumnosfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorAlumnos extends RecyclerView.Adapter<AdaptadorAlumnos.AlumnoViewHolder>{
    private final Alumno[] datosAlumnos;
    private final IAlumnoListener listener;

    public AdaptadorAlumnos(Alumno[] datosAlumnos, IAlumnoListener listener) {
        this.datosAlumnos = datosAlumnos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
        .item_alumno,viewGroup,false);
        return new AlumnoViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder alumnoViewHolder, int position) {
        Alumno alumno = datosAlumnos[position];
        alumnoViewHolder.bindContacto(alumno);

    }

    @Override
    public int getItemCount() {
        return datosAlumnos.length;
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombre;
        private TextView edad;
        private TextView email;
        private IAlumnoListener listener;
        private final StringBuilder sb;

        public AlumnoViewHolder(@NonNull View itemView, IAlumnoListener listener) {
            super(itemView);
            this.listener = listener;
            sb = new StringBuilder();
            nombre = itemView.findViewById(R.id.tvName);
            edad = itemView.findViewById(R.id.tvEdad);
            email = itemView.findViewById(R.id.tvEmail);
            itemView.setOnClickListener(this);

        }
        public void bindContacto(Alumno alumno) {
            sb.setLength(0);
            sb.append(alumno.getNombre()).append(" ").append(alumno.getApellido1()).append(" ")
                    .append(alumno.getApellido2());
            nombre.setText(sb.toString());
            edad.setText(alumno.getFechaNacimiento());
            email.setText(alumno.getEmail());
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.onAlumnoSeleccionado(getAdapterPosition());
            }
        }
    }
}
