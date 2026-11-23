public class Menu {

    Impressora impressora = new Impressora();

    void menuImpressora() {

        int opcao;

        do {

            System.out.println("\n===== MENU IMPRESSORA ELGIN =====");
            System.out.println("1 - Configurar conexao");
            System.out.println("2 - Abrir conexao");
            System.out.println("3 - Fechar conexao");
            System.out.println("4 - Imprimir texto");
            System.out.println("5 - Imprimir QR Code");
            System.out.println("6 - Imprimir codigo de barras");
            System.out.println("7 - Imprimir cupom");
            System.out.println("8 - Imprimir XML SAT");
            System.out.println("9 - Imprimir XML de cancelamento SAT");
            System.out.println("10 - Abrir gaveta");
            System.out.println("11 - Sinal sonoro");
            System.out.println("12 - Avancar papel");
            System.out.println("13 - Consultar status do papel");
            System.out.println("0 - Sair");
            System.out.println("=================================");

            opcao = Impressora.lerInteiro("Digite a opcao desejada: ");

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

                case 5:
                    impressora.impressaoQRCode();
                    break;

                case 6:
                    impressora.impressaoCodigoBarras();
                    break;

                case 7:
                    impressora.imprimirCupom();
                    break;

                case 8:
                    impressora.imprimeXMLSAT();
                    break;

                case 9:
                    impressora.imprimeXMLCancelamentoSAT();
                    break;

                case 10:
                    impressora.abreGaveta();
                    break;

                case 11:
                    impressora.sinalSonoro();
                    break;

                case 12:
                    impressora.avancarPapel();
                    break;

                case 13:
                    impressora.statusPapel();
                    break;

                case 0:
                    impressora.fecharConexao();
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (opcao != 0);
    }
}