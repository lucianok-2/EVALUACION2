package com.example.evaluacion2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion2.ProductoEntidad.Producto;
import com.example.evaluacion2.R;
import com.example.evaluacion2.modificar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Producto_Adapter extends RecyclerView.Adapter<Producto_Adapter.ProductoViewHolder> {

    ArrayList<Producto> listaProductos;
    ArrayList<Producto> listaOriginal;

    public Producto_Adapter(ArrayList<Producto> listaProductos){
        this.listaProductos=listaProductos;
        this.listaOriginal= new ArrayList<>();
        listaOriginal.addAll(listaProductos);



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

    public void filtro_busqueda(String sv_Buscar){
        int longitud = sv_Buscar.length();
        if(longitud == 0){
            listaProductos.clear();
            listaProductos.addAll(listaOriginal);

        }else{
            List<Producto> collecion = listaProductos.stream().filter(i -> i.getNombre().toLowerCase().contains(sv_Buscar.toLowerCase()))
                    .collect(Collectors.toList());
            listaProductos.clear();
            listaProductos.addAll(collecion);

        }
        notifyDataSetChanged();



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
    public void ordenarProductos(int atributo) {
        switch (atributo) {
            case 0:
                // Ordenar por nombre
                Collections.sort(listaProductos, new Comparator<Producto>() {
                    @Override
                    public int compare(Producto p1, Producto p2) {
                        return p1.getNombre().compareTo(p2.getNombre());
                    }
                });
                break;
            case 1:
                // Ordenar por fecha de vencimiento
                Collections.sort(listaProductos, new Comparator<Producto>() {
                    @Override
                    public int compare(Producto p1, Producto p2) {
                        return p1.getFecha_v().compareTo(p2.getFecha_v());
                    }
                });
                break;
            case 2:
                // Ordenar por precio
                Collections.sort(listaProductos, new Comparator<Producto>() {
                    @Override
                    public int compare(Producto p1, Producto p2) {
                        return Double.compare(Double.parseDouble(p1.getPrecio()), Double.parseDouble(p2.getPrecio()));
                    }
                });
                break;
            case 3:
                // Ordenar por cantidad
                Collections.sort(listaProductos, new Comparator<Producto>() {
                    @Override
                    public int compare(Producto p1, Producto p2) {
                        return Integer.compare(Integer.parseInt(p1.getCantidad()), Integer.parseInt(p2.getCantidad()));
                    }
                });
                break;
            default:
                break;
        }
        notifyDataSetChanged();
    }
}
