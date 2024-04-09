package main.java.dio.listas.encadeada;

public class ListaEncadeada<T> {
    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public void add(T conteudo) {
        // Cria um novo nó com o conteudo passado.
        No<T> novoNo = new No<>(conteudo);
        // Se lista vazia, só apontar para o novo nó.
        if (this.isEmpty()){
            this.referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = this.referenciaEntrada;
        for (int i = 0; i < this.size()-1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        // Se index maior do que o tamanho da lista, retornar Exception
        this.validaIndice(index);
        No<T> noAuxiliar = this.referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();            
        }

        return noRetorno;
    }

    public T remove(int index) {
        No<T> noPivor = this.getNo(index);
        if (index == 0) {
            // Ref entrada é o segundo Nó (que agora vira primeiro)
            this.referenciaEntrada = noPivor.getProximoNo();
            // Retorna o conteúdo do Nó
            return noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1);
        // Pega o Nó anterior (N-1), e 
        // Define que o próximo nó (N+1) é o seu sucessor
        noAnterior.setProximoNo(noPivor.getProximoNo());
        // Retorna o conteúdo do Nó
        return noPivor.getConteudo();

    }

    public int size() {
        int tamanhoLista = 0;
        No<T> referenciaAux = this.referenciaEntrada;
        while (true) {
            if (referenciaAux != null) {
                // Lista não está vazia, então incrementar
                tamanhoLista++;
                if (referenciaAux.getProximoNo() != null) {
                    // Próxima ref não é null, então ir ao próximo item
                    referenciaAux = referenciaAux.getProximoNo();
                } else {
                    // Próxima ref é null, então terminar de contar
                    break;
                }
            } else {
                // Lista está vazia, então retornar 0
                break;
            }
        }

        return tamanhoLista;
    }

    private void validaIndice(int index) {
        if (index >= this.size()) {
            int ultimoIndice = this.size() - 1;
            throw new IndexOutOfBoundsException(index + " maior do que " + ultimoIndice);
        }
    }

    public boolean isEmpty() {
        return this.referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.referenciaEntrada;
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "No{conteudo=" + noAuxiliar.getConteudo() + "} --> ";
            noAuxiliar = noAuxiliar.getProximoNo();            
        }
        strRetorno += "null";        
        return strRetorno; 
    }

}
