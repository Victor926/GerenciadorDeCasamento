/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author victo
 */
public class GerenciadorDeCasamento {
    
    private Scanner scanner = new Scanner(System.in);
    PessoaDAO pessoaDAO = new PessoaDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    RecadoDAO recadoDAO = new RecadoDAO();
    PresenteDAO presenteDAO = new PresenteDAO();
    ConvidadoFamiliaDAO convidadoFamiliaDAO = new ConvidadoFamiliaDAO();
    ConvidadoIndividualDAO convidadoIndividualDAO = new ConvidadoIndividualDAO();
    Evento evento = new Evento();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Calendario calendario = new Calendario();
    public GerenciadorDeCasamento() {
        
        System.out.println("\n CRIACAO DO NOIVO...");
        Pessoa noivo = this.criarPessoa();
        System.out.println("\n Qual o login do Noivo: ");
        String loginNoivo = scanner.nextLine();
        System.out.println("\n Qual a senha do Noivo: ");
        String senhaNoivo = scanner.nextLine();
        Usuario usuarioNoivo = new Usuario(noivo, loginNoivo, senhaNoivo);
        usuarioDAO.adiciona(usuarioNoivo);
        
        System.out.println("\n\nCRIACAO DA NOIVA...");
        Pessoa noiva = this.criarPessoa();
        System.out.println("\n Qual o login do Noiva:");
        String loginNoiva = scanner.nextLine();
        System.out.println("\n Qual a senha do Noiva:");
        String senhaNoiva = scanner.nextLine();
        Usuario usuarioNoiva = new Usuario(noiva, loginNoiva, senhaNoiva);
        usuarioDAO.adiciona(usuarioNoiva);
        
        //AMBIENTE DE TESTES
        /*Fornecedor fornecedorTemporarioLogado = this.criarFornecedor();
        fornecedorDAO.adiciona(fornecedorTemporarioLogado);
        
        this.calendario.verificarPagamento(this.dataVerificar.plusMonths(0));
        this.calendario.verificarPagamento(this.dataVerificar.plusMonths(1));
        this.calendario.verificarPagamento(this.dataVerificar.plusMonths(2));
        this.calendario.verificarPagamento(this.dataVerificar.plusMonths(3));
        System.out.println(this.calendario.toString());
        this.fornecedorDAO.verificarVetorPagamentos();
        System.out.println("O estado do pagamento eh: " + this.fornecedorDAO.fornecedores[0].getEstado());
        System.out.println(this.calendario.relatorioPagamentosNoivos(0, 1));
        System.out.println(this.calendario.toString());*/
        //fim do ambiente de testes
        int opcaoUsuario = 7;
        
        do {
            
            opcaoUsuario = this.menuInicial();
            
            switch (opcaoUsuario) {
                case 1:
                    System.out.println("\n\n Voce escolheu: 1 - LOGAR \n");
                    Usuario logado = this.verificarUsuarioLogado();
                    //LOGADO COMO NOIVO OU CERIMONIALISTA
                    if (logado != null && (logado.getTipo().equals("N") || logado.getTipo().equals("CE") )) {                 
                        int opcaoLogadoNoivo = 11;
                        
                        do {
                            opcaoLogadoNoivo = this.menuLogadoNoivo();
                            
                            switch (opcaoLogadoNoivo) {
                                case 1:
                                    System.out.println("\n\n Voce escolheu: 1 - CADASTRAR PESSOA \n");
                                    this.criarPessoa();
                                    break;
                                case 2:
                                    System.out.println("\n\n Voce escolheu: 2 - CADASTRAR USUARIO \n");
                                    this.criarUsuario();
                                    break;
                                case 3:
                                    System.out.println("\n\n Voce escolheu: 3 - CADASTRAR FORNECEDOR \n");
                                    this.criarFornecedor();
                                    
                                    break;
                                case 4:
                                    System.out.println("\n\n Voce escolheu: 4 - CADASTRAR EVENTO \n");
                                    this.criarEvento();
                                    break;
                                case 5:
                                    System.out.println("\n\n Voce escolheu: 5 - CADASTRAR CONVITES INDIVIDUAL\n");
                                    this.criarConviteIndividual();
                                    break;
                                case 6:
                                    System.out.println("\n\n Voce escolheu: 6 - CADASTRAR CONVITES FAMILIA\n");
                                    this.criarConviteFamilia();
                                    break;
                                case 7:
                                    System.out.println("\n\n Voce escolheu: 7 - CADASTRAR PRESENTES \n");
                                    this.criarPresente();
                                    break;
                                case 8:
                                    System.out.println("\n\n Voce escolheu: 8 - CADASTRAR PAGAMENTOS \n");
                                    this.criarPagamentoQualquer();
                                    break;
                                case 9:
                                    System.out.println("\n\n Voce escolheu: 9 - GERAR RELATORIOS E CONVITES\n");
                                    int opcMenuRelatorios = 0;
                                    
                                    do {
                                        opcMenuRelatorios = this.menuRelatorios();
                                        switch(opcMenuRelatorios) {
                                            case 1:
                                                recadoDAO.mostrar();
                                                break;
                                            case 2:
                                                //GERAR CONVITE INDIVIDUAL
                                                this.imprimirConviteIndividual();
                                                break;
                                            case 3:
                                                //GERAR CONVITE FAMILIA
                                                this.imprimirConviteFamilia();
                                                break;
                                            case 4:
                                                System.out.println(this.calendario.relatorioPagamentosNoivos(0, 1));
                                                break;
                                            case 5:
                                                //LISTA DE CONVIDADOS
                                                this.listaConvidados();
                                                break;
                                            case 6:
                                                //LISTA DE CONVIDADOS CONFIRMADOS
                                                this.gerarRelatorioConvidadosConfirmados();
                                                break;
                                            default:
                                                if(opcMenuRelatorios!=7){
                                                    System.out.println("\n\n Opcao Invalida! Tente Novamente!");
                                                }
                                                
                                                break;
                                        }
                                    }while(opcMenuRelatorios != 7);
                                    
                                    break;
                                case 10:
                                    System.out.println("\n Voce escolheu: 10 - MENU DE EXCLUSOES");
                                    int opcMenuExcluir;
                                    
                                    do {
                                        opcMenuExcluir = this.menuExcluir();
                                        switch(opcMenuExcluir) {
                                            case 1:
                                                //EXCLUIR PESSOA
                                                if(this.excluirPessoa()){
                                                      System.out.println("\n Pessoa excluido com sucesso");
                                                }
                                                break;
                                            case 2:
                                                //EXCLUIR USUARIO
                                                if(this.excluirUsuario()) {
                                                    System.out.println("\n Usuario excluido com sucesso");
                                                } 
                                                else {
                                                    System.out.println("\n Não foi possivel excluir o usuario");  
                                                }
                                                break;
                                            case 3:
                                                //EXCLUIR CONVITE INDIVIDUAL
                                                if(this.excluirConviteIndividual()) {
                                                    System.out.println("\n Convite Individual excluido com sucesso");
                                                }
                                                else {
                                                    System.out.println("\n Nao foi possivel excluir o convite individual");
                                                }
                                                break;
                                            case 4:
                                                //EXCLUIR CONVITE FAMILIA
                                                if(this.excluirConviteFamilia()) {
                                                    System.out.println("\n Convite Familia excluido com sucesso");
                                                }
                                                else {
                                                    System.out.println("\n Nao foi possivel excluir o convite familia");
                                                }
                                                break;
                                            case 5:
                                                //EXCLUIR FORNECEDOR
                                                if(this.excluirFornecedor()){
                                                    System.out.println("\n Fornecedor excluido com sucesso");
                                                }
                                                else{
                                                    System.out.println("\n Nao foi possivel excluir o fornecedor");
                                                }
                                                break;
                                            case 6:
                                                //EXCLUIR PAGAMENTO
                                                break;
                                            case 7:
                                                //EXCLUIR PRESENTE
                                                if(this.excluirPresente()) {
                                                    System.out.println("\n Presente excluido com sucesso");
                                                }
                                                else {
                                                    System.out.println("\n Nao foi possivel excluir o presente");
                                                }
                                                break;
                                            case 8:
                                                //EXCLUIR RECADO
                                                if(this.excluirRecado()) {
                                                    System.out.println("\n Reacdo excluido com sucesso");
                                                }
                                                else {
                                                    System.out.println("\n Nao foi possivel excluir o recado");
                                                }
                                                break;
                                            default:
                                                if(opcMenuExcluir != 9){
                                                    System.out.println("\n\n Opcao Invalida! Tente Novamente!");
                                                }
                                                
                                                break;
                                        }
                                    }while(opcMenuExcluir != 9);
                                
                                default:
                                    if(opcaoLogadoNoivo!=10){
                                        System.out.println("\n\n Opcao Invalida! Tente Novamente!");
                                    }  
                                    break;
                            }
                        }while (opcaoLogadoNoivo != 11);
                        
                    } else {
                        //LOGADO COMO OUTRO
                        if (logado != null && "CO".equals(logado.getTipo())) {
                            System.out.println("\nVoce logou como CONVIDADO" +
                                               "\nVoce pode confirmar a presenca" +
                                               "\nPara isso, informe seu ACESSO: ");

                            String acessoTemporario = scanner.nextLine();
                            
                            ConvidadoFamilia familia = convidadoFamiliaDAO.buscarFamilia(acessoTemporario);

                            if (familia != null) {
                                System.out.println("\nAcesso existe!");

                                int opcaoLogadoOutro = this.menuLogadoOutro();
        
                                switch (opcaoLogadoOutro) {
                                    case 1: 
                                        System.out.println("\n\nVocê CONFIRMOU presenca da sua familia!");
                                        convidadoIndividualDAO.confirmarPresenca(familia, "confirmado");
                                        break;

                                    case 2: 
                                        System.out.println("\n\nSua familia NAO vai ao evento!");
                                        convidadoIndividualDAO.confirmarPresenca(familia, "nao confirmado");
                                        break;

                                    default:
                                    System.out.println("\n\nCaractere Invalido! Tente Novamente!");
                                }
                            } 
                            else {
                                System.out.println("\nNAO foi encontrado esse ACESSO! Tente Novamente");
                            }
                        }        
                }
                break;
                case 2:
                    System.out.println("\n\n Voce escolheu: 2 - ENTAR SEM LOGAR \n");
                    int opcaoEntrarSemLogar = 1;
                    
                    do {
                        opcaoEntrarSemLogar = menuEntrarSemLogar();
                        
                        switch(opcaoEntrarSemLogar) {
                            case 1:
                            System.out.println("\n\n Voce escolheu: 1 - CADASTRAR PRESENTE \n");
                            this.selecionarPresente();
                            break;
                        case 2:
                            System.out.println("\n\n Voce escolheu: 2 - CADASTRAR RECADO \n");
                            this.criarRecado();
                            break;
                        default:
                            if(opcaoEntrarSemLogar!=3){
                                System.out.println("\n\n Caracter Invalido! Tente Novamente!");
                            }
                        }

                    } while (opcaoEntrarSemLogar != 3);
                    break;
                default:
                    System.out.println("\n\n Opcao Invalida! Tente Novamente!");
                    break;
            }
        }while (opcaoUsuario != 3);
    }
    
    public static void main(String[] args) {
        
        GerenciadorDeCasamento g = new GerenciadorDeCasamento();
        
    }
    
    public int menuInicial() {
        this.calendario.verificarPagamento();
        this.fornecedorDAO.verificarVetorPagamentos();
        System.out.println(this.calendario.toString());
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\nSEJA BEM VINDO AO GERENCIADOR DE CASAMENTO\n\n");
        builder.append("\n1 - LOGAR..................................");
        builder.append("\n2 - ENTRAR SEM LOGAR.......................");
        builder.append("\n3 - SAIR...................................");
        builder.append("\n\n SUA OPCAO: ");

        System.out.print(builder.toString());
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Caracter Invalido! Insira um Numero.");
            return -1;
        }
    }
    //============================== CRIAÇÕES ===============================================
    private Pessoa criarPessoa() {
        
        Pessoa p = new Pessoa();
        
        //RECEBENDO OS ATRIBUTOS
        //NOME
        System.out.println("Qual o nome: ");
        p.setNome(scanner.nextLine());
        // NASCIMENTO
        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            System.out.println("Qual a data de nascimento: (dd/mm/yyyy):");
            String dataNaoFormatada = scanner.nextLine();
            try {
                dataNascimento = LocalDate.parse(dataNaoFormatada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Data invalida! Tente novamente no formato (dd/mm/yyyy):");
            }
        }
        p.setDataNascimento(dataNascimento);
       //TELEFONE
       String telefone = null;
       int flag = 0;
       while(flag == 0)
       {
            System.out.println("Qual o telefone (xx-xxxxx-xxxx)");
            telefone = scanner.nextLine();
            if (!telefone.matches("\\d{2}-\\d{5}-\\d{4}")) {
                System.out.println("Telefone invalido! Use o formato (xx-xxxxx-xxxx):");
            } else {
                p.setTelefone(telefone);
                flag = 1;
            }
       }

        //ADICIONANDO A PESSOA
        if (pessoaDAO.adiciona(p)) {
            System.out.println("\nPessoa Adicionada! \n\n");
            System.out.println(p.toString());
            return p;
        } else {
            System.out.println("\n NAO foi possivel adicionar a pessoa! \n\n");
            return null;
        }
    }
    
    
    public Usuario criarUsuario() {
    
        Usuario u = new Usuario();
        Pessoa pessoa = null;
        //VERIFICANDO SE A PESSOA EXISTE
            System.out.print("\nPara adicionar um Usuario, eh preciso que esse ja seja uma pessoa.\n" + 
                             "Informe o ID da pessoa: ");
            long idPessoa = scanner.nextLong();
            scanner.nextLine();
            pessoa = pessoaDAO.buscaPorId(idPessoa);
            
        if (pessoa != null) {

            //RECEBENDO ATRIBUTOS
            //PESSOA
            u.setPessoa(pessoa);
            //TIPO
            String tipo;
            do {
                System.out.print("Informe o tipo de usuario [CE - cerimonialista, CO - Convidado]: ");
                tipo = scanner.nextLine().toUpperCase();
            } while (!tipo.equals("CE") && !tipo.equals("CO"));
            u.setTipo(tipo);
            // LOGIN
            boolean loginDisponivel;
            String login;
            do {
                System.out.print("Qual o login: ");
                login = scanner.nextLine();

                loginDisponivel = usuarioDAO.buscaPorLogin(login) == null;

                if (!loginDisponivel) {
                    System.out.println("Login ja existe! Tente outro!");
                }
            } while (!loginDisponivel);
            u.setLogin(login);
            //SENHA
            System.out.print("Qual a senha: ");
            String senha = scanner.nextLine(); 
            u.setSenha(senha);

            // ADICIONANDO O USUARIO
            if (usuarioDAO.adiciona(u)) {
                System.out.println("\nUsuario Adicionado! \n\n");
                System.out.println(u.toString());
                return u;
            } else {
                System.out.println("\nNAO foi possivel adicionar o usuario! \n\n");
                return null;
            }
        } else {
            System.out.println("Pessoa NAO encontrada! Tente novamente!");
            return null;
        }
        

    }
    
    private Usuario verificarUsuarioLogado() {
        
        System.out.println("\n Qual o Login: ");
        String login = scanner.nextLine();
        System.out.println("\n Qual a Senha:");
        String senha = scanner.nextLine();
        Usuario u = usuarioDAO.buscaUsuarioLogin(login, senha);
        
        if (u != null) {
            return u;
        } else {
            return null;
        }    
    }

    private int menuLogadoNoivo() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\n VOCE ENTROU LOGADO COMO NOIVO/NOIVA\n");
        builder.append("\n1  - CADASTRAR PESSOA..................");
        builder.append("\n2  - CADASTRAR USUARIO.................");
        builder.append("\n3  - CADASTRAR FORNECEDOR..............");
        builder.append("\n4  - CADASTRAR EVENTO..................");
        builder.append("\n5  - CADASTRAR CONVITES INDIVIDUAIS....");
        builder.append("\n6  - CADASTRAR CONVITES FAMILIAS.......");
        builder.append("\n7  - CADASTRAR PRESENTES...............");
        builder.append("\n8  - CADASTRAR PAGAMENTOS..............");
        builder.append("\n9  - GERAR RELATORIOS E CONVITES.......");
        builder.append("\n10 - MENU DE ESXCLUSOES................");
        builder.append("\n11 - SAIR..............................");
        builder.append("\n\n SUA OPCAO: ");

        System.out.print(builder.toString());
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Caracter Invalido! Insira um Numero.");
            return -1;
        }
    }
    
    private int menuLogadoOutro() {
        StringBuilder builder = new StringBuilder("");       
        builder.append("\n\n VOCE ENTROU LOGADO COMO OUTRO\n");
        builder.append("\n VOCE VAI COMPARECER AO EVENTO?");
        builder.append("\n1 - SIM........................");
        builder.append("\n2 - NAO........................");
        builder.append("\n3 - SAIR.......................");
        builder.append("\n\n SUA OPCAO: ");
        System.out.print(builder.toString());
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Caracter Invalido! Insira um Numero.");
            return -1;
        }
    }

    private int menuEntrarSemLogar() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\n VOCE ENTROU SEM LOGAR\n");
        builder.append("\n1 - SELECIONAR PRESENTES......");
        builder.append("\n2 - CADASTRAR RECADO.........");
        builder.append("\n3 - SAIR.....................");
        builder.append("\n\n SUA OPCAO: ");
        System.out.print(builder.toString());
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Caracter Invalido! Insira um Numero.");
            return -1;
        }
    }
    
    private int menuRelatorios() {
        StringBuilder builder = new StringBuilder("");
        
        builder.append("\n\n MENU RELATORIOS e CONVITES \n");
        builder.append("\n 1 - LISTA DE RECADOS....................");
        builder.append("\n 2 - GERAR CONVITE INDIVIDUAL............");
        builder.append("\n 3 - GERAR CONVITE PARA FAMILIA..........");
        builder.append("\n 4 - PAGAMENTOS REALIZADOS PELOS NOIVOS..");
        builder.append("\n 5 - LISTA DE CONVIDADOS.................");
        builder.append("\n 6 - LISTA DE CONVIDADOS CONFIRMADOS.....");
        builder.append("\n 7 - SAIR................................");
        builder.append("\n\n SUA OPCAO: ");
        System.out.print(builder.toString());
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Caracter Invalido! Insira um Numero!");
            return -1;
        }
    }
    
    private int menuExcluir(){
        StringBuilder builder = new StringBuilder("");
        
        builder.append("\n\n MENU DE EXCLUSOES \n");
        builder.append("\n 1 - EXCLUIR PESSOA......................");
        builder.append("\n 2 - EXCLUIR USUARIO.....................");
        builder.append("\n 3 - EXCLUIR CONVITE INDIVIDUAL..........");        
        builder.append("\n 4 - EXCLUIR CONVITE FAMILIA.............");
        builder.append("\n 5 - EXCLUIR FORNECEDOR..................");
        builder.append("\n 6 - EXCLUIR PAGAMENTO...................");
        builder.append("\n 7 - EXCLUIR PRESENTE....................");
        builder.append("\n 8 - EXCLUIR RECADO......................");
        builder.append("\n 9 - SAIR................................");
        builder.append("\n\n SUA OPCAO: ");
        System.out.print(builder.toString());
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Caracter Invalido! Insira um Numero!");
            return -1;
        }
    }

    private Fornecedor criarFornecedor() {
        
        Fornecedor f = new Fornecedor();
        
        //RECEBENDO ATRIBUTOS
        //NOME
        System.out.println("\n Qual o nome do fornecedor: ");
        f.setNome(scanner.nextLine());
        //CNPJ
        System.out.println("\n Qual o CNPJ do fornecedor,deve haver 14 digitos: ");
        String cnpj = scanner.nextLine();
        while (!validarCnpj(cnpj)) {
            System.out.println("\n Esse CNPJ eh invalido. Deve haver 14 digitos. Tente Novamente: ");
            cnpj = scanner.nextLine();
        }
        f.setCnpj(cnpj);
        //TELEFONE
        System.out.println("\n Qual o telefone do fornecedor (xx-xxxxx-xxxx):");
        String telefone = scanner.nextLine();
        while (!validarTelefone(telefone)) {
            System.out.println("\n Esse telefone eh inválido. Tente novamente no seguinte formato (xx-xxxxx-xxxx): ");
            telefone = scanner.nextLine();
        }
        f.setTelefone(telefone);
        
        //ESTADO
        System.out.println("\n Qual o estado do pagamento? (pago ou em pagamento):");
        String estado = scanner.nextLine().toLowerCase();
        while (!estado.equals("pago") && !estado.equals("em pagamento")) {
            System.out.println("\n Invalido! Insira 'pago' ou 'em pagamento':");
            estado = scanner.nextLine().toLowerCase();
        }
        f.setEstado(estado);
        f.setPagamentoDAO(criarPagamentoFornecedor()); 
        // ADICIONANDO O FORNECEDOR
        if (fornecedorDAO.adiciona(f)) {
            System.out.println("\nFornecedor Adicionado! \n\n");
            System.out.println(f.toString());
            return f;
        } else {
            System.out.println("\nNAO foi possivel adicionar o forncedor! \n\n");
            return null;
        }
        
    }
    
    private void criarEvento(){
        System.out.println("Qual o nome do cartorio?");
        Cartorio cartorio = new Cartorio(scanner.nextLine());
        this.evento.setCartorio(cartorio);
        
        System.out.println("Qual o nome da Igreja?");
        Igreja igreja = new Igreja(scanner.nextLine());
        this.evento.setIgreja(igreja);
        
        System.out.println("Qual o nome do Cerimonial?");
        Cerimonial cerimonial = new Cerimonial(scanner.nextLine());
        this.evento.setCerimonial(cerimonial);
        
        this.evento.setNoivo(pessoaDAO.getPessoa(0));
        this.evento.setNoiva(pessoaDAO.getPessoa(1));
        System.out.println(this.evento);
    }

    private Presente criarPresente() {
        
        Presente p = new Presente();
        
        //RECEBENDO ATRIBUTOS
        //NOME
        System.out.println("\n Qual o NOME do PRESENTE: ");
        p.setNome(scanner.nextLine());
        //TIPO
        System.out.println("\n Qual o TIPO do PRESENTE: ");
        p.setTipo(scanner.nextLine());
        //VALOR
        System.out.println("\n Qual o PRECO do PRESENTE: ");
        String preco = scanner.nextLine();
        p.setValor(Double.parseDouble(preco));
        //PESSOA
        p.setPessoa(null);
        // ADICIONANDO O PRESENTE
        if (presenteDAO.adicionar(p)) {
            System.out.println("\nPRESENTE Adicionado! \n\n");
            System.out.println(p.toString());
            return p;
        } else {
            System.out.println("\nNAO foi possivel adicionar o PRESENTE! \n\n");
            return null;
        }
    }
    
    private Recado criarRecado() {
        
        Recado r = new Recado();
        
        //RECEBENDO ATRIBUTOS
        //AUTOR
        System.out.println("\n De quem eh esse recado: ");
        String nome = scanner.nextLine();
        Pessoa pessoaTemporaria = pessoaDAO.buscaPorNome(nome);
        if (pessoaTemporaria != null) {
            //TEXTO
            System.out.println("\n Digite o recado: ");
            r.setComentario(scanner.nextLine());
            r.setPessoa(pessoaTemporaria);
            // ADICIONANDO O RECADO
            if (recadoDAO.adiciona(r)) {
                System.out.println("\nRecado Adicionado! \n\n");
                System.out.println(r.toString());
                return r;
            } else {
                System.out.println("\nNAO foi possivel adicionar o recado! \n\n");
                return null;
            }
        }
        else {
            System.out.println("\n Essa pessoa NAO foi encontrada! Tente Novamente!");
            return null;
        }
    }
        
    public void relatorioDeRecados() {
        System.out.println("\n\n Voce escolheu ver o relatorio de recados \n");
        recadoDAO.mostrar();
    }
    
    public void listaConvidados() {
        System.out.println("\n\n Voce escolheu ver a lista de convidados \n");
        convidadoIndividualDAO.mostrar();
    }
    
    private void criarPagamentoQualquer(){
        System.out.println("\n O que sera pago?");
        String descricao = scanner.nextLine();
        //perguntar primeiro o valor da parcela para já inserir todas de uma vez no calendário
        System.out.println("\n Sao quantas parcelas?");
        int parcelaTotal = scanner.nextInt();
        
        System.out.println("\n Qual o valor de cada parcela? Se for unica, qual o valor da parcela unica?");
        double valorParcela = scanner.nextDouble();
        
        LocalDate dataParcela = null;
        while (dataParcela == null) {
            System.out.println("\n Qual a data do pagamento da primeira parcela? (dd/mm/yyyy)");
            String dataNaoFormatada = scanner.nextLine();
            try {
                dataParcela = LocalDate.parse(dataNaoFormatada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("\n Data invalida! Tente novamente no formato (dd/mm/yyyy):");
            }
        }


        Pessoa pessoa = null;
        do{
            System.out.println("\n Qual o id da pessoa a pagar?");
            long idPessoa = scanner.nextLong();
            scanner.nextLine();
            pessoa = pessoaDAO.buscaPorId(idPessoa);
            if(pessoa != null){
                System.out.println("\n Pessoa encontrada!");
            }
            else{
                System.out.println("\n Id invalido, tente novamente...");
            }
        }while(pessoa == null);
        int parcelaAtual = 1;
        do{
            Pagamento pagamentoTemporario = new Pagamento(pessoa, descricao, valorParcela, parcelaTotal, parcelaAtual, dataParcela.plusMonths(parcelaAtual - 1));
            inserirNoCalendario(pagamentoTemporario);
            parcelaAtual++;
        }while(parcelaAtual <= parcelaTotal);
    }
    
    private PagamentoDAO criarPagamentoFornecedor(){
        PagamentoDAO pagamentos = new PagamentoDAO();
        System.out.println("\n O que sera pago?");
        String descricao = scanner.nextLine();
        //perguntar primeiro o valor da parcela para já inserir todas de uma vez no calendário
        System.out.println("Sao quantas parcelas?");
        int parcelaTotal = scanner.nextInt();
        
        System.out.println("\n Qual o valor de cada parcela? Se for unica, qual o valor da parcela unica?");
        double valorParcela = scanner.nextDouble();
        
        LocalDate dataParcela = null;
        while (dataParcela == null) {
            System.out.println("\n Qual a data do pagamento da primeira parcela? (dd/mm/yyyy)");
            String dataNaoFormatada = scanner.nextLine();
            try {
                dataParcela = LocalDate.parse(dataNaoFormatada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("\n Data invalida! Tente novamente no formato (dd/mm/yyyy):");
            }
        }


        Pessoa pessoa = null;
        do{
            System.out.println("\n Qual o id da pessoa a pagar?");
            long idPessoa = scanner.nextLong();
            scanner.nextLine();
            pessoa = pessoaDAO.buscaPorId(idPessoa);
            if(pessoa != null){
                System.out.println("Pessoa encontrada!");
            }
            else{
                System.out.println("Id invalido, tente novamente...");
            }
        }while(pessoa == null);
        int parcelaAtual = 1;
        do{
            Pagamento pagamentoTemporario = new Pagamento(pessoa, descricao, valorParcela, parcelaTotal, parcelaAtual, dataParcela.plusMonths(parcelaAtual - 1));
            inserirNoCalendario(pagamentoTemporario);
            pagamentos.adicionar(pagamentoTemporario);
            parcelaAtual++;
        }while(parcelaAtual <= parcelaTotal);
        return pagamentos;
    }
        
    private void inserirNoCalendario(Pagamento pagamento){
        this.calendario.adiciona(pagamento);
    }
    private boolean validarCnpj(String cnpj) {
        return cnpj != null && cnpj.matches("\\d{14}");
    }
    
    private boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d{2}-\\d{5}-\\d{4}");
    }
    
    private ConvidadoIndividual criarConviteIndividual() {
        ConvidadoIndividual ci = new ConvidadoIndividual();

        System.out.print("\nDigite o NOME da pessoa que deseja convidar: ");
        String nomePessoa = scanner.nextLine();

        Pessoa pessoa = pessoaDAO.buscaPorNome(nomePessoa);

        if (pessoa == null) {
            System.out.println("\nPESSOA nao encontrada! Tente Novamente!");
            return null;
        }

        ci.setPessoa(pessoa);

        //RECEBE O NOME DA FAMILIA
        System.out.print("\nDigite a FAMILIA dessa pessoa: ");
        String nomeFamilia = scanner.nextLine();
        
        ConvidadoFamilia familia = convidadoFamiliaDAO.buscarFamiliaPorNome(nomeFamilia);
        
        if (familia == null) {
            System.out.println("\nFAMILIA nao encontrada! Tente Novamente!");
            return null;
        }
        
        ci.setFamilia(familia);
   
        System.out.print("\nQual o PARENTESCO? ");
        ci.setParentesco(scanner.nextLine());

        //ADICIONADO O CONVIDADO
        if (convidadoIndividualDAO.adiciona(ci)) {
            System.out.println("\n Convidado: "+ ci +" ADICIONADO!");
            return ci;
        } else {
            System.out.println("\nNAO foi possivel fazer o convite! Tente Novamente!");
            return null;
        }    
    }

    private void selecionarPresente() {
        
        Presente p = new Presente();
        
        presenteDAO.mostrar();
        
        System.out.println("\n Qual presente voce deseja selecionar: ");
        String nomePresente = scanner.nextLine();
        System.out.println("\n Qual o nome da pessoa que quer seleciona-lo: ");
        String nomePessoa = scanner.nextLine();
        
        if(presenteDAO.selecionarPresente(nomePresente, nomePessoa, pessoaDAO) == true) {
            System.out.println(nomePessoa + " voce selecionou o presente: " + nomePresente);
        }
        else {
            System.out.println("\n Tente Novamente!");
        }
    }

    private ConvidadoFamilia criarConviteFamilia() {
        ConvidadoFamilia cf = new ConvidadoFamilia();
        int cont = 0;
        //RECDNDO O NOME DA FAMILIA
        System.out.print("\n Digite o NOME da familia que deseja convidar: ");
        String nomeFamilia = scanner.nextLine();
        ConvidadoFamilia familia = convidadoFamiliaDAO.buscarFamiliaPorNome(nomeFamilia);
        if (familia == null) {
            //ADICIONADO A FAMILIA
            cf.setNome(nomeFamilia);
            //CRIANDO ACESSO
            String diaMesAno = String.format("%02d%02d%04d", LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
            String primeiroNomeNoivo = pessoaDAO.getNomePessoa(0).split(" ")[0]; //MOD AQUI
            String primeiroNomeNoiva = pessoaDAO.getNomePessoa(1).split(" ")[0]; //MOD AQUI
            String letrasAleatorias = letrasAleatorias(3);
            String acesso = diaMesAno + primeiroNomeNoivo + primeiroNomeNoiva + letrasAleatorias;
            cf.setAcesso(acesso);
            if(convidadoFamiliaDAO.adiciona(cf)) {
                System.out.println("\n FAMILIA com o id: "+ cf.getId() +" convidada! O acesso eh o seguinte: " + acesso);
                return cf;
            }
            else {
                System.out.println("\n NAO foi possivel adicionar a familia!");
                return null;
            }
            
        }
        else {
            System.out.println("\n Essa FAMILIA ja foi convidada!");
            return null;
        }
          
    }
    
    private String letrasAleatorias(int tamanho) {
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder letras = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int indice = random.nextInt(alfabeto.length());
            letras.append(alfabeto.charAt(indice));
        }
        return letras.toString();
    }
    
    
    
    public void imprimirConviteIndividual() {
        System.out.print("Para qual PESSOA deseja imprimir um Convite: ");
        String nomePessoa = scanner.nextLine();
        
        String nomeNoivo = pessoaDAO.getNomePessoa(0).split(" ")[0];
        String nomeNoiva = pessoaDAO.getNomePessoa(1).split(" ")[0];
        
        //PROCURAR CONVIDADO
        ConvidadoIndividual convidado = convidadoIndividualDAO.buscaPorNome(nomePessoa);
        if (convidado != null) {
            System.out.println("\n-------------------- CONVITE DE CASAMENTO --------------------");
            System.out.println("\nCasamento de " + nomeNoivo + " e " + nomeNoiva);
            System.out.printf ("\nQuerido(a) %s,\n", convidado.getPessoa().getNome());
            System.out.println("\nConvidamos voce a participar da nossa Celebracao de Casamento!");
            System.out.println("\nEsperamos voce la!");
            System.out.println("------------------------------------------------------------\n");
        } else {
 
            System.out.println("A pessoa não está na lista de convidados individuais.");
        }
    }

    public void imprimirConviteFamilia() {
        System.out.print("Para qual FAMILIA deseja imprimir um Convite: ");
        String nomeFamilia = scanner.nextLine();

        String nomeNoivo = pessoaDAO.getNomePessoa(0).split(" ")[0];
        String nomeNoiva = pessoaDAO.getNomePessoa(1).split(" ")[0];

        //PROCRUAR FAMILIA CONVIDADA
        ConvidadoFamilia familia = convidadoFamiliaDAO.buscarFamiliaPorNome(nomeFamilia);
        String acesso = convidadoFamiliaDAO.buscarAcessoPorFamilia(familia);

        if (familia != null) {
            System.out.println("\n---------------------- CONVITE DE CASAMENTO ----------------------");
            System.out.println("\nCasamento de " + nomeNoivo + " e " + nomeNoiva);
            System.out.printf ("\nQuerida FamIlia %s,\n", familia.getNome());
            System.out.println("\nConvidamos voces a participarem da nossa Celebracao de Casamento!!");
            System.out.println("\nEsperamos voces la!");
            System.out.println("\n\nO codigo de acesso de voces eh: " + acesso);
            System.out.println("------------------------------------------------------------------\n");
        } else {
            System.out.println("A familia não está na lista de convidados.");
        }
    }
    
    
    //EXCLUSÕES
    private boolean excluirPessoa(){
        System.out.println("Qual o id da pessoa que deseja excluir?");
        long idPessoa = scanner.nextLong();
        if(idPessoa == 0 || idPessoa == 1){
            System.out.println("\nNao eh possivel excluir a pessoa noivo ou noiva");
            return false;
        }
        //VERIFICAR SE EXISTE CONVITE INDIVIDUAL PARA ESSA PESSOA E EXCLUIR
        if(this.convidadoIndividualDAO.buscaPorId(idPessoa)){
            this.convidadoIndividualDAO.removerPorIdPessoa(idPessoa);
            System.out.println("Convite da pessoa excluído");
        }
        
        //VERIFICAR SE EXISTE USUÁRIO COM O ID DESSA PESSOA
        if(this.usuarioDAO.buscarPorPessoaId(idPessoa)){
            this.usuarioDAO.removerPorIdPessoa(idPessoa);
            System.out.println("Usuário da pessoa excluído");
        }
        
        //
        return pessoaDAO.remover(idPessoa);
    }
    
    private boolean excluirUsuario() {
        System.out.println("\n Qual o id do usuario que deseja excluir: ");
        long idUsuario = scanner.nextLong();
        scanner.nextLine();
        
        //VERIFICA SE NAO SAO O NOIVO OU NOIVA
        if(idUsuario == 0 || idUsuario == 1){
            System.out.println("\n Nao eh possivel excluir o usuario noivo ou noiva");
            return false;
        }
         //VERIFICAR SE EXISTE CONVITE INDIVIDUAL PARA ESSA PESSOA E EXCLUIR
        else if (this.convidadoIndividualDAO.buscaPorId(idUsuario)){
            this.convidadoIndividualDAO.removerPorIdPessoa(idUsuario);
            System.out.println("\n Convite da pessoa excluido");
        }
        
        return usuarioDAO.removerPorIdPessoa(idUsuario);
    }
    
    private boolean excluirConviteIndividual() {
        System.out.println("\n Qual o ID do convite individual que deseja excluir: ");
        long idConvite = scanner.nextLong();
        scanner.nextLine();

        // Verificar se o convite existe antes de tentar excluir
        if (convidadoIndividualDAO.buscaPorId(idConvite)) {
            if (convidadoIndividualDAO.remover(idConvite)) {
                System.out.println("\n Convite individual ("+ idConvite + ") excluido");
                return true;
            } else {
                System.out.println("\n Erro ao excluir o convite individual.");
                return false;
            }
        } else {
            System.out.println("\n Convite individual não encontrado.");
            return false;
        }
    }
    
  
    
    private boolean excluirConviteFamilia() {
        System.out.println("\n Qual o ID do convite familia que deseja excluir?");
        long idFamilia = scanner.nextLong();

        if (convidadoFamiliaDAO.buscarPorId(idFamilia)) {
           //EXCLUIR TODOS DA FAMILIA
            if (convidadoIndividualDAO.removerPorFamiliaId(idFamilia)) {
                System.out.println("\n Todos os convites individuais da familia foram excluidos.");
            } else {
                System.out.println("\n Erro ao excluir os convites individuais associados à família.");
            }

            //EXCLUIR CONVITE DA FAMILIA
            if (convidadoFamiliaDAO.remover(idFamilia)) {
                System.out.println("\n Convite da familia excluido com sucesso.");
                return true;
            } else {
                System.out.println("\n Erro ao excluir o convite da familia.");
                return false;
            } 
        } else {
            System.out.println("\n Família NAO encontrada.");
            return false;
        }
    }

    private boolean excluirFornecedor(){
        System.out.println("Qual o id do fornecedor que deseja excluir?");
        long idFornecedor = scanner.nextLong();
        if(fornecedorDAO.buscarPorId(idFornecedor)){
            //APAGAR OS PAGAMENTOS LINKADOS AO FORNECEDOR
            PagamentoDAO pTemporario = fornecedorDAO.removerPagamentos(idFornecedor);
            if(pTemporario != null){
                int tamanho = pTemporario.getPagamentos().size();
                int i = 0;
                while(i < tamanho-1){
                    long idTemporario = pTemporario.getPagamentos().get(i).getId();
                    
                }
            }
            return fornecedorDAO.removerPorId(idFornecedor);
        }
        else{
            return false;
        }
    }
    
    private boolean excluirPresente() {
        System.out.println("\n Qual o id do presente que deseja excluir: ");
        long idPresente = scanner.nextLong();
        scanner.nextLine();

        if (presenteDAO.removerPresente(idPresente)) {
            System.out.println("\n Presente excluido.");
            return true;
        }

        System.out.println("\n Presente nao encontrado.");
        return false;
    }
    
    private boolean excluirRecado() {
        System.out.println("\n Qual o id do recado que deseja excluir: ");
        long idRecado = scanner.nextLong();
        scanner.nextLine();

        if (recadoDAO.remover(idRecado)) {
            System.out.println("\n Recado excluido.");
            return true;
        }

        System.out.println("\n Recado nao encontrado.");
        return false;
    }


    


public void gerarRelatorioConvidadosConfirmados() {
        
    double totalPontos = 0;
    totalPontos = convidadoIndividualDAO.mostrarConfirmados(totalPontos);

    // LISTAR FORNECEDORES
    ArrayList<Fornecedor> fornecedores = fornecedorDAO.getFornecedores();  // Acessa o ArrayList diretamente
    for (Fornecedor f : fornecedores) {
        if (f != null) {
            double pontosFornecedor = 0.5;
            System.out.println("FORNECEDOR: " + f.getNome() + " | Pontos: " + pontosFornecedor);
            totalPontos += pontosFornecedor;
        }
    }

    System.out.printf("\nPONTUACAO TOTAL: %.1f%n", totalPontos);
}

    

    
}
