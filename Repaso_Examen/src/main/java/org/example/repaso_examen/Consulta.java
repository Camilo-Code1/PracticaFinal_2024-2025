package org.example.repaso_examen;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta implements Serializable {

    private static final long serialVersionUID = 2347763147909950714L;

    private long fecha;
    private int duracion;
    private String observaciones;
    private Mascota mascota;

    public Consulta(Mascota mascota, String observaciones, int duracion, long fecha) {
        this.mascota = mascota;
        this.observaciones = observaciones;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "fecha=" + fecha +
                ", duracion=" + duracion +
                ", observaciones='" + observaciones + '\'' +
                ", mascota=" + mascota.getNombre() + " - " + mascota.getPasaporte() +
                ", propietario=" + mascota.getPropietario().getNombre() + " - " + mascota.getPropietario().getDni() +
                '}';
    }
}
