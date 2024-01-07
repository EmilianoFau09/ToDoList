package org.example;

public class ToDoList {

    private PriorityQueue<Tarea> tareas;

    public ToDoList() {
        this.tareas = new PriorityQueue<>();
    }
    public void agregarTarea(String descripcion, int prioridad) {
        Tarea tarea = new Tarea(descripcion, prioridad);
        Nodo nodo = new Nodo(prioridad, tarea);
        tareas.insertar(nodo);
    }

    public void agregarTarea(Nodo nodo) {
        tareas.insertar(nodo);
    }

    public void agregarTarea(Tarea tarea) {
        Nodo nodo = new Nodo(tarea.getPrioridad(), tarea);
        tareas.insertar(nodo);
    }

    public Tarea buscarTarea(String descripcion) {
        if (tareas.buscarPorDescripcion(descripcion) != null) {
            Nodo nodo = tareas.buscarPorDescripcion(descripcion);
            Tarea tarea = (Tarea) nodo.getDato();
            return tarea;
        }
        return null;
    }

    public boolean eliminarTarea(String descripcion) {
        if (buscarTarea(descripcion) != null) {
            return tareas.eliminarPorDescripcion(descripcion);
        }
        return false;
    }

    public void eliminarTareasRealizadas() {
        if (!tareas.esVacia()) {
            tareas.eliminarTareasRealizadas();
        }
    }

    public String imprimirTareas() {
        if (tareas.esVacia()) {
            return "La lista de tareas está vacía";
        } else {
            return tareas.imprimir();
        }
    }

    public int size() {
        return tareas.cantElementos();
    }

    public boolean done(String descripcion) {
        if (!tareas.esVacia() && buscarTarea(descripcion) != null) {
            Tarea tarea = buscarTarea(descripcion);
            tarea.setDone(true);
            return true;
        }
        return false;
    }

    public boolean notDone(String descripcion) {
        if (!tareas.esVacia() && buscarTarea(descripcion) != null) {
            Tarea tarea = buscarTarea(descripcion);
            tarea.setDone(false);
            return true;
        }
        return false;
    }
}
