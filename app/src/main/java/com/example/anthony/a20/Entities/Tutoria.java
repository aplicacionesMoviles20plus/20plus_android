package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.Calendar;

public class Tutoria {
   private int idtutoria;
   private Date hora ;
   private Date fecha ;
   private Float   precio;
   private String comentario;
   private int calificacion ;
   private int id_padre;
   private String estado;
   private String curso;
   private int id_horario;
   private int id_servicio;
   private int numerohoras;

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("hora",getHora());
            jsonObject.put("fecha", getFecha());
            jsonObject.put("precio", getPrecio());
            jsonObject.put("comentario",getComentario());
            jsonObject.put("calificacion", getCalificacion());
            jsonObject.put("id_padre", getId_padre());
            jsonObject.put("estado",getEstado());
            jsonObject.put("curso", getCurso());
            jsonObject.put("id_horario", getId_horario());
            jsonObject.put("id_servicio", getId_servicio());
            jsonObject.put("numerohoras", getNumerohoras());
            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public int getIdtutoria() {
        return idtutoria;
    }

    public void setIdtutoria(int idtutoria) {
        this.idtutoria = idtutoria;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getNumerohoras() {
        return numerohoras;
    }

    public void setNumerohoras(int numerohoras) {
        this.numerohoras = numerohoras;
    }


}
