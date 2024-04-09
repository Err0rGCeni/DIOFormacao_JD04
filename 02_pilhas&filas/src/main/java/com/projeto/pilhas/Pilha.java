package main.java.com.projeto.pilhas;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo) {
        // Guarda ref de topo
        No refAuxiliar = this.refNoEntradaPilha;
        // Atualiza ref
        this.refNoEntradaPilha = novoNo;
        // ref do no fica como a antiga de topo
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    public No pop() {
        if(!this.isEmpty()){
            // Guarda o nó que está sendo retirado
            No noPoped = this.refNoEntradaPilha;
            // Usa o próximo nó
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            // E está retirado da pilha
            return noPoped;
        } else {
            return null;
        }
    }

    public No top() {
        return this.refNoEntradaPilha;
    }

    public boolean isEmpty() {
        return this.refNoEntradaPilha == null ? true : false;
    }

    @Override
    public String toString() {
        String retorno = "=========\n";
        retorno += "Pilha\n";
        retorno += "---------\n";
        No noAuxiliar = this.refNoEntradaPilha;

        while (true) {
            if(noAuxiliar != null) {
                retorno += "[No{dado= " + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }
        }

        retorno += "=========\n";
        return retorno;
    }
    
}
