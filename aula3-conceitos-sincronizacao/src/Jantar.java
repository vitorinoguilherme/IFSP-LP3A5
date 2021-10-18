public class Jantar {

    // Classe responsável por criar as threads representadas pelos filósofos
    // as threads criadas entram no estado de execução através do método start()
    public static void main(String[] args) {
        Mesa mesa = new Mesa ();
        for (int filosofo = 0; filosofo < 5; filosofo++) {
            new Filosofo("Filoso_" + filosofo, mesa, filosofo).start();
        }
    }
}
