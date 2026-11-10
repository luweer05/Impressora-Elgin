public class Menu {
  menuImpressora(){
    while(true){
        menuImpresso();
        System.out.println("Digite a opção desejada:\n");
        int opc = input.nextInt();

        switch (opc){
            case 1:
                impressora.configurarImpressora();
                break;
            case 2:
                impressora.abrirConexao();
                break;
        }
    }
  }
}
