package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evaluacion2.ProductoEntidad.Producto;
import com.example.evaluacion2.db.DbProductos;

public class modificar extends AppCompatActivity {
    EditText txtNombre, txtFechaC,txtFechaV,txtLugar,txtmarca,txtprecio,txtcantidad;
    Button btnCrear;
    boolean correcto =false;

    Producto producto;
    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        txtNombre = findViewById(R.id.txt_nombre);
        txtFechaC = findViewById(R.id.txt_fecha_c);
        txtFechaV = findViewById(R.id.txt_Fecha_v);
        txtLugar = findViewById(R.id.txt_Lugar);
        txtmarca = findViewById(R.id.txt_marca);
        txtprecio = findViewById(R.id.txt_precio);
        txtcantidad = findViewById(R.id.txt_cantidad);

        btnCrear = findViewById(R.id.btn_crear);

        if(savedInstanceState==null){
            Bundle extras= getIntent().getExtras();
            if(extras == null){
                id= Integer.parseInt(null);

            }else{
                id =extras.getInt("ID");
            }

        }else{
            id =(int)savedInstanceState.getSerializable("ID");


        }
        DbProductos dbProductos= new DbProductos(modificar.this);
        producto = dbProductos.verProducto(id);

        if(producto!=null){
           txtNombre.setText(producto.getNombre());
           txtFechaC.setText(producto.getFecha_c());
           txtFechaV.setText(producto.getFecha_v());
           txtLugar.setText(producto.getLugar());
           txtmarca.setText(producto.getMarca());
           txtprecio.setText(producto.getPrecio());
           txtcantidad.setText(producto.getCantidad());


        }
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNombre.getText().toString().equals("") ){
                    correcto=dbProductos.Editar(id,txtNombre.getText().toString(), txtFechaC.getText().toString(), txtFechaC.getText().toString(),txtLugar.getText().toString(),txtmarca.getText().toString(),txtprecio.getText().toString(),txtcantidad.getText().toString());
                    if(correcto){
                        Toast.makeText(modificar.this,"PRODUCTO Editado CON EXITO",Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(modificar.this,"Error al Editar",Toast.LENGTH_LONG).show();

                    }

                }else{
                    Toast.makeText(modificar.this,"Debe LLenar el Nombre",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}