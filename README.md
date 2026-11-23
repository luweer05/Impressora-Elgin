# 🖨️ Sistema de Controle de Impressora Elgin

## 📘 Sobre o Projeto

Este projeto foi desenvolvido por alunos para controlar uma impressora térmica Elgin utilizando Java e a biblioteca `E1_Impressora01.dll`. O sistema possui login e um menu com funções de impressão e controle da impressora. Foi desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)**.

## 🧰 Tecnologias Utilizadas

- Java
- IntelliJ IDEA
- JNA 5.15.0
- DLL E1_Impressora01 (SDK da Elgin)
- Impressora Elgin

## 📁 Estrutura do Projeto

```text
/src
   Main.java              → Inicia o programa
   Usuario.java           → Realiza o login
   Menu.java              → Exibe as opções
   Impressora.java        → Executa as funções da impressora
   ImpressoraDLL.java     → Faz a comunicação com a DLL

/Bibliotecas E1 Impressora
   x64 e x86              → Arquivos da impressora

/libs Java
   jna-5.15.0.jar         → Biblioteca JNA
```

## ⚙️ Instalação e Execução

### 1. Baixar o projeto
1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia os arquivos.

### 2. Abrir no IntelliJ IDEA
1. Abra a pasta do projeto no IntelliJ.
2. Adicione o arquivo `jna-5.15.0.jar` às bibliotecas.
3. Conecte a impressora.
4. Abra `Main.java` e clique em **Run**.

## 🔐 Login

- **Usuário:** admin
- **Senha:** 1234
- **Tentativas permitidas:** 3

## 📋 Funcionalidades do Menu

| Opção | Função |
|---|---|
| 1 | Configurar impressora |
| 2 | Abrir conexão |
| 3 | Fechar conexão |
| 4 | Imprimir texto |
| 5 | Imprimir QR Code |
| 6 | Imprimir código de barras |
| 7 | Imprimir cupom |
| 8 | Imprimir XML SAT |
| 9 | Imprimir XML de cancelamento |
| 10 | Abrir gaveta |
| 11 | Emitir sinal sonoro |
| 12 | Avançar papel |
| 13 | Verificar status do papel |
| 0 | Sair do sistema |

## 🧪 Testes Realizados

Foram preparados testes para verificar o login, a conexão com a impressora e as funções de impressão, além do acionamento da gaveta, sinal sonoro e avanço de papel.

## 📚 Documentação Adicional

- Manual da impressora Elgin.
- Documentação do SDK E1_Impressora.

## 👥 Autores

- Maria Luiza Aparecida Dos Anjos Dias Simões
- Janaina Lima Nunes
