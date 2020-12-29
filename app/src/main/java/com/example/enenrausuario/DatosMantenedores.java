package com.example.enenrausuario;

public class DatosMantenedores {

    private String id;
    private String nombre;
    private String rut;
    private String telefono;

    public DatosMantenedores(String id, String nombre, String rut, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DatosMantenedores(){

    }

    public String toString(){

        return " Nombre  :"+this.getNombre().toString()+System.getProperty("line.separator")+" RUT :"+this.getRut().toString()+System.getProperty("line.separator")+"Telefono : "+this.getTelefono().toString();
        //return " Nombre  :"+this.getNombre().toString() +"\n"+  " RUT  :  "+this.getRut().toString()+"\n"+ "  TELEFONO  "+this.getTelefono();

    }



}
