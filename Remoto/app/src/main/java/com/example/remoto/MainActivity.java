package com.example.remoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import data.BookSearchResultsAdapter;
import data.BookSearchViewModel;
import data.Volume;
import data.VolumesResponse;

public class MainActivity extends AppCompatActivity {
TextView busqueda, autor;
Button buscar;
RecyclerView listaAutores;
BookSearchViewModel vm;
LiveData<VolumesResponse> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        busqueda= findViewById(R.id.idBusqueda);
        autor=findViewById(R.id.idAutor);
        buscar=findViewById(R.id.idBuscar);
        listaAutores=findViewById(R.id.idList);

        BookSearchResultsAdapter adapter= new BookSearchResultsAdapter();
        listaAutores.setLayoutManager(new LinearLayoutManager(this));
        listaAutores.setAdapter(adapter);
        vm=new ViewModelProvider(this).get(BookSearchViewModel.class);
        vm.init();
        data=vm.getVolumesResponseLiveData();
        data.observe(this, (data)->{
            adapter.setResults(data.getItems());
        });

        buscar.setOnClickListener((v)->{
            vm.searchVolumes(busqueda.getText().toString(), autor.getText().toString());
        });
    }
}