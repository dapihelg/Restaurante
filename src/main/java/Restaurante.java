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

        public boolean colaVacia() {
            return frente == null;
        }

        // Método que inserta
        public void insertar(Object cliente, Object orden) {
            Nodo nuevo = new Nodo(cliente, orden);
            if (colaVacia()) {
                frente = fondo = nuevo;
            } else {
                fondo.siguiente = nuevo;
                fondo = nuevo;
            }
        }

        //Método que elimina órdenes
        public void extraer() {
            if (!colaVacia()) {
                frente = frente.siguiente;
            } else {
                System.out.println("No hay ordenes");
            }
        }

        public void imprimir() {
            Nodo nu = frente;
            int indice = 1;
            while (nu != null) {
                System.out.println(indice + " Cliente " + nu.cliente + " órden " + nu.orden);
                indice++;
                nu = nu.siguiente;
            }
        }
    }

    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        int respuesta, respuesta2;
        String cliente, orden;

        Cola cola = new Cola();

        do {
            System.out.println("");
            System.out.println("1.- para agregar órden");
            System.out.println("2.- para entregar órden");
            System.out.println("3.- mostrar órdenes ");
            System.out.println("4.- Salir ");
            System.out.println("");
            respuesta = datos.nextInt();

            switch (respuesta) {

                case 1:
                    System.out.println("");
                    System.out.println("Ingrese el nombre del cliente: ");
                    cliente = datos.next();
                    System.out.println("");
                    System.out.println("""
                            Ingrese la órden:\s
                            1.- Hamburguesa sencilla
                            2.- Hamburguesa con queso""");
                    respuesta2 = datos.nextInt();
                    if (respuesta2 == 1) {
                        orden = "Hamburguesa sencilla";
                    } else {
                        orden = "Hamburguesa con queso";
                    }
                    cola.insertar(cliente, orden);
                    System.out.println("");
                    cola.imprimir();
                    System.out.println("");

                    break;

                case 2:
                    System.out.println("");
                    cola.extraer();
                    cola.imprimir();
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("");
                    cola.imprimir();
                    System.out.println("");
                                       
                    break;                   
            }
        } while (respuesta < 4);

    }
}
