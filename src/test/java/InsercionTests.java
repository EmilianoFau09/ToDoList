import org.example.Nodo;
import org.example.Tarea;
import org.example.ToDoList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsercionTests {
    private ToDoList toDoList;
    @Before
    public void setUp() {
        toDoList = new ToDoList();

        toDoList.agregarTarea("Estudiar algoritmos", 1);
        toDoList.agregarTarea("Comer", 3);
        toDoList.agregarTarea("Saludar al vecino", 2);
        toDoList.agregarTarea("Programar ToDo List", 1);
    }
    @Test
    public void insertarTareaTest1() {
        assertEquals(4, toDoList.size());
        toDoList.agregarTarea("Hola", 2);
        assertEquals(5, toDoList.size());
    }

    @Test
    public void insertarTareaTest2() {
        assertEquals(4, toDoList.size());
        Tarea temp = new Tarea("Hola", 2);
        toDoList.agregarTarea(temp);
        assertEquals(5, toDoList.size());
    }

    @Test
    public void insertarTareaTest3() {
        assertEquals(4, toDoList.size());
        Tarea temp = new Tarea("Hola", 2);
        Nodo nodo = new Nodo<>(temp.getPrioridad(), temp);
        toDoList.agregarTarea(nodo);
        assertEquals(5, toDoList.size());
    }
}
