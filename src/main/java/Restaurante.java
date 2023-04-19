public class Restaurante {
    public static void main(String[] args) {
        String cliente = "";
        String pedido = "";
        Cola cola = new Cola(cliente, pedido);

        cola.insertar("Roberto", "hamburguesa sencilla");
        cola.insertar("José", "hamburguesa con queso");
        cola.insertar("Mario", "hamburguesa sencilla");
        cola.insertar("Luis", "hamburguesa sencilla");
        cola.insertar("Alexa", "hamburguesa con queso");

        cola.extraer();


    }

    public static class Nodo {
        Object cliente;
        Object pedido;
        Nodo siguiente;

        public Nodo(Object cliente, Object pedido) {
            this.cliente = cliente;
            this.pedido = pedido;
            this.siguiente = null;
        }
    }

    public static class Cola {
        String cliente;
        String pedido;
        Nodo frente;
        Nodo fondo;

        public Cola(String cliente, String pedido) {
            this.cliente = cliente;
            this.pedido = pedido;
            this.frente = null;
            this.fondo = null;
        }

        public boolean colaVacia(){
            return true;
        }

        // Método que inserta
        public void insertar(String cliente, String pedido){
            Nodo nuevo = new Nodo(cliente,pedido);
            nuevo.cliente = cliente;
            nuevo.pedido = pedido;

            if(colaVacia()){
                frente = nuevo;
                fondo = nuevo;
            } else{
                fondo.siguiente = nuevo;
                fondo = nuevo;
            }
        }

        //Método que elimina órdenes
        public void extraer(){
            Nodo aux = new Nodo(cliente,pedido);
            aux = frente;
            frente.siguiente = frente;
        }

        public void imprimir(String cliente, String pedido){
            Nodo nu = frente;
            System.out.println("Cliente "+nu.cliente+" pedido "+nu.pedido);
            nu = frente.siguiente;
        }
    }

}
