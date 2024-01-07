package org.example;
import java.util.Comparator;
import java.util.PriorityQueue;
public class ToDoListPriorityQueue {
    private PriorityQueue<Tarea> tareas;

    public ToDoListPriorityQueue() {
        this.tareas = new PriorityQueue<Tarea>(Comparator.comparingInt(Tarea::getPrioridad));
    }

    public void agregarTarea(String descripcion, int prioridad) {
        Tarea tarea = new Tarea(descripcion, prioridad);
        tareas.offer(tarea);
    }

    private Tarea buscarTarea(String descripcion) {
        for (Tarea t : tareas) {
            if (t.getDescripcion().equals(descripcion)) {
                return t;
            }
        }
        return null;
    }

    public boolean eliminarTarea(String descripcion) {
        if (buscarTarea(descripcion) != null) {
            Tarea tarea = buscarTarea(descripcion);
            tareas.remove(tarea);
            return true;
        }
        return false;
    }

    public void eliminarTareasRealizadas() {
        tareas.removeIf(Tarea::isDone);
    }

    public String imprimirTareas() {
        if (tareas.isEmpty()) {
            return "La lista de tareas está vacía";
        } else {
            StringBuilder sb = new StringBuilder();
            int n = 1;
            for (Tarea tarea : tareas) {
                sb.append(n++ + ". " + tarea.toString() + " \n");
            }
            return sb.toString();
        }
    }

    public int size() {
        return tareas.size();
    }

    public void done(String descripcion) {
        for (Tarea t : tareas) {
            if (t.getDescripcion().equals(descripcion)) {
                t.setDone(true);
            }
        }
    }

    public void notDone(String descripcion) {
        for (Tarea t : tareas) {
            if (t.getDescripcion().equals(descripcion)) {
                t.setDone(false);
            }
        }
    }
}
