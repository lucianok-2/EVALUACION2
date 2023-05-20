package com.example.evaluacion2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbProductos extends DbHelper{

    Context context;
    public DbProductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long CrearProducto(String nombre , String fecha_compra, String fecha_vencimiento,String Lugar,String marca,String precio, String cantidad ){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db =dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre",nombre);
            values.put("fecha_compra",fecha_compra);
            values.put("fecha_vencimiento",fecha_vencimiento);
            values.put("Lugar",Lugar);
            values.put("marca",marca);
            values.put("precio",precio);
            values.put("cantidad",cantidad);

             id = db.insert(TABLE_PRODUCTOS, null, values);


        }catch (Exception ex){
            ex.toString();

        }
        return id;



    }
}
