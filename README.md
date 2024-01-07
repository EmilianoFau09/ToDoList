# To-Do List

## Introducción
El presente proyecto fue realizado con el fin de piner en práctica algunas de las herramientas dadas en clase en este curso. 
En este caso, se me ocurrió la idea de simular una aplicación de To-Do List utilizando Cola de Prioridades y Listas enlazadas ordenadas, implementándolo desde el TDA previsto en clase.
Una dificultad extra que decidí agregarle a este proyecto es el requisito de que, no importa la modificación que se realice sobre las tareas, estas deben estar ordenadas por prioridad.

## Funcionalidades
Se cuenta con una clase Tarea la cual posee los atributos que a mi parecer son necesarios para definir una tarea.
Además, se presenta una clase ToDoList, la cual contiene una lista de tareas y varios métodos para utilizar, algunos de ellos son, entre otros:
- Inserción.
- Eliminación.
- Búsqueda.
- Cambios de estado (realizado y no realizado).

Por último, la lista de tareas se trata de una Priority Queue, una clase diseñada con el fin de simular el comportamiento de la anteriormente mencionada, implementando diversos métodos de inserción, búsqueda, eliminación y demás a nivel de nodos.

## Tests 
En el apartado de Tests se cuenta con los tests derivados hacía cada funcionalidad del programa en particular (inserción, búsqueda, eliminación y otros), verificando su correcto funcionamiento.
