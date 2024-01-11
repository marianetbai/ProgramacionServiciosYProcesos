public class Main {
    static final int CUENTA_TOTAL=20;
    static final int NUMHILOS=10;

    public static void main (String[]args) {
        Contador contador = new Contador(0); //lo inicializamos a 0
        Thread[] hilos = new Thread[NUMHILOS];

        //cuántas veces incrementa cada hilo el contador
        int numVecesIncrementoPorHilo = CUENTA_TOTAL / NUMHILOS;

        //recorremos los hilos
        for(int i=0; i<NUMHILOS;i++){
            hilos[i]=new Thread(new Hilo(contador,numVecesIncrementoPorHilo));
            hilos[i].start();
        }

        //usamos el método join
        for(int i=0; i<NUMHILOS;i++){
            try{
                hilos[i].join();
            }catch (InterruptedException e){
            e.printStackTrace();
            }
        }
        System.out.println("Valor contador: "+contador.getContador());
    }
}
