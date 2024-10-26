/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    Evento evento = new Evento();
    int contNoivo = 0;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Calendario calendario = new Calendario();
    public GerenciadorDeCasamento() {
        
        System.out.println("CRIACAO DO NOIVO...");
        Pessoa noivo = this.criarPessoa();
        System.out.println("Qual o login do Noivo?");
        String loginNoivo = scanner.nextLine();
        System.out.println("Qual a senha do Noivo?");
        String senhaNoivo = scanner.nextLine();
        Usuario usuarioNoivo = new Usuario(noivo, loginNoivo, senhaNoivo);
        usuarioDAO.adiciona(usuarioNoivo);
        
        System.out.println("\n\nCRIACAO DA NOIVA...");
        Pessoa noiva = this.criarPessoa();
        System.out.println("Qual o login do Noiva?");
        String loginNoiva = scanner.nextLine();
        System.out.println("Qual a senha do Noiva?");
        String senhaNoiva = scanner.nextLine();
        Usuario usuarioNoiva = new Usuario(noiva, loginNoiva, senhaNoiva);
        usuarioDAO.adiciona(usuarioNoiva);
        
        int opcaoUsuario = 7;
        
        do {
            opcaoUsuario = this.menuInicial();
            
            switch (opcaoUsuario) {
                case 1:
                    System.out.println("\n\n Voce escolheu: 1 - LOGAR \n");
                    Usuario logado = this.verificarUsuarioLogado();
                    //LOGADO COMO NOIVO OU CERIMONIALISTA
                    if (logado != null && (logado.getTipo().equals("N") || logado.getTipo().equals("CE") )) {                 
                        int opcaoLogadoNoivo = 10;
                        
                        do {
                            opcaoLogadoNoivo = this.menuLogadoNoivo();
                            
                            switch (opcaoLogadoNoivo) {
                                case 1:
                                    System.out.println("\n\n Voce escolheu: 1 - CADASTRAR PESSOA \n");
                                    Pessoa pessoaTemporariaLogado = this.criarPessoa();
                                    break;
                                case 2:
                                    System.out.println("\n\n Voce escolheu: 2 - CADASTRAR USUARIO \n");
                                    Usuario usuarioTemporarioLogado = this.criarUsuario();
                                    break;
                                case 3:
                                    System.out.println("\n\n Voce escolheu: 3 - CADASTRAR FORNECEDOR \n");
                                    Fornecedor fornecedorTemporarioLogado = this.criarFornecedor();
                                    break;
                                case 4:
                                    System.out.println("\n\n Voce escolheu: 4 - CADASTRAR EVENTO \n");
                                    this.criarEvento();
                                    break;
                                case 5:
                                    System.out.println("\n\n Voce escolheu: 5 - CADASTRAR CONVITES \n");
                                    ConvidadoIndividual conviteTemporarioLogado = this.criarConvite();
                                    break;
                                case 6:
                                    System.out.println("\n\n Voce escolheu: 6 - CADASTRAR PRESENTES \n");
                                    //Presente presenteTemporarioLogado = this.criarPresente();
                                    break;
                                case 7:
                                    System.out.println("\n\n Voce escolheu: 7 - CADASTRAR PAGAMENTOS \n");
                                    Pagamento pagamentoTemporarioLogado = this.criarPagamento();
                                    break;
                                /*case 8:
                                    System.out.println("\n\n Voce escolheu: 8 - CADASTRAR CERIMONIALISTA \n");
                                    Cerimonialista cerimonialistaTemporarioLogado = this.criarCerimonialista();
                                    break;
                                case 9:
                                    System.out.println("\n\n Voce escolheu: 9 - CADASTRAR IGREJA \n");
                                    Igreja pagamentoTemporarioLogado = this.criarPagamento();
                                    break;
                                case 10:
                                    System.out.println("\n\n Voce escolheu: 10 - CADASTRAR CARTORIO \n");
                                    Pagamento pagamentoTemporarioLogado = this.criarPagamento();
                                    break;*/
                                default:
                                    System.out.println("\n\n Opcao Invalida! Tente Novamente!");
                                    break;
                            }
                        }while (opcaoLogadoNoivo != 11);
                        
                    } else {
                        //LOGADO COMO OUTRO
                        if (logado != null && logado.getTipo().equals("CO")) {
                            int opcaoLogadoOutro = 1;
                            
                            do {
                                //CONFIRMAR PRESENCA
                                opcaoLogadoOutro = this.menuLogadoOutro();
                                switch (opcaoLogadoOutro) {
                                    case 1:
                                        System.out.println("\n\n Voce CONFIRMOU sua presenca!");
                                        // FAZER A LOGICA AQUI
                                        break;
                                    case 2:
                                        System.out.println("\n\n Voce NAO vai ao evento!");
                                        // FAZER A LOGICA AQUI
                                        break;
                                    default:
                                        System.out.println("\n\n Caracter Invalido! Tente Novamente!");
                                }
                            }while (opcaoLogadoOutro !=3);
                        }
                        else {
                            System.out.println("\n\n Usuario NAO encontrado!");
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
                            //Presente presenteTemporarioLogado = this.criarPresente();
                            break;
                        case 2:
                            System.out.println("\n\n Voce escolheu: 2 - CADASTRAR RECADO \n");
                            //Pagamento pagamentoTemporarioLogado = this.criarPagamento();
                            break;
                        default:
                            System.out.println("\n\n Caracter Invalido! Tente Novamente!");
                        }

                    } while (opcaoEntrarSemLogar != 3);
                    break;
                case 3:
                    System.out.println("\n\n Voce escolheu: 3 - CADASTRAR PESSOA \n");
                    Pessoa temporaria = this.criarPessoa();
                    break;   
                case 4:
                    System.out.println("\n\n Voce escolheu: 4 - CADASTRAR USUARIO \n");
                    Usuario temporario = this.criarUsuario();
                    break; 
                default:
                    System.out.println("\n\n Opcao Invalida! Tente Novamente!");
                    break;
            }
        }while (opcaoUsuario != 5);
    }
    
    public static void main(String[] args) {
        
        GerenciadorDeCasamento g = new GerenciadorDeCasamento();
        
    }
    
    public int menuInicial() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\nSEJA BEM VINDO AO GERENCIADOR DE CASAMENTO\n\n");
        builder.append("\n1 - LOGAR..................................");
        builder.append("\n2 - ENTRAR SEM LOGAR.......................");
        builder.append("\n3 - CADASTRAR PESSOA.......................");
        builder.append("\n4 - CADASTRAR USUARIO......................");
        builder.append("\n5 - SAIR...................................");
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
            System.out.println("\nPessoa Adcionada! \n\n");
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
                System.out.print("Informe o tipo de usuario [N - noivo(a), CE - cerimonialista, CO - Convidado]: ");
                tipo = scanner.nextLine().toUpperCase();
            } while (!tipo.equals("N") && !tipo.equals("CE") && !tipo.equals("CO"));
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
        builder.append("\n1 - CADASTRAR PESSOA..................");
        builder.append("\n2 - CADASTRAR USUARIO.................");
        builder.append("\n3 - CADASTRAR FORNECEDOR..............");
        builder.append("\n4 - CADASTRAR EVENTO..................");
        builder.append("\n5 - CADASTRAR CONVITES................");
        builder.append("\n6 - CADASTRAR PRESENTES...............");
        builder.append("\n7 - CADASTRAR PAGAMENTOS..............");
        builder.append("\n8 - CADASTRAR CERIMONIAL..............");
        builder.append("\n9 - CADASTRAR IGREJA..................");
        builder.append("\n10 - CADASTRAR CARTORIO...............");
        builder.append("\n11 - SAIR...........................\n");
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
        builder.append("\n1 - CADASTRAR PRESENTES......");
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

    private Fornecedor criarFornecedor() {
        
        Fornecedor f = new Fornecedor();
        
        //RECEBENDO ATRIBUTOS
        //NOME
        System.out.println("\n Qual o nome do fornecedor: ");
        f.setNome(scanner.nextLine());
        //CNPJ
        System.out.println("\n Qual o CNPJ do fornecedor: ");
        String cnpj = scanner.nextLine();
        while (!validarCnpj(cnpj)) {
            System.out.println("Esse CNPJ eh invalido. Deve haver 14 digitos. Tente Novamente: ");
            cnpj = scanner.nextLine();
        }
        f.setCnpj(cnpj);
        //TELEFONE
        System.out.println("\n Qual o telefone do fornecedor (xx-xxxxx-xxxx):");
        String telefone = scanner.nextLine();
        while (!validarTelefone(telefone)) {
            System.out.println("Esse telefone eh inválido. Tente novamente no seguinte formato (xx-xxxxx-xxxx): ");
            telefone = scanner.nextLine();
        }
        f.setTelefone(telefone);
        
        
        /*
        //VALOR A PAGAR
        System.out.println("\n Qual o valor a pagar: ");
        f.setValorAPagar(scanner.nextInt());
        //PARCELAS
        System.out.println("\n Esse valor vai ser pago em quantas parcelas: ");
        f.setParcelas(scanner.nextInt());
        */
        //ESTADO
        System.out.println("\n Qual o estado do pagamento? (pago ou em pagamento):");
        String estado = scanner.nextLine().toLowerCase();
        while (!estado.equals("pago") && !estado.equals("em pagamento")) {
            System.out.println("\n Invalido! Insira 'pago' ou 'em pagamento':");
            estado = scanner.nextLine().toLowerCase();
        }
        f.setEstado(estado);
        
        f.setPagamento(criarPagamento()); 
        return f;
    }
    
    private void criarEvento(){
        System.out.println("Qual o nome do cartório?");
        Cartorio cartorio = new Cartorio(scanner.nextLine());
        this.evento.setCartorio(cartorio);
        
        System.out.println("Qual o nome da Igreja?");
        Igreja igreja = new Igreja(scanner.nextLine());
        this.evento.setIgreja(igreja);
        
        System.out.println("Qual o nome do Cerimonial?");
        Cerimonial cerimonial = new Cerimonial(scanner.nextLine());
        this.evento.setCerimonial(cerimonial);
        
        this.evento.setNoivo(usuarioDAO.usuarios[0].getPessoa());
        this.evento.setNoiva(usuarioDAO.usuarios[1].getPessoa());
        System.out.println(this.evento);
    }
    
    private Pagamento criarPagamento(){
        System.out.println("O que sera pago?");
        String descricao = scanner.nextLine();
        //perguntar primeiro o valor da parcela para já inserir todas de uma vez no calendário
        System.out.println("Sao quantas parcelas?");
        Parcela parcelas = new Parcelas()
        int parcelas = scanner.nextInt();
        
        System.out.println("Qual o valor de cada parcela? Se for unica, qual o valor da parcela unica?");
        double valorParcela = scanner.nextDouble();
        Pessoa pessoa = null;
        do{
            System.out.println("Qual o id da pessoa a pagar?");
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
            Pagamento pagamentoTemporario = new Pagamento(pessoa, descricao, valorParcela, parcelas)
            inserirNoCalendario();
        }while(parcelaAtual < parcelas);
        Pagamento pagamento = new Pagamento();
    }
        
    private void inserirNoCalendario(){
        this.calendario.adiciona()
    }
    private boolean validarCnpj(String cnpj) {
        return cnpj != null && cnpj.matches("\\d{14}");
    }
    
    private boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d{2}-\\d{5}-\\d{4}");
    }
    
    private ConvidadoIndividual criarConvite(){
        
    }
    
}
