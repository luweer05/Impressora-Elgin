public class Menu {
   Impressora impressora = new Impressora();

  void menuImpressora(){
     System.out.println("---Menu---");
     System.out.println("1 - Configurar conexão");
     System.out.println("2 - Abrir conexão");
     System.out.println("3 - Impressao codigo de barras");

        int opcao = 0;

        while (opcao != 4) {
            opcao = Impressora.input.nextInt();

            switch (opcao) {
                case 1:
                    impressora.configurarImpressora();
                    break;

                case 2:
                    impressora.abrirConexao();
                    break;

                case 3:
                    impressora.impressaoCodigoBarras();
                    break;

                case 4:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

