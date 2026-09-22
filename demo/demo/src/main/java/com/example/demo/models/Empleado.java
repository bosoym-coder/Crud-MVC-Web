package com.example.demo.models;

public class Empleado {
    private int codigo;
    private String nombre;
    private String puesto;

    public Empleado(int codigo, String nombre, String puesto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
}