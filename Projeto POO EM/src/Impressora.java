import java.util.Scanner;

public class Impressora {

 static boolean conexaoAberta = false;
 static int tipo;
 static String modelo;
 static String conexao;
 static int parametro;
 static Scanner input = new Scanner(System.in); 

 void configurarImpressora(){
        System.out.println("Digite o modelo da impressora:");
        modelo = input.nextLine();

        System.out.println("Digite o tipo de conexão:");
        conexao = input.nextLine();

        System.out.println("Digite o parametro:");
        parametro = input.nextInt();

        System.out.println("Dados armazenados com sucesso!");
 }

 void abrirConexao(){
    if (conexaoAberta == false){
    int ret = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
   if(ret == 0){
    System.out.println("Comunicação Bem sucedida");
   }else{
    System.out.println("Erro ao abrir conexao. Retorno " + ret);
}
 }else{
    System.out.println("Ja existe uma cominucação em aberto ");
}
}
}