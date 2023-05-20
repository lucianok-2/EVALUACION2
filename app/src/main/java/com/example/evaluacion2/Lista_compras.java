package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Lista_compras extends AppCompatActivity implements View.OnClickListener{
    private Button Añadir,Eliminar;
    EditText buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);

        Añadir=(Button)findViewById(R.id.btn_añadir);
        Eliminar=(Button)findViewById(R.id.btn_eliminar);
        Añadir.setOnClickListener(this);


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