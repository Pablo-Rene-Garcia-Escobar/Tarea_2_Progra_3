package edu.umg;

public class Main {

    public static void main(String[] args) {

        ListaEnlazadaSimple<Integer> listaEnteros = new ListaEnlazadaSimple<Integer>();
        listaEnteros.agregarAlInicio(5);
        listaEnteros.agregarAlInicio(2);
        listaEnteros.agregarAlInicio(10);
        listaEnteros.agregarAlFinal(100);

        //Ejecuta el metodo eliminar ultimo nodo y muestra un mensaje en pantalla
        if(listaEnteros.eliminarUltimo() == true){
            System.out.println("El ultimo nodo se ha eliminado");
        }else{
            System.out.println("No hay elementos que eliminar en la lista");
        }

        //Ejecuta el metodo buscar y si arroja excepcion es por que no encontro el elemento y muestra el mensaje correspondiente
        try{
            System.out.println("Se elimino: " + listaEnteros.buscar(10));
        }catch(Exception e){
            System.out.println("No se encontro el dato a eliminar");
        }

        listaEnteros.recorrer();
        System.out.println("");

        //Sheyla, Merleen, Jose Eduardo
        ListaEnlazadaSimple<String> listaStrings  = new ListaEnlazadaSimple<String>();
        listaStrings.agregarAlInicio("Jose Eduardo");
        listaStrings.agregarAlInicio("Merleen");
        listaStrings.agregarAlInicio("Sheyla");
        //listaStrings.recorrer();
        //Ejecuta el metodo eliminar ultimo nodo y muestra un mensaje en pantalla
        if(listaStrings.eliminarUltimo() == true){
            System.out.println("El ultimo nodo se ha eliminado");
        }else{
            System.out.println("No hay elementos que eliminar en la lista");
        }

        //Ejecuta el metodo buscar y si arroja excepcion es por que no encontro el elemento y muestra el mensaje correspondiente
        try{
            System.out.println("Se elimino: " + listaStrings.buscar("Merleen"));
        }catch(Exception e){
            System.out.println("No se encontro el dato a eliminar");
        }

        listaStrings.recorrer();



        //{Bitcoin, $40,000}, {Ethereum, $3,000}, {Litecoin, $150}
        ListaEnlazadaSimple<Criptomoneda> listaCriptomonedas  = new ListaEnlazadaSimple<Criptomoneda>();
        listaCriptomonedas.agregarAlInicio(new Criptomoneda("BITCOIN", 40000.00));
        listaCriptomonedas.agregarAlInicio(new Criptomoneda("ETHEREUM", 3000.00));
        listaCriptomonedas.agregarAlInicio(new Criptomoneda("LITECOIN", 150.00));
        Nodo<Criptomoneda> resultadoCriptomoneda = listaCriptomonedas.buscar(new Criptomoneda("ETHEREUM"));
    }

}
