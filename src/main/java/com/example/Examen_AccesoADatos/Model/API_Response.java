package com.example.Examen_AccesoADatos.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API_Response <T>{
    private boolean success;
    private String message;
    //Declaramos un generico para el objeto tipo data
    private T data;

    public API_Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
