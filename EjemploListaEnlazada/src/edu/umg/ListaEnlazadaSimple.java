package edu.umg;

public class ListaEnlazadaSimple<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private Nodo<T> actual;
    private int cantidad;

    public ListaEnlazadaSimple() {
        cantidad = 0;
        primero = null;
        ultimo = null;
        actual = null;
    }

    public void agregarAlInicio( T info ){

        //1. Crear un nodo e inicializar el campo dato al nuevo elemento (info).
        // La referencia del nodo creado se asigna a nuevo, variable local del método.
        Nodo<T> nuevoNodo = new Nodo<T>(info);

        //2. Hacer que el campo siguiente del nuevo nodo apunte a primero de la lista original.
        nuevoNodo.setSiguiente(primero);

        //3. Hacer que primero apunte al nuevo nodo.
        primero = nuevoNodo;

        //4. Asignar el valor del ultimo únicamente cuando la lista se encuentra vacía
        if( cantidad == 0 ){
            ultimo = nuevoNodo;
        }

        cantidad++;

    }

    public void agregarAlFinal( T info ){

        //1. Crear un nodo e inicializar el campo dato al nuevo elemento (info).
        // La referencia del nodo creado se asigna a nuevo, variable local del método.
        Nodo<T> nuevoNodo = new Nodo<T>(info);

        //2. El puntero siguiente del ultimo nodo debe apuntar al nuevoNodo
        ultimo.setSiguiente(nuevoNodo);

        //3. actualizar el valor de ultimo para que apunte al nuevoNodo
        ultimo = nuevoNodo;

        //4. Asignar el valor del primero únicamente cuando la lista se encuentra vacía
        if( cantidad == 0 ){
            primero = nuevoNodo;
        }

        cantidad++;

    }

    public void recorrer(){

        //1. ubicar el primer elemento de la lista
        actual = primero;

        while(  actual != null  ) {
            //2. leer el dato y mostrarlo en pantalla
            System.out.print(actual.getDato() + " -> ");

            //3. Identificar su siguiente nodo
            actual = actual.getSiguiente();
        }

        System.out.println("null");

    }

    /**
     * Metodo para buscar y eliminar un nodo expecifico en una lista enlazada
     * @param datoABuscar enviar el dato a buscar
     * @return null=no existe el nodo o <>null si existe el elmento
     */
    public Nodo<T> buscar(T datoABuscar) {

        //1. ubicar el primer elemento de la lista.
        actual = primero;

        //2. crear un nuecvo puntero llamado anterior
        Nodo<T> anterior = null;

        //3. Se recorre mientras el elemento del puntero "actual" no sea igual a null y no se encuentre el dato a buscar
        while (actual != null && !actual.getDato().equals(datoABuscar)) {

            //4. Identificar su siguiente nodo
            anterior = actual;
            actual = actual.getSiguiente();
        }

        //5. Guardar el elemento antes de eliminarlo para mostrarlo
        Nodo<T> dato;
        dato=actual;

        //6. validamos si el primer dato es el que deseamos eliminar y lo eliminamos
        if (primero == actual) {
            primero = actual.getSiguiente();
        }else {
            //7. Establecemos que el puntero "siguiente" del dato anterior al que queremos eliminar apunte al dato siguiente del que queremos eliminar
            anterior.setSiguiente(actual.getSiguiente());
        }

        return dato;

    }

    public boolean eliminarUltimo(){

        //1. ubicar el primer elemento de la lista
        actual = primero;

        //2. Bandera para indicar si hay un nodo en la lista para eliminar
        boolean eliminado = false;

        //3. if que valua si hay algun elemento en la lista
        if(cantidad != 0){

            //4. if que valua si solo hay un elemento en la lista
            if (cantidad == 1) {

                //5. si solo hay un elemento en la lista pasa a ser null
                primero = null;
                actual = null;
                ultimo = null;
                eliminado = true;

            } else {

                //6. La lista se recorre hasta que el siguiente de actual sea el ultimo
                while(!actual.getSiguiente().equals(ultimo)){

                    actual = actual.getSiguiente();

                }

                //7. El ultimo pasa a ser el actual
                ultimo = actual;

                //8. el siguiente de actual pasa a ser null
                actual.setSiguiente(null);
                eliminado = true;

            }
        }

        return eliminado;
    }



}
