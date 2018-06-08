package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Padre;

public interface IPadreRepo {
    Padre getPadre(String email);
    boolean createPadre(Padre obj);
}
