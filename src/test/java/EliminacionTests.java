import org.example.ToDoList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EliminacionTests {
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
    public void eliminarListaVaciaTest() {
        ToDoList tdl = new ToDoList();
        assertEquals(0, tdl.size());
        assertFalse(tdl.eliminarTarea("Comer"));
        assertEquals(0, tdl.size());
    }

    @Test
    public void eliminarTareaInexistenteTest() {
        assertEquals(4, toDoList.size());
        assertFalse(toDoList.eliminarTarea("Jugar a la rayuela"));
        assertEquals(4, toDoList.size());
    }

    @Test
    public void eliminarTareaExistenteTest() {
        assertEquals(4, toDoList.size());
        assertTrue(toDoList.eliminarTarea("Comer"));
        assertEquals(3, toDoList.size());
    }

    @Test
    public void eliminarTareasRealizadasTest() {
        assertEquals(4, toDoList.size());
        toDoList.done("Estudiar algoritmos");
        toDoList.done("Programar ToDo List");
        toDoList.eliminarTareasRealizadas();
        assertEquals(2, toDoList.size());
    }
}
