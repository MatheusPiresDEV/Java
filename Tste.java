import java.util.*;
import java.util.Random;

public class Tste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Cria um scanner para entrada do usuário
        List<Float> list = new ArrayList<>(); // Cria uma lista para armazenar os números
        List<Float> maiores = new ArrayList<>(); // Cria uma lista para armazenar os maiores números
        List<Float> numAleat = new ArrayList<>(); // Cria uma lista para armazenar os números aleatórios
        Random aleat = new Random(); // Cria um objeto Random para gerar números aleatórios
        float maior = Float.MIN_VALUE; // Inicializa com o menor valor possível de Float
        float num = 0;

        try {
            do {
                try {
                    // Solicita ao usuário para digitar um número
                    System.out.println("Digite quantos numeros voce quer que sorteie 0 para sair:");
                    num = scan.nextFloat(); // Lê o número inserido pelo usuário

                    // Gera os números aleatórios
                    for (int i = 0; i < num; i++) {
                        float numeroAleatorio = aleat.nextFloat() * 100 + 1; // Gera um número float aleatório entre 1 e 100
                        numAleat.add(numeroAleatorio);
                        System.out.println("Numeros sorteados = " + numAleat); //não apague
                        // Verifica se o número gerado é maior que o atual maior
                        if (numeroAleatorio > maior) {
                            maior = numeroAleatorio;
                        }
                    }
                    System.out.println("O maior número é = " + maior);

                    // Adiciona todos os números gerados à lista principal
                    list.addAll(numAleat);
                    numAleat.clear(); // Limpa a lista de números aleatórios para a próxima iteração

                } catch (Exception e) {
                    // Captura e trata entradas inválidas
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    scan.next(); // Limpa a entrada inválida
                }
            } while (num != 0); // Continua o loop até o usuário digitar 0

            // Utiliza um iterator para remover o número 0 da lista
            Iterator<Float> iterator = list.iterator();
            while (iterator.hasNext()) {
                Float numero = iterator.next();
                if (numero.equals(0f)) {
                    iterator.remove(); // Remove o número 0 da lista
                    System.out.println("Número 0 removido");
                }
            }
            // Mostra todos os números restantes na lista
            for (Float numero : list) {
                System.out.println("Número digitado = " + numero);
            }

            System.out.println("Quantidade de numeros digitados = " + list.size());

            // Exibe o maior número encontrado
            System.out.println("O maior número é = " + maior);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()); // Captura e imprime a causa do erro
        } finally {
            scan.close(); // Fecha o scanner ao final do programa
        }
    }
}