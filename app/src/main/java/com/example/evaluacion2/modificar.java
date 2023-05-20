package com.example.evaluacion2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evaluacion2.ProductoEntidad.Producto;
import com.example.evaluacion2.db.DbProductos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class modificar extends AppCompatActivity {

    EditText txtNombre, txtFechaC,txtFechaV,txtLugar,txtmarca,txtprecio,txtcantidad;
    Button btnCrear;
    FloatingActionButton Eliminar;
    boolean correcto =false;

    Producto producto;
    int id=0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtNombre = findViewById(R.id.txt_nombre);
        txtFechaC = findViewById(R.id.txt_fecha_c);
        txtFechaV = findViewById(R.id.txt_Fecha_v);
        txtLugar = findViewById(R.id.txt_Lugar);
        txtmarca = findViewById(R.id.txt_marca);
        txtprecio = findViewById(R.id.txt_precio);
        txtcantidad = findViewById(R.id.txt_cantidad);

        btnCrear = findViewById(R.id.btn_crear);
        Eliminar = findViewById(R.id.floatingActionButton);

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
                String nombre = txtNombre.getText().toString();
                if(nombre.equals("")) {
                    Toast.makeText(modificar.this,"Debe llenar el nombre",Toast.LENGTH_LONG).show();
                } else {
                    correcto = dbProductos.Editar(id, nombre, txtFechaC.getText().toString(), txtFechaV.getText().toString(), txtLugar.getText().toString(), txtmarca.getText().toString(), txtprecio.getText().toString(), txtcantidad.getText().toString());
                    if(correcto){
                        Toast.makeText(modificar.this,"ERROR ",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(modificar.this,"PRODUCTO Editado CON EXITO",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        Eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(modificar.this);
                builder.setMessage("Esta seguro de eliminar este Producto?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(dbProductos.Eliminar(id)){
                                    lista();


                                }

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();


            }
        });



    }
    private void lista(){
        Intent intentar =new Intent(this, Lista_Productos.class);
        startActivity(intentar);

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

}