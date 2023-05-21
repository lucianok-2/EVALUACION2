package com.example.evaluacion2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.evaluacion2.Adapter.Producto_Adapter;
import com.example.evaluacion2.ProductoEntidad.Producto;
import com.example.evaluacion2.db.DbProductos;

import java.util.ArrayList;

public class Lista_Productos extends AppCompatActivity implements View.OnClickListener,SearchView.OnQueryTextListener{
    private Button Añadir,Eliminar;
    Spinner spinnerOrdenar ;
     Producto_Adapter adapter;
    EditText buscar;
    RecyclerView listaproductos;
    ArrayList<Producto> ArrayProducto;
    SearchView busqueda;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinnerOrdenar = findViewById(R.id.spinner_ordenar);

        Añadir=(Button)findViewById(R.id.btn_añadir);
        Añadir.setOnClickListener(this);

        busqueda=findViewById(R.id.sv_buscar);


        listaproductos = findViewById(R.id.recycle_Mostrar);
        listaproductos.setLayoutManager(new LinearLayoutManager(this));

        DbProductos dbProductos = new DbProductos(Lista_Productos.this);

        ArrayProducto = new ArrayList<>();

        adapter = new Producto_Adapter(dbProductos.mostar());
        listaproductos.setAdapter(adapter);

        busqueda.setOnQueryTextListener(this);


        spinnerOrdenar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        adapter.ordenarProductos(0); // Ordenar por nombre
                        break;
                    case 1:
                        adapter.ordenarProductos(1); // Ordenar por fecha de vencimiento
                        break;
                    case 2:
                        adapter.ordenarProductos(2); // Ordenar por precio
                        break;
                    case 3:
                        adapter.ordenarProductos(3); // Ordenar por cantidad
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se hace nada aquí
            }
        });



    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_añadir:
                Intent intent = new Intent(this, Crear_producto.class);
                startActivity(intent);
                break;


        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onResume() {
        super.onResume();
        // Actualizar el adaptador cada vez que la actividad vuelve a estar en primer plano
        DbProductos dbProductos = new DbProductos(Lista_Productos.this);
        adapter = new Producto_Adapter(dbProductos.mostar());
        listaproductos.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Actualizar el adaptador para mostrar el nuevo producto
            DbProductos dbProductos = new DbProductos(Lista_Productos.this);
            Producto_Adapter adapter = new Producto_Adapter(dbProductos.mostar());
            listaproductos.setAdapter(adapter);
        }
    }


    @Override
    public boolean onQueryTextSubmit(String s) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtro_busqueda(s);
        return false;
    }

}