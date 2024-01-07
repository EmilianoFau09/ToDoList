import org.example.Tarea;
import org.example.ToDoList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusquedaTests {
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
    public void buscarTareaExistenteTest() {
        Tarea temp = new Tarea("Comer", 3);
        assertEquals(temp.getDescripcion(), toDoList.buscarTarea("Comer").getDescripcion());
    }

    @Test
    public void buscarTareaInexistenteTest() {
        assertEquals(null, toDoList.buscarTarea("Ver la nueva de Marvel"));
    }
}
