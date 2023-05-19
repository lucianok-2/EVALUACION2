package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.evaluacion2.db.DbProductos;

public class Crear_producto extends AppCompatActivity {
    EditText txtNombre, txtFechaC,txtFechaV,txtLugar,txtmarca,txtprecio,txtcantidad;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);

        txtNombre = findViewById(R.id.txt_nombre);
        txtFechaC = findViewById(R.id.txt_fecha_c);
        txtFechaV = findViewById(R.id.txt_Fecha_v);
        txtLugar = findViewById(R.id.txt_Lugar);
        txtmarca = findViewById(R.id.txt_marca);
        txtprecio = findViewById(R.id.txt_precio);
        txtcantidad = findViewById(R.id.txt_cantidad);

        btnCrear = findViewById(R.id.btn_crear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbProductos dbProductos = new DbProductos(Crear_producto.this);
                dbProductos.CrearProducto(txtNombre.getText().toString(), txtFechaC.getText().toString(), txtFechaC.getText().toString(),txtLugar.getText().toString(),txtmarca.getText().toString(),txtprecio.getText().);

            }
        });


    }
}