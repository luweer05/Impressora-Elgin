# 🖨️ Sistema de Controle de Impressora Elgin
### *(Troque pelo nome do seu projeto)*


## 📘 Sobre o Projeto

Este projeto foi desenvolvido por duas alunas para controlar uma impressora térmica usando Java e a biblioteca de integração (DLL) fornecida pelo professor Richard. O sistema conta com um sistema de login com limite de três tentativas, menu interativo e funções como: mandar imprimir texto, código de barras, QR Code, cupons do SAT, abrir a gaveta e até apitar O projeto faz parte da disciplina de **Programação Orientada a Objetos (POO)**



## 🧰 O que usamos

- **Java** (Versão 17 )
- **VSCODE** (Não usamo o IntelliJ porque o vscode é mais fácil para trabalhos em duplas/grupos)
- **JNA 5.15.0** 
- **SDK da Elgin** 
- **Impressora Elgin 


## 📁 Estrutura do Projeto

/src    → Código-fonte do sistema
Main.java → Classe principal, inicia o programa e gerencia 
Usuario.java  → Guarda a senha e confere o login
Impressora.java  → Guarda os dados da conexão e todos os comandos da impressora(DLL)
Menu.java → Exibe o menu interativo e processa as escolhas do usuário
/Bibliotecas E1 Impressora → DLLs da Elgin (versões x64 e x86)
/libs Java  → Biblioteca jna-5.15.0.jar

## ⚙️ Instalação e Execução

### 1. Baixar o projeto
1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo em algum lugar no pc.

### 2. Abrir no IntelliJ IDEA
1. **File → Open** e escolha a pasta extraída.
2. Em **File → Project Structure → Libraries**, confirme que o `jna-5.15.0.jar` está adicionado.
3. Conecte e ligue a impressora.
4. Abra `Main.java` e clique em ▶️ **Run**.


## 🔐 Login

- O sistema solicita um **usuário** e uma **senha** válidos
- O usuário possui um limite de **até 3 tentativas** de acesso
- A cada erro, o programa informa quantas tentativas restam. Caso esgote as 3 tentativas, o programa é encerrado



## 📋 Funcionalidades do Menu

| Opção | O que faz |
| **1** | Configura a conexão (tipo, modelo, porta e parâmetro) |
| **2** | Abre a conexão com a impressora |
| **3** | Fecha a conexão com a impressora|
| **4** | Imprime um texto escolhido |
| **5** | Imprime um QR Code |
| **6** | Imprime código de barras |
| **7** | Imprime o XML de venda SAT |
| **8** | Imprime o XML de cancelamento SAT |
| **9** | Abre a gaveta de dinheiro |
| **10** | Emitir sinal sonoro (bip) |
| **11** | Fecha conexão e sai do programa |



## 🧪 Testes Realizados

- **Login:** Testado o bloqueio após 3 tentativas incorretas de senha e o acesso bem sucedido com as informações corretas.
- **Conexão:** Validação da abertura e fechamento de comunicação via USB com a impressora Elgin.
- **Validação de Segurança:** Tentativa de enviar comandos de impressão com a conexão fechada para garantir que o sistema bloqueia e avisa o usuário corretamente
- **Impressões e Comandos:** Testados com sucesso o envio de textos, códigos de barras, QR Code, arquivos XML de SAT e acionamento de bip/gaveta.



## 📚 Documentação Adicional

- Manual da impressora Elgin
- Documentação do SDK E1_Impressora



## 👥 Autores

- Janaína Lima Nunes dos Santos 
- Maria Luiza Aparecida do Anjos Dias Simões 
