import java.util.Scanner;
import java.util.InputMismatchException;

public class Impressora {

    static boolean conexaoAberta = false;
    static boolean conexaoConfigurada = false;

    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;

    static Scanner input = new Scanner(System.in);

   
    static int lerInteiro(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            try {
                int numero = input.nextInt();
                input.nextLine();
                return numero;

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas numeros!");
                input.nextLine();
            }
        }
    }

   
    void configurarImpressora() {

        tipo = lerInteiro(
            "Tipo de conexao (1 = USB, 2 = RS232, 3 = TCP/IP): "
        );

        while (tipo < 1 || tipo > 3) {

            System.out.println("Tipo de conexao invalido!");
            tipo = lerInteiro("Digite novamente: ");
        }

        System.out.print("Modelo da impressora: ");
        modelo = input.nextLine();

        System.out.print("Conexao (USB, COM2 ou IP): ");
        conexao = input.nextLine();

        parametro = lerInteiro("Parametro da conexao: ");

        if (modelo.trim().isEmpty() || conexao.trim().isEmpty()) {
            System.out.println("Modelo e conexao nao podem ficar vazios.");
            conexaoConfigurada = false;
            return;
        }

        conexaoConfigurada = true;

        System.out.println("Dados armazenados com sucesso!");
    }

    void abrirConexao() {

        if (!conexaoConfigurada) {

            System.out.println("Configure a impressora antes de abrir a conexao.");
            return;
        }

        if (conexaoAberta) {

            System.out.println("Ja existe uma comunicacao em aberto.");
            return;
        }

        try {

            int ret = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(
                tipo, modelo, conexao, parametro
            );

            if (ret == 0) {

                conexaoAberta = true;
                System.out.println("Comunicacao bem-sucedida!");

            } else {

                System.out.println("Erro ao abrir comunicacao. Retorno: " + ret);
            }

        } catch (LinkageError e) {

            System.out.println("Erro ao carregar a DLL: " + e.getMessage());
        }
    }

   
    void fecharConexao() {

        if (!conexaoAberta) {

            System.out.println("Nao existe uma comunicacao em aberto.");
            return;
        }

        int ret = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();

        if (ret == 0) {

            conexaoAberta = false;
            System.out.println("Comunicacao fechada com sucesso!");

        } else {

            System.out.println("Erro ao fechar comunicacao. Retorno: " + ret);
        }
    }

  
    void cortarPapel() {

        int ret = ImpressoraDLL.INSTANCE.Corte(3);

        if (ret == 0) {
            System.out.println("Corte realizado com sucesso!");
        } else {
            System.out.println("Erro ao cortar papel. Retorno: " + ret);
        }
    }

 
    void impressaoTexto() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de imprimir.");
            return;
        }

        System.out.print("Digite o texto para imprimir: ");
        String dados = input.nextLine();

        if (dados.trim().isEmpty()) {

            System.out.println("O texto nao pode estar vazio!");
            return;
        }

        int copias = lerInteiro("Quantidade de copias: ");

        if (copias <= 0) {

            System.out.println("A quantidade precisa ser maior que zero.");
            return;
        }

        for (int i = 1; i <= copias; i++) {

            int ret = ImpressoraDLL.INSTANCE.ImpressaoTexto(
                dados + "\n", 0, 0, 0
            );

            if (ret >= 0) {

                System.out.println("Texto enviado! Copia " + i);
                cortarPapel();

            } else {

                System.out.println("Erro ao imprimir texto. Retorno: " + ret);
            }
        }
    }

    void impressaoQRCode() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de imprimir.");
            return;
        }

        System.out.print("Digite o conteudo do QR Code: ");
        String dados = input.nextLine();

        if (dados.trim().isEmpty()) {

            System.out.println("O conteudo nao pode estar vazio!");
            return;
        }

        int ret = ImpressoraDLL.INSTANCE.ImpressaoQRCode(
            dados, 6, 2
        );

        if (ret == 0) {

            System.out.println("QR Code impresso com sucesso!");
            cortarPapel();

        } else {

            System.out.println("Erro ao imprimir QR Code. Retorno: " + ret);
        }
    }

    
    void impressaoCodigoBarras() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de imprimir.");
            return;
        }

        String dados = "{A012345678912";

        int ret = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(
            8, dados, 100, 2, 2
        );

        if (ret == 0) {

            System.out.println("Codigo de barras impresso com sucesso!");
            cortarPapel();

        } else {

            System.out.println("Erro ao imprimir codigo de barras. Retorno: " + ret);
        }
    }

    void imprimirCupom() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de imprimir.");
            return;
        }

        String cupom =
            "       CUPOM DE TESTE       \n" +
            "----------------------------\n" +
            "Produto: Caneta             \n" +
            "Quantidade: 2               \n" +
            "Valor unitario: R$ 3,00     \n" +
            "----------------------------\n" +
            "TOTAL: R$ 6,00              \n" +
            "                            \n" +
            " Obrigado pela preferencia! \n" +
            "----------------------------\n\n";

        int ret = ImpressoraDLL.INSTANCE.ImpressaoTexto(
            cupom, 0, 0, 0
        );

        if (ret >= 0) {

            System.out.println("Cupom impresso com sucesso!");
            cortarPapel();

        } else {

            System.out.println("Erro ao imprimir cupom. Retorno: " + ret);
        }
    }

    
    void imprimeXMLSAT() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de imprimir.");
            return;
        }

        String xml = "path=XMLSAT.xml";

        int ret = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(xml, 0);

        if (ret == 0) {

            System.out.println("XML SAT impresso com sucesso!");
            cortarPapel();

        } else {

            System.out.println("Erro ao imprimir XML SAT. Retorno: " + ret);
        }
    }


    void imprimeXMLCancelamentoSAT() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de imprimir.");
            return;
        }

        String xmlCancelamento = "path=CANC_SAT.xml";

   
        String assQRCode =
            "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6Ksepk/q0E2e5x105cv3m1woYfgHy0kWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvX100SE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJd1TJ6p0ccqnZvuE70aH0I09elpjE06Cd+orI7XHHrFCwhFhAcbalc+zf05b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";

        int ret = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(
            xmlCancelamento, assQRCode, 0
        );

        if (ret == 0) {

            System.out.println("XML de cancelamento impresso com sucesso!");
            cortarPapel();

        } else {

            System.out.println("Erro ao imprimir cancelamento. Retorno: " + ret);
        }
    }

  
    void sinalSonoro() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de utilizar o sinal sonoro.");
            return;
        }

        int ret = ImpressoraDLL.INSTANCE.SinalSonoro(2, 5, 5);

        if (ret == 0) {

            System.out.println("Bip executado com sucesso!");

        } else {

            System.out.println("Erro no sinal sonoro. Retorno: " + ret);
        }
    }

   
    void abreGaveta() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de utilizar a gaveta.");
            return;
        }

        int ret = ImpressoraDLL.INSTANCE.AbreGaveta(0, 5, 5);

        if (ret == 0) {

            System.out.println("Gaveta aberta com sucesso!");

        } else {

            System.out.println("Erro ao abrir gaveta. Retorno: " + ret);
        }
    }


    void avancarPapel() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de avancar o papel.");
            return;
        }

        int linhas = lerInteiro("Quantas linhas deseja avancar? ");

        if (linhas <= 0) {

            System.out.println("Digite um numero maior que zero.");
            return;
        }

        int ret = ImpressoraDLL.INSTANCE.AvancaPapel(linhas);

        if (ret == 0) {

            System.out.println("Papel avancado com sucesso!");

        } else {

            System.out.println("Erro ao avancar papel. Retorno: " + ret);
        }
    }

   
    void statusPapel() {

        if (!conexaoAberta) {

            System.out.println("Abra a conexao antes de consultar o status.");
            return;
        }

        int ret = ImpressoraDLL.INSTANCE.StatusImpressora(3);

        if (ret == 5) {

            System.out.println("A impressora possui papel.");

        } else if (ret == 6) {

            System.out.println("O papel esta acabando.");

        } else if (ret == 7) {

            System.out.println("A impressora esta sem papel.");

        } else {

            System.out.println("Retorno do status: " + ret);
        }
    }
}