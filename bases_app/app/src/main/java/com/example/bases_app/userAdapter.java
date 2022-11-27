package com.example.bases_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder> {
    private ArrayList<users> usersDatos;
    public userAdapter (ArrayList<users> usuarios) {
        this.usersDatos=usuarios;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView telefono;
        public ViewHolder(View view) {
            super(view);

            //Extrae el id para su tratamiento
            nombre = (TextView) view.findViewById(R.id.vNombre);
            telefono = (TextView) view.findViewById(R.id.vTelefono);

        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getDescripcion() {
            return telefono;
        }
    }
    @Override
    public ViewHolder onCreateViewHolder (ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    //@Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        viewHolder.getNombre().setText(usersDatos.get(position).nombre);
        viewHolder.getDescripcion().setText(usersDatos.get(position).telefono);

    }
    @Override
    public int getItemCount() {
        return usersDatos.size();
    }

}
