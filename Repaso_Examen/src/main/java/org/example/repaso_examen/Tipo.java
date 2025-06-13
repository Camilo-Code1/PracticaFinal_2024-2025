package org.example.repaso_examen;

import java.io.Serializable;

public class Tipo implements Serializable {

    private static final long serialVersionUID = 1159599640804256406L;

    private String tipo;
    private int id;

    public Tipo(String tipo, int id) {
        this.tipo = tipo;
        this.id = id;

    }

    public String getTipo() {
        return tipo;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tipo" +
                tipo +
                '}';
    }
}
