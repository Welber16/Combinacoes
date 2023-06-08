import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinacoesFechamento {

    public static void main(String[] args) {

        // Número mínimo de dezenas escolhidas
        int minDezenas = 10;

        // Número de dezenas da Dupla Sena
        int totalDezenas = 50;

        // Número de dezenas sorteadas na Dupla Sena
        int dezenasSorteadas = 6;

        // Lista para armazenar as dezenas escolhidas
        List<Integer> dezenasEscolhidas = new ArrayList<>();

        // Leitura das dezenas escolhidas
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite " + minDezenas + " números entre 1 e " + totalDezenas + ":");
        while (dezenasEscolhidas.size() < minDezenas) {
            int dezena = sc.nextInt();
            if (dezena >= 1 && dezena <= totalDezenas && !dezenasEscolhidas.contains(dezena)) {
                dezenasEscolhidas.add(dezena);
            } else {
                System.out.println("Dezena inválida ou já escolhida. Digite outro número.");
            }
        }

        // Geração das combinações de dezenas
        List<List<Integer>> combinacoes = gerarCombinacoes(dezenasEscolhidas, dezenasSorteadas);

        // Impressão das combinações geradas
        System.out.println("Combinações geradas:");
        for (List<Integer> combinacao : combinacoes) {
            System.out.println(combinacao);
        }

        // Cálculo do número de apostas necessárias
        int numApostas = combinacoes.size();
        System.out.println("Número de apostas necessárias: " + numApostas);

        // Fechamento realizado com sucesso
        System.out.println("Fechamento realizado com sucesso!");
    }

    /**
     * Gera todas as combinações possíveis de um conjunto de números, com um tamanho específico.
     * @param numeros Conjunto de números.
     * @param tamanho Tamanho das combinações geradas.
     * @return Lista de todas as combinações geradas.
     */
    public static List<List<Integer>> gerarCombinacoes(List<Integer> numeros, int tamanho) {
        List<List<Integer>> combinacoes = new ArrayList<>();
        gerarCombinacoesAux(numeros, tamanho, new ArrayList<>(), combinacoes);
        return combinacoes;
    }

    /**
     * Função auxiliar para gerar as combinações.
     * @param numeros Conjunto de números.
     * @param tamanho Tamanho das combinações geradas.
     * @param combinacao Combinação atual.
     * @param combinacoes Lista de todas as combinações geradas.
     */
    public static void gerarCombinacoesAux(List<Integer> numeros, int tamanho, List<Integer> combinacao, List<List<Integer>> combinacoes) {
        if (combinacao.size() == tamanho) {
            combinacoes.add(new ArrayList<>(combinacao));
            return;
        }
        for (int i = 0; i < numeros.size(); i++) {
            int numero = numeros.get(i);
            if (!combinacao.contains(numero)) {
                combinacao.add(numero);
                gerarCombinacoesAux(numeros, tamanho, combinacao, combinacoes);
                combinacao.remove(combinacao.size() - 1);
            }
        }
    }
}
