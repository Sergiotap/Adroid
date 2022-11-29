package com.example.bases_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder> {

    private List<user> usersDatos;
    private static RecyclerViewClickListener listener;
    public userAdapter(List<user> usuarios, RecyclerViewClickListener listener) {
        this.usersDatos=usuarios;
        this.listener=listener;
    }
    static ActivityResultLauncher<String> requestPermissionLauncher;
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombre;
        private final TextView telefono;
        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            //Extrae el id para su tratamiento
            nombre = (TextView) view.findViewById(R.id.vNombre);
            telefono = (TextView) view.findViewById(R.id.vTelefono);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getTelefono() {
            return telefono;
        }
        @Override
        public void onClick(View view){
            listener.onClick(view,getAdapterPosition());
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
        viewHolder.getTelefono().setText(usersDatos.get(position).telefono);

    }
    @Override
    public int getItemCount() {
        return usersDatos.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

}
