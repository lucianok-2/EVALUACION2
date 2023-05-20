package com.example.evaluacion2.ProductoEntidad;

public class Producto {
    private int id;
    private String nombre;
    private String fecha_c;
    private String fecha_v;
    private String lugar;
    private String marca;
    private String precio;
    private String cantidad;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_c() {
        return fecha_c;
    }

    public void setFecha_c(String fecha_c) {
        this.fecha_c = fecha_c;
    }

    public String getFecha_v() {
        return fecha_v;
    }

    public void setFecha_v(String fecha_v) {
        this.fecha_v = fecha_v;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
