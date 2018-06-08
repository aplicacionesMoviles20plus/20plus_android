package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Profesor;

import java.util.ArrayList;

public interface IProfeRepo {
    Profesor getProfesor(String email);
    ArrayList<Profesor> getProfesors();
    boolean createProfesor(Profesor obj);
}
