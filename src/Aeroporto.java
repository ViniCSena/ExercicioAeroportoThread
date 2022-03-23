import java.util.concurrent.Semaphore;

public class Aeroporto {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Semaphore semaphore1 = new Semaphore(1);
        Thread aviao;
        for(int i=1; i<=12; i++){
            aviao = new AviaoThread(semaphore, semaphore1, i);
            aviao.start();
        }
    }



}
