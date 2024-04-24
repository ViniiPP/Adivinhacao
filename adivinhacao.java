import java.util.Scanner;
import java.util.Random;

public class adivinhacao {
    public static void main(String[] args) {
        Scanner lerTeclado = new Scanner(System.in);
        Random gerador = new Random();

        int valorMinimo = 1;
        int valorMaximo = 100;
        int tentativas = 0;
        int adivinhar = gerador.nextInt(valorMaximo) + 1; 

        while (true) {
            System.out.println("Digite um número entre 1 e 100: ");
            int palpite = lerTeclado.nextInt();

            if (palpite < 1 || palpite > 100) {
                System.out.println("Número escolhido fora do intervalo de 1 e 100!");
                continue; 
            }

            if (palpite < adivinhar) {
                System.out.println("O número é maior");
                valorMinimo = palpite + 1;
                System.out.println("O número está entre " + valorMinimo + " e " + valorMaximo);
                tentativas++;
            } else if (palpite > adivinhar) {
                System.out.println("O número é menor");
                valorMaximo = palpite - 1;
                System.out.println("O número está entre " + valorMinimo + " e " + valorMaximo);
                tentativas++;
            } else {
                System.out.println("Parabéns! Você encontrou o número!");
                System.out.println("Tentativas: " + tentativas + ".");
                lerTeclado.close();
                break;
            }

            if (tentativas > 10) {
                System.out.println("Número de tentativas excedidas, e você não encontrou o número!");
                lerTeclado.close();
                break;
            }
        }
    }
}