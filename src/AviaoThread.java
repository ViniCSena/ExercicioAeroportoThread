import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class AviaoThread extends Thread {

    private Semaphore norte;
    private Semaphore sul;
    private int id;
    private Random random;

    public AviaoThread(Semaphore semaphore, Semaphore semaphore1, int id) {
        this.norte = semaphore;
        this.sul = semaphore1;
        this.id = id;
        random = new Random();
    }

    @Override
    public void run() {
        if (random.nextBoolean()) {
            System.out.println("Avião " + id + " indo pela pista Norte");
            aviaoSair(norte);
        } else {
            System.out.println("Avião " + id + " indo pela pista Sul");
            aviaoSair(sul);
        }
    }

    private void aviaoSair(Semaphore pista) {
        try {
            pista.acquire();
            System.out.println("O avião #" + id + " esta manobrando.");
            Thread.sleep(random.nextInt(4001) + 3000);
            taxiar();
            decolar();
            afastamento();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pista.release();
            System.out.println("Pista norte liberada\n");
        }
    }

    private void taxiar() throws InterruptedException {
        System.out.println("O avião #" + id + " esta taxiando.");
        Thread.sleep(random.nextInt(5001) + 5000);
    }

    private void decolar() throws InterruptedException {
        System.out.println("O avião #" + id + " esta decolando.");
        Thread.sleep(random.nextInt(3001) + 1000);
    }

    private void afastamento() throws InterruptedException {
        System.out.println("O avião #" + id + " esta se afastando.");
        Thread.sleep(random.nextInt(5001) + 3000);
        System.out.println("O avião #"+id+" se afastou");
    }

}
