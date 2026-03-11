package ListaDinamica;

public class ListaDinamica implements ListaOperacoes {

    // Nó inicial da lista (ponto de entrada para todos os elementos)
    No inicio;

    // Construtor da lista dinâmica
    public ListaDinamica() {

        // Cria um nó inicial com conteúdo null (indica que a lista começa vazia)
        this.inicio = new No(null);

        System.out.println("Lista dinâmica criada com sucesso!");
    }

    // PARTE PIETRA

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

    @Override
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

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0) {
            return false;
        }
        // primeira posição
        if (indice == 0) {
            if (this.inicioEstaVazio()) {
                this.inicio.setConteudo(elemento);
            } else {

                No noNovo = new No(this.inicio.getConteudo());
                noNovo.setProx(this.inicio.getProx());
                this.inicio.setConteudo(elemento);
                this.inicio.setProx(noNovo);
            }
            return true;
        }

        No aux = this.inicio;
        int posicao = 0;

        // Simula um indice - 1
        while (aux != null && posicao < indice - 1) {
            aux = aux.getProx();
            posicao++;
        }

        if (aux == null) {
            return false;
        }
        No noNovo= new No(elemento);

        noNovo.setProx(aux.getProx()); // O novo nó mantem a continuação da fila
        aux.setProx(noNovo);           // O nó passado aponta para o nó novo

        return true;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || inicioEstaVazio()) {
            return null;
        }
        No aux = this.inicio;
        int posicao = 0;

        while (aux != null && posicao < indice) {
            aux = aux.getProx();
            posicao++;
        }
        if (aux == null) {
            return null;
        }
        return aux.getConteudo();
    }

    // PARTE GIOVANNA

    //Método contar()
    @Override
    public int contar() {
        if (inicioEstaVazio()) return 0;

        int contador = 0;
        No aux = this.inicio;
        // Passa de nó em nó até o fim
        while (aux != null) {
            contador++;
            aux = aux.getProx();
        }
        return contador;
    }

    //Método limpar()
    @Override
    public void limpar() {
        //Basta zerar o conteúdo do início e tirar o ponteiro do próximo
        this.inicio.setConteudo(null);
        this.inicio.setProx(null);
    }

    //Método removerPorIndice()
    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || inicioEstaVazio()) return null;

        // Se for o primeiro nó, pega o valor e muda o início para o próximo
        if (indice == 0) {
            String valor = this.inicio.getConteudo();
            if (this.inicio.getProx() == null) {
                this.inicio.setConteudo(null);
            } else {
                this.inicio = this.inicio.getProx();
            }
            return valor;
        }

        // Se for no meio ou fim, precisa encontrar quem vem ANTES do que eu quero tirar
        No aux = this.inicio;
        for (int i = 0; i < indice - 1 && aux != null; i++) {
            aux = aux.getProx();
        }

        if (aux == null || aux.getProx() == null) return null;

        String removido = aux.getProx().getConteudo();
        // Faço o nó anterior apontar para o próximo do que eu estou deletando
        aux.setProx(aux.getProx().getProx());

        return removido;
    }

    //Método removerTodas()
    @Override
    public int removerTodas(String elemento) {
        int total = 0;
        if (inicioEstaVazio()) return 0;

        // Primeiro verifica se o início tem o elemento repetido
        while (!inicioEstaVazio() && this.inicio.getConteudo().equals(elemento)) {
            removerPorIndice(0);
            total++;
        }

        // Percorre o resto da corrente
        No aux = this.inicio;
        while (aux != null && aux.getProx() != null) {
            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                total++;
            } else {
                aux = aux.getProx();
            }
        }
        return total;
    } 

    // PARTE JOÃO
    @Override
    public int ultimoIndiceDe(String elemento) {
    if (inicioEstaVazio()) {
        return -1;
    }

    No aux = this.inicio;
    int indice = 0;
    int ultimoIndice = -1;

    // percorre a lista 
    while (aux != null) {
        if (aux.getConteudo().equals(elemento)) {
            ultimoIndice = indice;
        }

        aux = aux.getProx();
        indice++;
    }

    return ultimoIndice;
}

@Override
public int contarOcorrencias(String elemento) {
    if (inicioEstaVazio()) {
        return 0;
    }

    No aux = this.inicio;
    int contador = 0;

    while (aux != null) {
        if (aux.getConteudo().equals(elemento)) {
            contador++;
        }

        aux = aux.getProx();
    }

    return contador;
}
    
    public void exibir() {
        if(inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;
            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    private boolean inicioEstaVazio() {
        return this.inicio.getConteudo() == null;
    }

    public void removerElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
        } else {
            if(procurarElemento(elemento)) {
                if(this.inicio.getProx() == null) {
                    System.out.println("Elemento " + elemento + " removido!");
                    this.inicio.setConteudo(null);
                }
                else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    while(aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            this.inicio = this.inicio.getProx();
                            return;
                        }
                        else if(aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public boolean procurarElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
        } else {
            No aux = this.inicio;
            while(aux != null) {
                if(aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado!");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento " + elemento + " não existe na lista.");
        }
        return false;
    }
}