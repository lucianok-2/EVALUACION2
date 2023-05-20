package com.example.evaluacion2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion2.Lista_compras;
import com.example.evaluacion2.ProductoEntidad.Producto;
import com.example.evaluacion2.R;
import com.example.evaluacion2.modificar;

import java.util.ArrayList;

public class Producto_Adapter extends RecyclerView.Adapter<Producto_Adapter.ProductoViewHolder> {

    ArrayList<Producto> listaProductos;

    public Producto_Adapter(ArrayList<Producto> listaProductos){
        this.listaProductos=listaProductos;



    }


    @NonNull
    @Override
    public Producto_Adapter.ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, null,false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Producto_Adapter.ProductoViewHolder holder, int position) {
        holder.vNombre.setText(listaProductos.get(position).getNombre());
        holder.vFecha_v.setText(listaProductos.get(position).getFecha_v());
        holder.vprecio.setText(listaProductos.get(position).getPrecio());
        holder.vcantidad.setText(listaProductos.get(position).getCantidad());


    }

    @Override
    public int getItemCount() {
        return listaProductos.size();


    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {

        TextView vNombre, vFecha_v, vprecio,vcantidad;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            vNombre = itemView.findViewById(R.id.nombre_producto);
            vFecha_v = itemView.findViewById(R.id.fecha_vencimiento_producto);
            vprecio = itemView.findViewById(R.id.precio_producto);
            vcantidad = itemView.findViewById(R.id.cantidad_producto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, modificar.class);
                    intent.putExtra("ID",listaProductos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);

                }
            });

        }
    }
}
