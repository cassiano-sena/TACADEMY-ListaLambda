package Exemplo1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("peixe,porta,texto");

        //versao default sem expressão lambda
//        Collections.sort(palavras, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                // return Integer.compare(o1.length(), o2.length()); // v1
//                // return o1.compareTo(o2); //v2
//            }
//        });

        //expressão lambda
        //+legibilidade
        //+nao precisa criar outra lista, faz dentro de palavras
        palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));
        palavras.forEach(System.out::println);

        // é uma função anonima
        // executa um metodo e desaparece
        // normal usar funçoes lambda prontas
        // uma função sem nome,
        // sort, forEach, stream
        // ex:
        palavras.forEach(palavra-> System.out.println(palavra));
        // e como se fosse:
//        public void (String palavra){
//            System.out.println(palavra);
//        }

        ExemploLambda adicionador = (numero) -> numero + 90;
        System.out.println(adicionador.add(20));
    }
}