import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

    private int potnuacao;
    private ArrayList<Integer> numerosAcertados;
    private ArrayList<Integer> numerosErrados;
    private Random random;   // Objeto para gerar números aleatórios.

    public Jogo() {                 // Incia as variaveis
        this.potnuacao = 0;
        this.numerosAcertados = new ArrayList<>();
        this.numerosErrados = new ArrayList<>();
        this.random = new Random();
    }

    // Método para escolher o nivel de dificuldade.
    public int escolhaONivel(Scanner scanner) {
        System.out.println("Escola o nivel de dificuldade: ");
        System.out.println("1. Fácil (1 a 10)");
        System.out.println("2. Médio (1 a 50)");
        System.out.println("3. Dificl (1 a 100)");
        System.out.println("Digite o número da sua escolha: ");

        int nivel = scanner.nextInt();
        switch (nivel) {
            case 1:
                return 10;  // Facil
            case 2:
                return 50;  // Médio
            case 3:
                return 100;  // Dificil
            default:
                System.out.println("Nivel invalido ! Voce foi direcionado para o nivel Facil .");
                return 10;
        }
    }

    //    Método para jogar uma rodada
    public void JogarRodada(int limiteSuperior, Scanner scanner) {
        int numeroSortedo = random.nextInt(limiteSuperior) + 1;  // Gera um numero aleatorio dentro od intervalo definido.

        // Solicitando um palpite do jogador
        System.out.println("Digite seu palpite (entre 1 e " + limiteSuperior + "): ");
        int palpite = scanner.nextInt();

        // Avaliando o palpite e atualizando a pontuação
        if (palpite == numeroSortedo) {
            System.out.println("Parabéns! Voçê acertou o numero e ganhou 10 pontos!");
            potnuacao += 10;
            numerosAcertados.add(numeroSortedo);
        } else if (Math.abs(palpite - numeroSortedo) == 1) {
            System.out.println("Quase lá! Voçê estava a 1(um) numero de distancia do numero sorteado e ganhou 5 pontos");
            potnuacao += 5;
            numerosErrados.add(palpite);
        } else {
            System.out.println("Que pena! Você errou. O numero sorteado era " + numeroSortedo + ": ");
            numerosErrados.add(palpite);
        }

    }

    //Metodo para encerra o jogo
    public void encerrarJogo() {
        System.out.println("Jogo Encerrado! ");
        System.out.println("Pontuação Final: " + potnuacao + " pontos. ");
        System.out.println("Números acertados: " + numerosAcertados);
        System.out.println("Números errados: " + numerosErrados);
    }

}
