public class Menu {
   Impressora impressora = new Impressora();

  void menuImpressora(){
        System.out.println("1 - Configurar conexão");
        System.out.println("2 - Abrir conexão");
        System.out.println("3 - Fechar conexão");
        System.out.println("4 - Imprimir texto");
        System.out.println("5 - Imprimir QR Code");
        System.out.println("6 - Imprimir código de barras");
        System.out.println("7 - Imprimir XML SAT");
        System.out.println("8 - Imprimir XML de cancelamento SAT");
        System.out.println("9 - Abrir gaveta");
        System.out.println("10 - Sinal sonoro (bip)");
        System.out.println("11 - Sair");

        int opcao = 0;

       (opcao != 11) {
            menuImpresso();
            System.out.println("Digite a opcao desejada: ");
            
            opcao = Impressora.input.nextInt();

           switch (opcao) {
                case 1:
                    impressora.configurarImpressora();
                        break;
                case 2:
                    impressora.abrirConexao();
                        break;
                case 3:
                    impressora.fecharConexao();
                        break;
                case 4:
                    impressora.impressaoTexto();
                        break;
               
        }
    }
}

