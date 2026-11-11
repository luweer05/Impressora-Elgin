import java.util.Scanner;

public class Usuario {
    String usuarioCorreto = "admin";
    String senhaCorreta = "1234";

    void fazerLogin() {
        Scanner scanner = Impressora.input;
        int tentativas = 3;
        boolean logado = false;

        while (tentativas > 0) {
            System.out.println("--- TELA DE LOGIN ---");
            System.out.print("Usuário: ");
            String usuarioDigitado = scanner.next();

            System.out.print("Senha: ");
            String senhaDigitada = scanner.next();

            if (usuarioDigitado.equals(usuarioCorreto) && senhaDigitada.equals(senhaCorreta)) {
                System.out.println("\nLogin realizado com sucesso! Bem-vindo(a)!");
                logado = true;
                
                Menu menu = new Menu();
                menu.menuImpressora();
                break; 
            } else {
                tentativas--;
                if (tentativas > 0) {
                    System.out.println("\nUsuário ou senha incorretos! Você ainda tem " + tentativas + " tentativa(s).\n");
                } else {
                    System.out.println("\nSuas tentativas acabaram! Acesso bloqueado por segurança.");
                }
            }
        }
    }
}