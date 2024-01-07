package org.example;

public class PriorityQueue<T> implements ILista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public PriorityQueue() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        Nodo nuevoNodo = nodo;
        if (primero == null || nuevoNodo.compareTo(primero.getEtiqueta()) < 0) {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null && nuevoNodo.compareTo(actual.getSiguiente().getEtiqueta()) > 0) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public PriorityQueue union(PriorityQueue otraLista) {
        PriorityQueue<T> conjuntoAux = new PriorityQueue<>();
        Nodo<T> aux = primero;
        while (aux != null) {
            conjuntoAux.insertar(new Nodo<T>(aux.getEtiqueta(), aux.getDato()));
            aux = aux.getSiguiente();
        }

        Nodo<T> aux1 = otraLista.primero;
        while (aux1 != null) {
            if (buscar(aux1.getEtiqueta()) == null) {
                conjuntoAux.insertar(new Nodo<T>(aux1.getEtiqueta(), aux1.getDato()));
            }
            aux1 = aux1.getSiguiente();
        }
        otraLista.primero = null;
        primero = null;
        return conjuntoAux;
    }

    public PriorityQueue mezclaListasOrdenadas(PriorityQueue lista2) {
        PriorityQueue lista3 = new PriorityQueue(); // lista resultante
        Nodo actual1 = primero; // puntero a primer nodo de lista1
        Nodo actual2 = lista2.primero; // puntero a primer nodo de lista2

        while (actual1 != null && actual2 != null) {
            if (actual1.compareTo(actual2.getEtiqueta()) < 0) {
                lista3.insertar(new Nodo(actual1.getEtiqueta(), actual1.getDato())); // insertar nodo de lista1 en lista3
                actual1 = actual1.getSiguiente(); // avanzar al siguiente nodo de lista1
            } else {
                lista3.insertar(new Nodo(actual2.getEtiqueta(), actual2.getDato())); // insertar nodo de lista2 en lista3
                actual2 = actual2.getSiguiente(); // avanzar al siguiente nodo de lista2
            }
        }
        // si quedan nodos en lista1, insertarlos en lista3
        while (actual1 != null) {
            lista3.insertar(new Nodo(actual1.getEtiqueta(), actual1.getDato()));
            actual1 = actual1.getSiguiente();
        }
        // si quedan nodos en lista2, insertarlos en lista3
        while (actual2 != null) {
            lista3.insertar(new Nodo(actual2.getEtiqueta(), actual2.getDato()));
            actual2 = actual2.getSiguiente();
        }
        primero = null;
        lista2.primero = null;
        return lista3; // devolver la lista mezclada
    }

    public void insertar(Comparable etiqueta, T dato) {
        insertar(new Nodo<>(etiqueta, dato));
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> aux = primero;
        while (aux != null) {
            if (aux.getEtiqueta().equals(clave)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public Nodo<T> buscarPorDescripcion(String descripcion) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> aux = primero;
        while (aux != null) {
            Tarea temp = (Tarea) aux.getDato();
            if (temp.getDescripcion().equals(descripcion)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public int eliminarDuplicados() {
        int contador = 0;
        Nodo<T> nodo = primero;
        if (!this.esVacia()) {
            while (nodo != null) {
                Nodo<T> nodoDuplicado = nodo.getSiguiente();
                Nodo<T> anteriorDuplicado = nodo;

                while (nodoDuplicado != null) {
                    if (nodo.getEtiqueta().equals(nodoDuplicado.getEtiqueta())) {
                        anteriorDuplicado.setSiguiente(nodoDuplicado.getSiguiente());
                        contador++;
                    } else {
                        anteriorDuplicado = nodoDuplicado;
                    }
                    nodoDuplicado = nodoDuplicado.getSiguiente();
                }
                nodo = nodo.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        Nodo nodo = primero;
        Nodo anterior = null;
        if (!this.esVacia()) {
            if (primero.getEtiqueta().equals(clave)) {
                this.primero = primero.getSiguiente();
                return true;
            } else {
                while (nodo != null) {
                    if (nodo.getEtiqueta().equals(clave)) {
                        anterior.setSiguiente(nodo.getSiguiente());
                        return true;
                    }
                    anterior = nodo;
                    nodo = nodo.getSiguiente();
                }
            }
        }
        return false;
    }
    public boolean eliminarPorDescripcion(String descripcion) {
        Nodo<T> nodoTarea = buscarPorDescripcion(descripcion);
        Tarea tareaAEliminar = (Tarea) nodoTarea.getDato();
        Nodo nodo = primero;
        Nodo anterior = null;
        if (!this.esVacia()) {
            Tarea p = (Tarea) primero.getDato();
            if (p.getDescripcion().equals(tareaAEliminar.getDescripcion())) {
                this.primero = primero.getSiguiente();
                return true;
            } else {
                while (nodo != null) {
                    Tarea temp = (Tarea) nodo.getDato();
                    if (temp.getDescripcion().equals(tareaAEliminar.getDescripcion())) {
                        anterior.setSiguiente(nodo.getSiguiente());
                        return true;
                    }
                    anterior = nodo;
                    nodo = nodo.getSiguiente();
                }
            }
        }
        return false;
    }

    public void eliminarTareasRealizadas() {
        if (!esVacia()) {
            Nodo<T> aux = primero;
            while (aux != null) {
                Tarea temp = (Tarea) aux.getDato();
                if (temp.getDone()) {
                    eliminarPorDescripcion(temp.getDescripcion());
                }
                aux = aux.getSiguiente();
            }
        }
    }

    @Override
    public String imprimir() {
        if (esVacia()){
            return null;
        }

        StringBuilder strBuilder = new StringBuilder();
        Nodo actual = primero;
        int cont = 0;
        while(actual != null){
            strBuilder.append(++cont + ". " + actual.getDato().toString() + "\n");
            actual = actual.getSiguiente();
        }
        String str = strBuilder.toString();

        return str;
    }

    @Override
    public String imprimir(String separador) {
        if (esVacia()){
            return null;
        }

        StringBuilder strBuilder = new StringBuilder();
        Nodo actual = primero;
        int cont = 0;
        while(actual != null){
            strBuilder.append(++cont + ". " + actual.getDato().toString() + separador);
            actual = actual.getSiguiente();
        }
        String str = strBuilder.toString();

        return str;
    }

    @Override
    public int cantElementos() {
        Nodo<T> actual = primero;
        int cont = 0;
        while (actual != null){
            cont++;
            actual = actual.getSiguiente();
        }
        return cont;
    }
    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    public Nodo<T> getPrimero(){
        return this.primero;
    }

    public PriorityQueue<T> ordenaParesImpares(){
        PriorityQueue<T> listaPares = new PriorityQueue<>();
        PriorityQueue<T> listaOrdenada = new PriorityQueue<T>();
        Nodo<T> actual = getPrimero();

        while(actual != null){
            if((Integer.parseInt(actual.getEtiqueta().toString()) % 2) == 0){
                listaPares.insertar(actual);
            } else {
                listaOrdenada.insertar(actual);
            }
            actual = actual.getSiguiente();
        }
        Nodo<T> union = listaOrdenada.getPrimero();
        while(union.getSiguiente() != null){
            union = union.getSiguiente();
        }
        union.setSiguiente(listaPares.getPrimero());

        return listaOrdenada;
    }
}
