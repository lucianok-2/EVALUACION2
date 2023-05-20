package com.example.evaluacion2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.evaluacion2.db.DbHelper;


public class Menu extends AppCompatActivity implements View.OnClickListener {
    Button lista;
    Button productos;
    Button inventario;
    Button recordatorio;
    Button lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lista = (Button)findViewById(R.id.boton_inicio3);
        lista.setOnClickListener(this);

        inventario = (Button)findViewById(R.id.boton_inicio5);
        inventario.setOnClickListener(this);
        recordatorio =(Button)findViewById(R.id.boton_inicio7);
        recordatorio.setOnClickListener(this);
        lugar =(Button)findViewById(R.id.boton_inicio4);
        lugar.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton_inicio3:
                DbHelper dbHelper = new DbHelper(Menu.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Intent i = new Intent(Menu.this,Lista_compras.class);
                startActivity(i);
                break;
            case R.id.boton_inicio5:
                Intent in = new Intent(Menu.this,Inventario.class);
                startActivity(in);
                break;
            case R.id.boton_inicio7:
                Intent r = new Intent(Menu.this, Recordatorio.class);
                startActivity(r);
                break;
            case R.id.boton_inicio4:
                Intent l = new Intent(Menu.this,Lugares.class);
                startActivity(l);
                break;
        }



    }

}