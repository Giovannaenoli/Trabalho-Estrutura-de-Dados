package ListaSimples;

public class ListaSimples implements ListaOperacoes {

    // Vetor de String que irá armazenar os elementos da lista
    String[] lista;

    // Construtor da classe
    // Recebe o tamanho da lista como parâmetro
    public ListaSimples(int tamanho) {

        // Cria o vetor com o tamanho informado
        this.lista = new String[tamanho];

        // Exibe mensagem informando que a lista foi criada
        System.out.println("Lista criada com sucesso! Existem "
                + tamanho + " posições disponíveis.");
    }

    // PARTE PIETRA

    // Método para adicionar um elemento na lista
    public void adicionarElemento(String elemento) {

        // Verifica se a lista NÃO está cheia
        if (!this.estaCheia()) {

            // Encontra a primeira posição vazia (null)
            // e adiciona o elemento nela
            this.lista[encontrarPosicao()] = elemento;

            // Mensagem de confirmação
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int quantidadeAdicionada = 0; // Armazena quantos deram para adicionar

        // percorre cada palavra do vetor
        for (int i = 0; i < elementos.length; i++) {

            // Se a lista não esta cheia, ele adiciona a palavra
            if (!this.estaCheia()) {
                this.adicionarElemento(elementos[i]);
                quantidadeAdicionada++;

            } else {
                break;
            }
        }
        return quantidadeAdicionada;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice >= this.lista.length) {
            return false;
        }
        if (this.estaCheia()) {
            return false;
        }
        for (int i = this.lista.length - 1; i > indice; i--) {
            this.lista[i] = this.lista[i - 1];
        }
        this.lista[indice] = elemento;
        return true;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= this.lista.length) {
            return null;

        }
        return this.lista[indice];
    }

    // PARTE GIOVANNA

    //Método contar()
    @Override
    public int contar() {
        int contagem = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                contagem++;
            }
        }
        return contagem;
    }

    // PARTE DO JOÃO

    // Método que verifica se a lista está cheia
    public boolean estaCheia() {

        // Percorre todo o vetor
        for (int i = 0; i < this.lista.length; i++) {

            // Se encontrar uma posição vazia (null),
            // a lista NÃO está cheia
            if (this.lista[i] == null) {
                return false;
            }
        }

        // Se não encontrou nenhuma posição vazia,
        // a lista está cheia
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }

    // Método que verifica se a lista está vazia
    public boolean estaVazia() {

        // Percorre todo o vetor
        for (int i = 0; i < this.lista.length; i++) {

            // Se encontrar algum elemento diferente de null,
            // a lista NÃO está vazia
            if (this.lista[i] != null) {
                return false;
            }
        }

        // Se todas as posições forem null,
        // a lista está vazia
        return true;
    }

    // Método PRIVADO que encontra a primeira posição vazia
    // Esse método só pode ser usado dentro da classe
    private int encontrarPosicao() {

        int i;

        // Percorre o vetor
        for (i = 0; i < this.lista.length; i++) {

            // Quando encontrar uma posição vazia,
            // sai do laço
            if (this.lista[i] == null) {
                break;
            }
        }

        // Retorna o índice da posição vazia encontrada
        return i;
    }

    // Método que exibe todos os elementos da lista
    public void exibirElementos() {

        // Percorre todo o vetor
        for (int i = 0; i < this.lista.length; i++) {

            // Exibe o índice e o conteúdo da posição
            // (inclusive se for null)
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    // Método para remover um elemento da lista
    public void removerElemento(String elemento) {

        // Variável para indicar se o elemento foi removido
        boolean removido = false;

        // Só tenta remover se a lista NÃO estiver vazia
        if (!estaVazia()) {

            // Percorre todo o vetor
            for (int i = 0; i < this.lista.length; i++) {

                // Verifica se a posição não é null
                // e se o elemento é igual ao procurado
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {

                    // Remove o elemento (define como null)
                    this.lista[i] = null;

                    // Marca que o elemento foi removido
                    removido = true;
                }
            }
        }

        // Exibe mensagem de acordo com o resultado
        if (removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    // Método para buscar um elemento na lista
    public void buscarElemento(String elemento) {

        // Variável para indicar se o elemento foi encontrado
        boolean encontrado = false;

        // Só busca se a lista NÃO estiver vazia
        if (!estaVazia()) {

            // Percorre todo o vetor
            for (int i = 0; i < this.lista.length; i++) {

                // Verifica se o elemento existe naquela posição
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }

        // Exibe mensagem de acordo com o resultado da busca
        if (encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }
}