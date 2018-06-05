package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

public class Profesor {
     private int idprofesor          ;
     private String nombre           ;
     private String apellido         ;
     private String password         ;
     private String email            ;
     private String celular          ;
     private String descripcion      ;
     private Float preciomin          ;
     private Float preciomax          ;
      private String  experiencia     ;
     private long calificacion        ;
     private long dni                 ;
     private String antecedentes     ;
     private String fotourl;
     private int id_metodopago ;


    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombre",getNombre());
            jsonObject.put("apellido", getApellido());
            jsonObject.put("password", getPassword());
            jsonObject.put("email", getEmail());
            jsonObject.put("celular", getCelular());
            jsonObject.put("descripcion", getDescripcion());

            jsonObject.put("preciomin", getPreciomin());
            jsonObject.put("preciomax", getPreciomax());
            jsonObject.put("experiencia", getExperiencia());
            jsonObject.put("calificacion", getCalificacion());
            jsonObject.put("dni", getDni());
            jsonObject.put("antecedentes", getAntecedentes());
            jsonObject.put("fotourl", getFotourl());
            jsonObject.put("id_metodopago", getId_metodopago());


            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPreciomin() {
        return preciomin;
    }

    public void setPreciomin(Float preciomin) {
        this.preciomin = preciomin;
    }

    public Float getPreciomax() {
        return preciomax;
    }

    public void setPreciomax(Float preciomax) {
        this.preciomax = preciomax;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(long calificacion) {
        this.calificacion = calificacion;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }


    public String getFotourl() {
        return fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }

    public int getId_metodopago() {
        return id_metodopago;
    }

    public void setId_metodopago(int id_metodopago) {
        this.id_metodopago = id_metodopago;
    }
}
