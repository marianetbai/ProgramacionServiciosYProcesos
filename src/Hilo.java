public class Hilo implements Runnable {
    Contador contador;
    int numVeces;

    public Hilo(Contador contador, int numVeces) {
        this.contador = contador;
        this.numVeces = numVeces;
    }

    @Override
    public void run() {
        //incrementamos el contador el nº de veces asignado al hilo
        for(int i=0;i<numVeces;i++){
            contador.setContador();
        }
    }
}