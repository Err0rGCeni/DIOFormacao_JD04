package main.java.com.projeto.filas;

public class Main {
    public static void main(String[] args) {
        Fila<String> minhFila = new Fila<>();
        // minhFila.enqueue(new No("Primeiro"));
        // minhFila.enqueue("Primeiro");
        minhFila.enqueue("Primeiro");
        minhFila.enqueue("2nd");
        minhFila.enqueue("Terceiro");
        minhFila.enqueue("4º");

        System.out.println(minhFila);
        System.out.println(minhFila.dequeue());
        System.out.println(minhFila);

        minhFila.enqueue("Last");
        System.out.println(minhFila);
        System.out.println(minhFila.first());
    }
    
}
