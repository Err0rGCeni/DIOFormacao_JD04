package dio;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Map<String, String> aluno = new HashMap<>();

        aluno.put("Nome", "João");
        aluno.put("Idade", "15");
        aluno.put("Media", "8");
        aluno.put("Turma", "A");

        System.out.println(aluno);
        System.out.println(aluno.keySet());
        System.out.println(aluno.values());
        
        List<Map<String, String>> listaAlunos = new ArrayList<>();
        listaAlunos.add(aluno);

        Map<String, String> aluno2 = new HashMap<>();
        aluno2.put("Nome", "Maria");
        aluno2.put("Idade", "15");
        aluno2.put("Media", "9");
        aluno2.put("Turma", "B");

        listaAlunos.add(aluno2);

        System.out.println(listaAlunos);
    }
}
