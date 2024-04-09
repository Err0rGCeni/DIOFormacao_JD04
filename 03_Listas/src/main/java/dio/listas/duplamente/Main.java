package main.java.dio.listas.duplamente;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> minhaDLL = new ListaDuplamenteEncadeada<>();
        minhaDLL.add("C1");
        minhaDLL.add("C2");
        minhaDLL.add("C3");
        minhaDLL.add("C4");
        minhaDLL.add("C5");
        minhaDLL.add("C6");
        minhaDLL.add("C7");
        System.out.println(minhaDLL);

        minhaDLL.remove(3);
        System.out.println(minhaDLL);
        minhaDLL.add(3, "99");
        System.out.println(minhaDLL);
        System.out.println(minhaDLL.get(3));
    }
    
}
