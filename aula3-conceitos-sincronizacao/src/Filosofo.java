public class Filosofo extends Thread {
    // Classe filosofo é herdada de Thread e sobrescreve o método run com o que precisa executar.
    // o método run() é executado por cada thread paralelamente

    final static int TEMPO_MAXIMO = 100;
    Mesa mesa;
    int idFilosofo;

    public Filosofo( String nome, Mesa mesa, int idFilosofo ) {
        super( nome );
        this.mesa = mesa;
        this.idFilosofo = idFilosofo;
    }

    @Override
    public void run() {
        int tempo = 0;
        while( true ) {
            tempo = (int) ( Math.random() * TEMPO_MAXIMO );
            pensar(tempo);
            mesa.pegarGarfos(this.idFilosofo);
            tempo = (int) ( Math.random() * TEMPO_MAXIMO );
            comer(tempo);
            mesa.returningGarfos(this.idFilosofo);
        }
    }

    public void pensar ( int tempo ) {
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("O Filósofo pensou em demasia");
        }
    }

    public void comer ( int tempo ) {
        try {
          sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("O Filósofo comeu em demasia");
        }
    }
}
