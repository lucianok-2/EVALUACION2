package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                long id = dbProductos.CrearProducto(txtNombre.getText().toString(), txtFechaC.getText().toString(), txtFechaC.getText().toString(),txtLugar.getText().toString(),txtmarca.getText().toString(),txtprecio.getText().toString(),txtcantidad.getText().toString());
                if (id>0){
                    Toast.makeText(Crear_producto.this,"PRODUCTO CREADO CON EXITO",Toast.LENGTH_LONG).show();
                    limpiar();

                }else{
                    Toast.makeText(Crear_producto.this,"ERROR AL CREAR",Toast.LENGTH_LONG).show();

                }
            }
        });


    }
    private void limpiar(){
        txtNombre.setText("");
        txtFechaC.setText("");
        txtFechaV.setText("");
        txtLugar.setText("");
        txtmarca.setText("");
        txtprecio.setText("");
        txtcantidad.setText("");


    }
}