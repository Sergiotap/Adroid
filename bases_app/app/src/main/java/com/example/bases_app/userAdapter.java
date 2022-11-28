package com.example.bases_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder> {

    private ArrayList<users> usersDatos;
    private static TextView nombre;
    private static Button telefono;
    public userAdapter (ArrayList<users> usuarios) {
        this.usersDatos=usuarios;
    }
    static ActivityResultLauncher<String> requestPermissionLauncher;
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);

            //Extrae el id para su tratamiento
            nombre = (TextView) view.findViewById(R.id.vNombre);
            telefono = (Button) view.findViewById(R.id.vTelefono);
            telefono.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            boolean permiso=false;
                            permiso=MainActivity.conceder(permiso);
                            if (permiso){

                            }
                            else {
                                Toast.makeText(getDescripcion().getContext(), "Necesitamos permiso para llamar", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );

        }

        public TextView getNombre() {
            return nombre;
        }

        public Button getDescripcion() {
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
