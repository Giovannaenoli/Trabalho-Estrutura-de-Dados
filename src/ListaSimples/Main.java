package ListaSimples;

public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Sabão em Pó");
        listaSimples.adicionarElemento("Papel Higiênico");
        listaSimples.adicionarElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.removerElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.exibirElementos();

        System.out.println("\nContar: ");
        System.out.println(listaSimples.contar());

        System.out.println("\nObter por indice: ");
        System.out.println(listaSimples.obter(2));

        System.out.println("\nInserir: ");
        listaSimples.inserir(1, "Macarrão");
        listaSimples.exibirElementos();

        System.out.println("\nAdicionar varios: ");
        String[] novos = {"Sal", "Açúcar", "Café"};
        listaSimples.adicionarVarios(novos);
        listaSimples.exibirElementos();

        System.out.println("\nContar ocorrencias: ");
        System.out.println(listaSimples.contarOcorrencias("Arroz"));

        System.out.println("\nUltimo indice: ");
        System.out.println(listaSimples.ultimoIndiceDe("Arroz"));

        System.out.println("\nSubstituir: ");
        listaSimples.substituir("Arroz", "Chocolate");
        listaSimples.exibirElementos();

        System.out.println("\nRemover por indice: ");
        listaSimples.removerPorIndice(2);
        listaSimples.exibirElementos();

        System.out.println("\nRemover todas: ");
        listaSimples.removerTodas("Sal");
        listaSimples.exibirElementos();

        System.out.println("\nRemover elemento: ");
        listaSimples.removerElemento("Feijão");
        listaSimples.exibirElementos();

        System.out.println("\nLimpar lista: ");
        listaSimples.limpar();
        listaSimples.exibirElementos();
    }
}

