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

                System.out.println("\nContar: ");
                System.out.println(listaDinamica.contar());

                System.out.println("\nObter por indice: ");
                System.out.println(listaDinamica.obter(2));

                System.out.println("\nInserir: ");
                listaDinamica.inserir(1, "Cebola");
                listaDinamica.exibir();

                System.out.println("\nAdcionar varios: ");
                String[] novos = {"Tomate", "Sal", "Açucar"};
                listaDinamica.adicionarVarios(novos);
                listaDinamica.exibir();

                System.out.println("\nContar ocorrencias: ");
                System.out.println(listaDinamica.contarOcorrencias("Sal"));

                System.out.println("\nUltimo indice: ");
                System.out.println(listaDinamica.ultimoIndiceDe("Sal"));

                System.out.println("\nSubstituir: ");
                listaDinamica.substituir("Sal", "Chocolate");
                listaDinamica.exibir();

                System.out.println("\nRemover por indice: ");
                listaDinamica.removerPorIndice(2);
                listaDinamica.exibir();

                System.out.println("\nRemover todas: ");
                listaDinamica.removerTodas("Tomate");
                listaDinamica.exibir();

                System.out.println("\nRemover elemento: ");
                listaDinamica.removerElemento("Arroz");
                listaDinamica.exibir();

                System.out.println("\nLimpar lista: ");
                listaDinamica.limpar();
                listaDinamica.exibir();
    }
}
