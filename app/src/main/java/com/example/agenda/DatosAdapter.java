package com.example.agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.ViewHolder> {
    private ArrayList<Datos> datos;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView telefono;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.eNombre);
            telefono = (TextView) view.findViewById(R.id.ePhone);
        }
        public TextView getTextNombre() {
            return nombre;
        }
        public TextView getTextTelefono() {
            return telefono;
        }
    }

    public DatosAdapter(Datos[] dataSet) {
        datos = new ArrayList<Datos>();
        add(dataSet);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_datos, viewGroup, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextNombre().setText(datos.get(position).nombre);
        viewHolder.getTextTelefono().setText(datos.get(position).telefono);
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(Datos[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}
