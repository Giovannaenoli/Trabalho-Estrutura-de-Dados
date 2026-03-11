package ListaDinamica;

public class No {

    // Guarda o valor armazenado no nó
    private String conteudo;

    // Referência para o próximo nó da lista
    private No prox;

    // Construtor: cria um nó com um conteúdo
    public No(String conteudo) {
        this.conteudo = conteudo;

        // Quando o nó é criado, ele não aponta para nenhum outro
        prox = null;
    }

    // Retorna o conteúdo do nó
    public String getConteudo() {
        return conteudo;
    }

    // Define ou altera o conteúdo do nó
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    // Retorna o próximo nó da lista
    public No getProx() {
        return prox;
    }

    // Define qual será o próximo nó
    public void setProx(No prox) {
        this.prox = prox;
    }
}