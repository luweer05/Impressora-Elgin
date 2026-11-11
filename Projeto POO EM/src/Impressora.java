import java.util.Scanner;
public class Impressora {

 static boolean conexaoAberta = false;
 static int tipo;
 static String modelo;
 static String conexao;
 static int parametro;
 static Scanner input = new Scanner(System.in); 

 void configurarImpressora(){
    System.out.println("Digite o tipo de conexão:");
    System.out.println("1 - USB");
    System.out.println("2 - RS232");
    System.out.println("3 - TCP/IP");

    tipo = input.nextInt();
    input.nextLine();

    System.out.println("Digite o modelo da impressora:");
    modelo = input.nextLine();

    System.out.println("Digite a conexão:");
    conexao = input.nextLine();

    System.out.println("Digite o parametro:");
    parametro = input.nextInt();

    System.out.println("Dados armazenados com sucesso!");
}

 void abrirConexao(){
    if (conexaoAberta == false){
    int ret = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
   
    if(ret == 0){
        conexaoAberta = true;
        System.out.println("Comunicação bem sucedida");
        }else{
        System.out.println("Erro ao abrir comunicação. Retorno " + ret);
    }
 }   
    else{
     System.out.println("Já existe uma comunicação em aberto ");
}
}

void fecharConexao() {
    if (conexaoAberta == true) {
        int ret = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();

        if (ret == 0) {
            conexaoAberta = false;
            System.out.println("Comunicação fechada com sucesso!");
        } else {
            System.out.println( "Erro ao fechar comunicação. Retorno " + ret);
        }
    } 
    else {
        System.out.println("Não existe uma comunicação em aberto");
    }
}

void impressaoCodigoBarras() {
    if (conexaoAberta == true) {
        int ret = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(tipo, modelo, conexao, parametro);

        if (ret == 0) {
            System.out.println("Codigo de barras impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir codigo de barras. Retorno " + ret);
            }
        } 
        else {
            System.out.println("Não existe uma comunicação em aberto");
        }
}

void impressaoTexto() {

    if (conexaoAberta == true) {
        input.nextLine();

        System.out.println("Digite o texto para imprimir:");
        String dados = input.nextLine();
        int ret = ImpressoraDLL.INSTANCE.ImpressaoTexto(tipo, modelo, conexao, parametro, dados);

        if (ret >= 0) {
            System.out.println("Texto enviado com sucesso!");
        } else {
            System.out.println("Erro ao imprimir texto. Retorno " + ret);
        }
    } 
    else {
        System.out.println("Não existe uma comunicação em aberto. Abra a conexão antes.");
    }
}

void impressaoQRCode() {
    if (conexaoAberta == true) {
        int ret = ImpressoraDLL.INSTANCE.ImpressaoQRCode();
        
        if (ret == 0) {
            System.out.println("QR Code impresso com sucesso!");
        } else {
            System.out.println("Erro ao imprimir QR Code. Retorno " + ret);
        }
    } 
    else {
        System.out.println("Não existe uma comunicação em aberto");
    }
}

void sinalSonoro() {
    if (conexaoAberta == true) {
    int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(2, 50, 5);        
        if (ret == 0) {
            System.out.println("Bip executado com sucesso!");
        } else {
            System.out.println("Erro no sinal sonoro. Retorno " + ret);
        }
    } else {
        System.out.println("Não existe uma comunicação em aberto");
    }
}

void abreGaveta() {
    if (conexaoAberta == true) {
        int ret = ImpressoraDLL.INSTANCE.AbreGaveta();
        
        if (ret == 0) {
            System.out.println("Gaveta aberta com sucesso!");
        } else {
            System.out.println("Erro ao abrir gaveta. Retorno " + ret);
        }
    } 
    else {
        System.out.println("Não existe uma comunicação em aberto");
    }
}

void imprimeXMLSAT() {
    if (conexaoAberta == true) {
        int ret = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(xml, 0);
        
        if (ret == 0) {
            System.out.println("XML SAT impresso com sucesso!");
        } else {
            System.out.println("Erro ao imprimir XML SAT. Retorno " + ret);
        }
    }
     else {
        System.out.println("Não existe uma comunicação em aberto");
    }
}

void imprimeXMLCancelamentoSAT() {
    if (conexaoAberta == true) {
        String xmlCancelamento = "path=CANC_SAT.xml";
        String assQRCode = "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6Ksepk/q0E2e5x105cv3m1woYfgHy0kWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvX100SE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJd1TJ6p0ccqnZvuE70aH0I09elpjE06Cd+orI7XHHrFCwhFhAcbalc+zf05b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";
        
        int ret = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(xmlCancelamento, assQRCode, 0);
        
        if (ret == 0) {
            System.out.println("XML de Cancelamento impresso com sucesso!");
        } else {
            System.out.println("Erro ao imprimir cancelamento. Retorno " + ret);
        }
    } else {
        System.out.println("Não existe uma comunicação em aberto");
    }
}





























}