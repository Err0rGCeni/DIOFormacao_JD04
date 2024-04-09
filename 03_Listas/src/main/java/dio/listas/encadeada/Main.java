package main.java.dio.listas.encadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> minhListaEncadeada = new ListaEncadeada<>();

        minhListaEncadeada.add("teste1");
        minhListaEncadeada.add("teste2");
        minhListaEncadeada.add("teste3");
        minhListaEncadeada.add("teste4");
        
        System.out.println("Testando Get");
        System.out.println(minhListaEncadeada.get(0));
        System.out.println(minhListaEncadeada.get(1));
        System.out.println(minhListaEncadeada.get(2));
        System.out.println(minhListaEncadeada.get(3));

        System.out.println("Testando toString()");
        System.out.println(minhListaEncadeada);

        System.out.println(minhListaEncadeada.remove(2));
        System.out.println(minhListaEncadeada);
    }
    
}
