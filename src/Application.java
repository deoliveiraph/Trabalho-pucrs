import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroBarcos cadastroBarcos = new CadastroBarcos();
        Passeio passeio = null;

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 – Incluir barco");
            System.out.println("2 – Remover barco");
            System.out.println("3 – Mostrar barcos");
            System.out.println("4 – Pesquisar e mostrar barco por nome");
            System.out.println("5 – Criar passeio");
            System.out.println("6 – Mostrar passeio");
            System.out.println("7 – Adicionar passageiro no passeio");
            System.out.println("8 – Remover passageiro do passeio");
            System.out.println("9 – Quantidade de passageiros por profissão");
            System.out.println("10 – Valor total arrecadado pelo passeio");
            System.out.println("11 – Sair do programa");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do barco:");
                    String nomeBarco = scanner.nextLine();
                    System.out.println("Código do barco:");
                    int codigoBarco = scanner.nextInt();
                    System.out.println("Lotação do barco:");
                    int lotacaoBarco = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Barcos barco = new Barcos();
                    barco.setNome(nomeBarco);
                    barco.setCodigo(codigoBarco);
                    barco.setLotacao(lotacaoBarco);
                    if (cadastroBarcos.adicionaBarco(barco)) {
                        System.out.println("Barco adicionado com sucesso.");
                    } else {
                        System.out.println("Não foi possível adicionar o barco.");
                    }
                    break;
                case 2:
                    System.out.println("Nome do barco a remover:");
                    String nomeRemover = scanner.nextLine();
                    if (cadastroBarcos.removeBarco(nomeRemover)) {
                        System.out.println("Barco removido com sucesso.");
                    } else {
                        System.out.println("Não foi possível remover o barco.");
                    }
                    break;
                case 3:
                    cadastroBarcos.mostraBarcos();
                    break;
                case 4:
                    System.out.println("Nome do barco a pesquisar:");
                    String nomePesquisar = scanner.nextLine();
                    Barcos barcoEncontrado = cadastroBarcos.buscaBarcoNome(nomePesquisar);
                    if (barcoEncontrado != null) {
                        System.out.println("Barco encontrado: Nome: " + barcoEncontrado.getNome() + ", Código: " + barcoEncontrado.getCodigo() + ", Lotação: " + barcoEncontrado.getLotacao());
                    } else {
                        System.out.println("Barco não encontrado.");
                    }
                    break;
                case 5:
                    if (passeio != null) {
                        System.out.println("Já existe um passeio criado.");
                    } else {
                        System.out.println("Nome do barco para o passeio:");
                        String nomeBarcoPasseio = scanner.nextLine();
                        Barcos barcoParaPasseio = cadastroBarcos.buscaBarcoNome(nomeBarcoPasseio);
                        if (barcoParaPasseio != null) {
                            System.out.println("Valor do bilhete:");
                            double valorBilhete = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha
                            passeio = new Passeio(barcoParaPasseio, valorBilhete);
                            System.out.println("Passeio criado com sucesso.");
                        } else {
                            System.out.println("Barco não encontrado no cadastro.");
                        }
                    }
                    break;
                case 6:
                    if (passeio != null) {
                        passeio.mostraPasseio();
                    } else {
                        System.out.println("Nenhum passeio criado.");
                    }
                    break;
                case 7:
                    if (passeio != null) {
                        System.out.println("Nome do passageiro:");
                        String nomePassageiro = scanner.nextLine();
                        System.out.println("Idade do passageiro:");
                        int idadePassageiro = scanner.nextInt();
                        System.out.println("Profissão do passageiro:");
                        scanner.nextLine(); // Consumir a nova linha
                        String profissaoPassageiro = scanner.nextLine();
                        Passageiro passageiro = new Passageiro(nomePassageiro, idadePassageiro, profissaoPassageiro);
                        if (passeio.adicionaPassageiro(passageiro)) {
                            System.out.println("Passageiro adicionado com sucesso.");
                        } else {
                            System.out.println("Não foi possível adicionar o passageiro.");
                        }
                    } else {
                        System.out.println("Nenhum passeio criado.");
                    }
                    break;
                case 8:
                    if (passeio != null) {
                        System.out.println("Nome do passageiro a remover:");
                        String nomePassageiroRemover = scanner.nextLine();
                        if (passeio.removePassageiro(nomePassageiroRemover)) {
                            System.out.println("Passageiro removido com sucesso.");
                        } else {
                            System.out.println("Não foi possível remover o passageiro.");
                        }
                    } else {
                        System.out.println("Nenhum passeio criado.");
                    }
                    break;
                case 9:
                    if (passeio != null) {
                        System.out.println("Profissão a pesquisar:");
                        String profissaoPesquisar = scanner.nextLine();
                        int quantidade = passeio.buscaPasProfissao(profissaoPesquisar);
                        System.out.println("Quantidade de passageiros com a profissão " + profissaoPesquisar + ": " + quantidade);
                    } else {
                        System.out.println("Nenhum passeio criado.");
                    }
                    break;
                case 10:
                    if (passeio != null) {
                        double valorTotal = passeio.buscaValorPasseio();
                        System.out.println("Valor total arrecadado pelo passeio: " + valorTotal);
                    } else {
                        System.out.println("Nenhum passeio criado.");
                    }
                    break;
                case 11:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}