package main.java.com.projeto.filas;

public class Fila<T> {
    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public void enqueue(T object) {
        No<T> novoNo = new No<>(object);
        novoNo.setRefNo(this.refNoEntradaFila);
        this.refNoEntradaFila = novoNo;
    }

    public T first() {
        if (!this.isEmpty()) {
            No<T> primeiroNo = this.refNoEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    break;
                }
            }

            return (T) primeiroNo.getObject();
        } else {
            return null;
        }
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            No<T> primeiroNo = this.refNoEntradaFila;
            No<T> noAuxiliar = this.refNoEntradaFila;

            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }

            return (T) primeiroNo.getObject();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return this.refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
        String retorno = "==*== Fila ==*==\n";
        No<T> noAuxiliar = this.refNoEntradaFila;

        if (this.refNoEntradaFila != null) {
            while (true) {
                retorno += "[No{objeto= " + noAuxiliar.getObject() + " }]\n";
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    retorno += "null\n";
                    break;
                }
            }
        } else {
            retorno += "null\n";
        }
        retorno += "==*== XXXX ==*==\n";

        return retorno;
    }

}
