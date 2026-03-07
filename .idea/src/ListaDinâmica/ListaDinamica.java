package ListaDinâmica;

public class ListaDinamica {

    // Nó inicial da lista (ponto de entrada para todos os elementos)
    No inicio;

    // Construtor da lista dinâmica
    public ListaDinamica() {

        // Cria um nó inicial com conteúdo null (indica que a lista começa vazia)
        this.inicio = new No(null);

        System.out.println("Lista dinâmica criada com sucesso!");
    }

    // Método adicionar um novo elemento à lista
    public void adicionarElemento(String elemento) {

        // Verifica se a lista está vazia
        if(inicioEstaVazio()) {

            // Se estiver vazia, o valor é colocado diretamente
            // no nó inicial (não cria novo nó)
            this.inicio.setConteudo(elemento);

        } else {

            // Nó auxiliar usado para percorrer a lista
            No aux = this.inicio;

            // Cria um novo nó já com o conteúdo recebido
            No novoNo = new No(elemento);

            // Percorre a lista até encontrar o último nó
            // O último nó é aquele que o prox é null
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }

            // Liga o último nó ao novo nó criado
            aux.setProx(novoNo);
        }
    }
    //    @Override - joão adicionar o override pliss
    public int adicionarVarios(String[] elementos) {
        int quantidadeAdicionada = 0;

        // Lista dinâmica não tem limite de capacidade
        for (int i = 0; i < elementos.length; i++) {
            this.adicionarElemento(elementos[i]);

            quantidadeAdicionada++;
        }

        // "@return Quantidade de elementos que foram realmente adicionados"
        return quantidadeAdicionada;
    }

    // Método responsável por exibir os elementos da lista
    public void exibir() {

        // Caso a lista esteja vazia
        if(inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");

        } else {

            // Nó auxiliar para percorrer a lista
            No aux = this.inicio;

            // Percorre a lista enquanto o nó existir
            while(aux != null) {

                // Exibe o conteúdo do nó atual
                // (se for null, aparecerá "null" no console)
                System.out.println(aux.getConteudo());

                // Avança para o próximo nó
                aux = aux.getProx();
            }
        }
    }

    // Método que verifica se a lista está vazia
    private boolean inicioEstaVazio() {

        // Se o conteúdo do nó inicial for null,
        // significa que nenhum elemento foi inserido
        if(this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    // Método responsável por remover um elemento da lista
    public void removerElemento(String elemento) {

        // Se a lista estiver vazia, não tem o que remover
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");

        } else {

            // Primeiro verifica se o elemento existe na lista
            if(procurarElemento(elemento)) {

                // CASO 1: existe apenas um elemento na lista
                // (o nó inicial não aponta para ninguém)
                if(this.inicio.getProx() == null) {

                    System.out.println("Elemento " + elemento + " removido!");

                    // Remove o único elemento da lista
                    this.inicio.setConteudo(null);
                }

                // CASO 2: existem vários nós conectados
                else if(this.inicio.getProx() != null) {

                    // Nó auxiliar para percorrer a lista
                    No aux = this.inicio;

                    // Percorre a lista
                    while(aux != null) {

                        // Se o elemento a ser removido está no primeiro nó
                        if (this.inicio.getConteudo().equals(elemento)) {

                            System.out.println("Elemento " + elemento + " removido!");

                            // O início da lista passa a ser o próximo nó
                            this.inicio = this.inicio.getProx();
                            return;

                        }

                        // Se o próximo nó contém o elemento procurado
                        else if(aux.getProx().getConteudo().equals(elemento)) {

                            System.out.println("Elemento " + elemento + " removido!");

                            // "Pula" o nó que será removido
                            // Ligando o nó atual ao próximo do próximo
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }

                        // Avança para o próximo nó
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    // Método responsável por procurar um elemento na lista
    public boolean procurarElemento(String elemento) {

        // Se a lista estiver vazia
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");

        } else {

            // Nó auxiliar para percorrer a lista
            No aux = this.inicio;

            // Percorre todos os nós da lista
            while(aux != null) {

                // Se o conteúdo do nó atual for igual ao elemento procurado
                if(aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado!");
                    return true;
                }

                // Avança para o próximo nó
                aux = aux.getProx();
            }

            // Se percorreu tudo e não encontrou
            System.out.println("Elemento " + elemento + " não existe na lista.");
        }

        // Retorna false se não encontrou
        return false;
    }
}