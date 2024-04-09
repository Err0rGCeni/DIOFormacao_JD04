package main.java.dio.listas.duplamente;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        // Novo nó adicionado ao final da llista
        novoNo.setNoProximo(null);
        // Aponta o atual último nó como seu antecessor
        novoNo.setNoPrevio(this.ultimoNo);
        // Se não há primeiro nó, o novo nó o será
        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
        }
        // Se há último nó, fazê-lo apontar para o novo nó (deixando de ser o último)
        if (this.ultimoNo != null) {
            this.ultimoNo.setNoProximo(novoNo);
        }
        this.ultimoNo = novoNo;
        this.tamanhoLista++;
    }

    public void add(int index, T elemento) {
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);
        // Se não é o último nó
        if (novoNo.getNoProximo() != null) {
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);;
        } else {
            novoNo.setNoPrevio(ultimoNo);
            this.ultimoNo = novoNo;
        }

        if (index == 0) {
            this.primeiroNo = novoNo;
        } else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }

        this.tamanhoLista++;
    }

    public void remove(int index) {
        if (index == 0) {
            this.primeiroNo = primeiroNo.getNoProximo();
            // Se próximo nó não é nulo (lista tem mais de um elemento)
            if (this.primeiroNo != null) {
                // Prévio como nulo = começo da lista.
                this.primeiroNo.setNoPrevio(null);
            }
        } else {
            // N(x-1) <-> N(x) <-> N(x+1)
            NoDuplo<T> noAuxiliar = getNo(index);
            // N(x-1) --> N(x+1)
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            // Se o nó auxiliar não é o último (getNoProximo == null)
            if(noAuxiliar != this.ultimoNo) {
                // N(x-1) <-- N(x+1)
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            } else {
                this.ultimoNo = noAuxiliar;
            }
        }
        this.tamanhoLista--;
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = this.primeiroNo;
        // noAuxiliar != null testa se o index está dentro do tamanho da lista.
        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public int size() {
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = this.primeiroNo;
        
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No{conteudo = "+ noAuxiliar.getConteudo() + "}]->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        
        strRetorno += "null";
        return strRetorno;
    }
}
