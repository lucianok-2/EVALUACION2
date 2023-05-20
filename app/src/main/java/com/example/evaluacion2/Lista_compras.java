package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.evaluacion2.Adapter.Producto_Adapter;
import com.example.evaluacion2.ProductoEntidad.Producto;
import com.example.evaluacion2.db.DbProductos;

import java.util.ArrayList;

public class Lista_compras extends AppCompatActivity implements View.OnClickListener{
    private Button Añadir,Eliminar;
    EditText buscar;
    RecyclerView listaproductos;
    ArrayList<Producto> ArrayProducto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);

        Añadir=(Button)findViewById(R.id.btn_añadir);
        Eliminar=(Button)findViewById(R.id.btn_eliminar);
        Añadir.setOnClickListener(this);

        listaproductos = findViewById(R.id.recycle_Mostrar);
        listaproductos.setLayoutManager(new LinearLayoutManager(this));

        DbProductos dbProductos = new DbProductos(Lista_compras.this);

        ArrayProducto = new ArrayList<>();

        Producto_Adapter adapter = new Producto_Adapter(dbProductos.mostar());
        listaproductos.setAdapter(adapter);



    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_buscar:
                // Código para buscar productos
                break;
            case R.id.btn_añadir:
                Intent intent = new Intent(this, Crear_producto.class);
                startActivity(intent);
                break;

            case R.id.btn_eliminar:
                // Código para eliminar productos
                break;
        }
    }

}