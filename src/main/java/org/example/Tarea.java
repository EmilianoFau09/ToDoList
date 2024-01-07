package org.example;

public class Tarea {
    private String descripcion;
    private int prioridad;
    private boolean done;

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.done = false;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean getDone() {
        return done;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String toString() {
        return "Descripción: " + descripcion + ", Prioridad: " + prioridad + ", Realizada: " + done;
    }
}
