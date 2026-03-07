package ListaDinamica;

public class Main {
    public static void main(String[] args) {
            ListaDinamica listaDinamica = new ListaDinamica();
            listaDinamica.adicionarElemento("Arroz");
            listaDinamica.adicionarElemento("Feijão");
            listaDinamica.adicionarElemento("Batata");
            listaDinamica.adicionarElemento("Alho");
            listaDinamica.adicionarElemento("Cebola");
            listaDinamica.removerElemento("Arroz");
            listaDinamica.exibir();
    }
}
