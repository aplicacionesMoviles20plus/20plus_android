package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Profesor;

import java.util.ArrayList;

public interface IProfeRepo {
    Profesor getProfesor(String email);
    ArrayList<Profesor> getProfesors();
    boolean createProfesor(Profesor obj);
    ArrayList<Profesor> getProfesorsNoUser(int iduser);
    ArrayList<Profesor> getProfesorByZona(int idzona,int iduser);
    ArrayList<Profesor> getProfesorByGrado(int idcurso,int iduser);
}
