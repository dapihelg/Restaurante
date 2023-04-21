import java.util.Scanner;

public class Restaurante {
    public static class Nodo {
        Object cliente;
        Object orden;
        Nodo siguiente;

        public Nodo(Object cliente, Object orden) {
            this.cliente = cliente;
            this.orden = orden;
            this.siguiente = null;
        }
    }

    public static class Cola {
        Nodo frente;
        Nodo fondo;
        Nodo aux;

        public Cola() {
            this.frente = null;
            this.fondo = null;
            this.aux = null;
        }

        public boolean colaVacia(){
            return frente == null;
        }

        // Método que inserta
        public void insertar(Object cliente, Object orden){
            Nodo nuevo = new Nodo(cliente,orden);
            if(colaVacia()){
                frente = fondo = nuevo;
            } else{
                fondo.siguiente = nuevo;
                fondo = nuevo;
            }
        }

        //Método que elimina órdenes
        public void extraer(){
            if(!colaVacia()){
                frente = frente.siguiente;
            } else{
                System.out.println("No hay ordenes");
            }
        }

        public void imprimir(){
            Nodo nu = frente;
            while(nu != null) {
                System.out.println("Cliente " + nu.cliente + " órden " + nu.orden);
                nu = nu.siguiente;
            }
        }
    }

    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        int respuesta = 0, respuesta2 = 0;
        String cliente, orden;

        Cola cola = new Cola();

        cola.insertar("Roberto", "hamburguesa sencilla");
        cola.insertar("José", "hamburguesa con queso");
        cola.insertar("Mario", "hamburguesa sencilla");
        cola.insertar("Luis", "hamburguesa sencilla");
        cola.insertar("Alexa", "hamburguesa con queso");

        System.out.println("\n");
        cola.imprimir();
        System.out.println("\n");
        cola.extraer();
        System.out.println("\n");
        cola.imprimir();
        System.out.println("\n");

        do{
            System.out.println("1.- para agregar órden");
            System.out.println("2.- para entregar órden");
            System.out.println("3.- mostrar órdenes ");
            System.out.println("4.- Salir ");
            respuesta = datos.nextInt();

            switch (respuesta){

                case 1:
                    System.out.println("Ingrese el nombre del cliente: ");
                    cliente = datos.next();
                    System.out.println("Ingrese la órden: \n" +
                            "1.- Hamburguesa sencilla"+"\n"+"2.- Hamburguesa con queso");
                    respuesta2 = datos.nextInt();
                    if(respuesta2 == 1){
                        orden = "Hamburguesa sencilla";
                    } else{
                        orden = "Hamburguesa con queso";
                    }
                    cola.insertar(cliente,orden);
            }

        } while(respuesta != 4);

    }
}