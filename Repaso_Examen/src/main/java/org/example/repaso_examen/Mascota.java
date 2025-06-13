package org.example.repaso_examen;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mascota implements Serializable {

    private static final long serialVersionUID = -5363105188928012598L;

    private String nombre;
    private String pasaporte;
    private LocalDate fechaNacimiento;
    private double peso;
    private Propietario propietario;
    private Tipo tipo;

    // CONSTRUCTOR

    public Mascota(String nombre, String pasaporte, LocalDate fechaNacimiento, double peso, Propietario propietario, Tipo tipo) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.propietario = propietario;
        this.tipo = tipo;
    }


    // GETS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre +
                ", pasaporte='" + pasaporte +
                ", fechaNacimiento=" + fechaNacimiento +
                ", peso=" + peso +
                ", propietario=" + propietario.getNombre() + " + " + propietario.getDni() +
                ", tipo=" + tipo.getTipo() +
                '}';
    }
}
