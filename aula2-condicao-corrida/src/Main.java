public class Main {
    public static volatile Object lock = new Object();
    public static volatile int produtos = 0;

    public static void main(String[] args) {
        Buffer bufferCompartilhado = new Buffer();
        Produtor p1 = new Produtor(1, bufferCompartilhado, 30);
        Consumidor c1 = new Consumidor(1, bufferCompartilhado, 30);

        p1.start();
        c1.start();
    }
}

class Buffer {

    private int conteudo;
    private boolean disponivel;

    public synchronized void set(int idProdutor, int valor) {
        while (disponivel == true) {
            try {
                System.out.println("Produtor #" + idProdutor + " esperando...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conteudo = valor;
        System.out.println("Produtor #" + idProdutor + " colocou " + conteudo);
        disponivel = true;
        notifyAll();
    }

    public synchronized int get(int idConsumidor) {
        while (disponivel == false) {
            try {
                System.out.println("Consumidor #" + idConsumidor
                        + " esperando...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor #" + idConsumidor + " consumiu: "
                + conteudo);
        disponivel = false;
        notifyAll();
        return conteudo;
    }
}

class Produtor extends Thread {
    private int idProdutor;
    private Buffer pilha;
    private int producaoTotal;

    Produtor(int id, Buffer p, int producaoTotal) {
        idProdutor = id;
        pilha = p;
        this.producaoTotal = producaoTotal;
    }
    public void run() {
        for(int i = 0; i < 100; i ++ ) {
            pilha.set(idProdutor, i);
        }
        System.out.println("Produtor #" + idProdutor + " concluido!");
    }
}

class Consumidor extends Thread {
    private int idConsumidor = 0;
    private Buffer pilha;
    private int totalConsumir;

    public Consumidor(int id, Buffer p, int totalConsumir) {
        idConsumidor = id;
        pilha = p;
        this.totalConsumir = totalConsumir;
    }

    public void run() {
        for(int i = 0; i < totalConsumir; i++) {
           pilha.get(idConsumidor);
           System.out.println("Consumidor #" + idConsumidor + " concluido!");
        }
    }
}