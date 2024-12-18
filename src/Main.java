import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("### BJuizem vindo ao Game 'Desvende o Número' ###");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        Jogador jogador = new Jogador(nome);
        Jogo jogo = new Jogo();

        boolean continurJogando = true;

        while (continurJogando) {
            //Escolher o nivel de dificuldade.
            int limiteSuperior = jogo.escolhaONivel(scanner);

            // Jogar uma rodada
            jogo.JogarRodada(limiteSuperior, scanner);

            // Perguntar ao jogador se ele deseja continuar
            System.out.println("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("s")) {
                continurJogando = false;
            }
        }
        //Encerrar jogo
        jogo.encerrarJogo();
    }
}