package org.example;

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        toDoList.agregarTarea("Estudiar algoritmos", 1);
        toDoList.agregarTarea("Comer", 3);
        toDoList.agregarTarea("Tomar agua", 2);
        toDoList.agregarTarea("Saludar al vecino", 2);
        toDoList.agregarTarea("Programar ToDo List", 1);

        System.out.println(toDoList.imprimirTareas());

        toDoList.eliminarTarea("Saludar al vecino");
        toDoList.done("Comer");
        toDoList.done("Tomar agua");
        toDoList.done("Programar ToDo List");

        System.out.println(toDoList.imprimirTareas());

        toDoList.notDone("Comer");

        System.out.println(toDoList.imprimirTareas());

        System.out.println(toDoList.size());
        toDoList.eliminarTareasRealizadas();
        System.out.println(toDoList.imprimirTareas());
        System.out.println(toDoList.size());
    }
}