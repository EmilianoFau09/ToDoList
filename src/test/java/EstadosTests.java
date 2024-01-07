import org.example.Tarea;
import org.example.ToDoList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EstadosTests {
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
    public void cambiarEstadoRealizadoATrueExistenteTest() {
        toDoList.done("Comer");
        assertTrue(toDoList.buscarTarea("Comer").getDone());
    }

    @Test
    public void cambiarEstadoRealizadoAFalseExistenteTest() {
        toDoList.done("Comer");
        assertTrue(toDoList.buscarTarea("Comer").getDone());
        toDoList.notDone("Comer");
        assertFalse(toDoList.buscarTarea("Comer").getDone());
    }

    @Test
    public void cambiarEstadoRealizadoATrueInexistenteTest() {
        toDoList.done("Jugar al ping-pong");
        assertFalse(toDoList.done("Jugar al ping-pong"));
    }

    @Test
    public void cambiarEstadoRealizadoAFalseInexistenteTest() {
        toDoList.notDone("Jugar al ping-pong");
        assertFalse(toDoList.done("Jugar al ping-pong"));
    }
}
