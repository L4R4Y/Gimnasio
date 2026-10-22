package com.example.gimnasio;

public class Miembro{

    private String nombre;
    private int edad;

    public Miembro(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int Edad){
        if (edad > 0){
            this.edad = edad;
        }
    }

    public double cuotaMensual() {
        return 50000.0;
    }

    public String descripcion() {
        return nombre + " (" + edad + " años)";
    }
    

}