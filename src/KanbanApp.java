import java.util.ArrayList;
import java.util.Scanner;

public class KanbanApp {
    private static ArrayList<Quadro> quadros = new ArrayList<>();
    private static int contadorIdQuadro = 1;
    private static int contadorIdLista = 1;
    private static int contadorIdCartao = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nKanban App");
            System.out.println("1. Criar Quadro");
            System.out.println("2. Ler Quadros");
            System.out.println("3. Editar Quadro");
            System.out.println("4. Remover Quadro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    criarQuadro();
                    break;
                case 2:
                    lerQuadros();
                    break;
                case 3:
                    editarQuadro();
                    break;
                case 4:
                    removerQuadro();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void criarQuadro() {
        System.out.print("Digite o nome do quadro: ");
        String nome = scanner.nextLine();

        Quadro quadro = new Quadro(contadorIdQuadro++, nome);
        quadros.add(quadro);
        System.out.println("Quadro criado com sucesso.");
        gerenciarListas(quadro);
    }

    private static void lerQuadros() {
        System.out.println("\nQuadros:");
        for (Quadro quadro : quadros) {
            System.out.println(quadro.getId() + ". " + quadro.getNome());
            for (Lista lista : quadro.getListas()) {
                System.out.println("  " + lista.getId() + ". " + lista.getNome() + ":");
                for (Cartao cartao : lista.getCartoes()) {
                    System.out.println("    " + cartao.getId() + ". " + cartao.getNome() + " (Status: " + cartao.getStatus() + ")");
                }
            }
        }
    }

    private static void editarQuadro() {
        lerQuadros();
        System.out.print("Digite o número do quadro para editar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= quadros.size()) {
            Quadro quadroParaEditar = quadros.get(escolha - 1);
            System.out.println("1. Editar Nome do Quadro");
            System.out.println("2. Gerenciar Listas");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome do quadro: ");
                    String novoNome = scanner.nextLine();
                    quadroParaEditar.setNome(novoNome);
                    System.out.println("Quadro editado com sucesso.");
                    break;
                case 2:
                    gerenciarListas(quadroParaEditar);
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void removerQuadro() {
        lerQuadros();
        System.out.print("Digite o número do quadro para remover: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= quadros.size()) {
            quadros.remove(escolha - 1);
            System.out.println("Quadro removido com sucesso.");
        }
    }

    private static void gerenciarListas(Quadro quadro) {
        while (true) {
            System.out.println("\nGerenciando Listas do Quadro: " + quadro.getNome());
            System.out.println("1. Criar Lista");
            System.out.println("2. Ler Listas");
            System.out.println("3. Editar Lista");
            System.out.println("4. Remover Lista");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    criarLista(quadro);
                    break;
                case 2:
                    lerListas(quadro);
                    break;
                case 3:
                    editarLista(quadro);
                    break;
                case 4:
                    removerLista(quadro);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void criarLista(Quadro quadro) {
        System.out.print("Digite o nome da lista: ");
        String nome = scanner.nextLine();

        Lista lista = new Lista(contadorIdLista++, nome);
        quadro.getListas().add(lista);
        System.out.println("Lista criada com sucesso.");
        gerenciarCartoes(lista);
    }

    private static void lerListas(Quadro quadro) {
        System.out.println("\nListas no Quadro: " + quadro.getNome());
        for (Lista lista : quadro.getListas()) {
            System.out.println(lista.getId() + ". " + lista.getNome() + ":");
            for (Cartao cartao : lista.getCartoes()) {
                System.out.println("  " + cartao.getId() + ". " + cartao.getNome() + " (Status: " + cartao.getStatus() + ")");
            }
        }
    }

    private static void editarLista(Quadro quadro) {
        lerListas(quadro);
        System.out.print("Digite o número da lista para editar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= quadro.getListas().size()) {
            Lista listaParaEditar = quadro.getListas().get(escolha - 1);
            System.out.println("1. Editar Nome da Lista");
            System.out.println("2. Gerenciar Cartões");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome da lista: ");
                    String novoNome = scanner.nextLine();
                    listaParaEditar.setNome(novoNome);
                    System.out.println("Lista editada com sucesso.");
                    break;
                case 2:
                    gerenciarCartoes(listaParaEditar);
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void removerLista(Quadro quadro) {
        lerListas(quadro);
        System.out.print("Digite o número da lista para remover: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= quadro.getListas().size()) {
            quadro.getListas().remove(escolha - 1);
            System.out.println("Lista removida com sucesso.");
        }
    }

    private static void gerenciarCartoes(Lista lista) {
        while (true) {
            System.out.println("\nGerenciando Cartões da Lista: " + lista.getNome());
            System.out.println("1. Criar Cartão");
            System.out.println("2. Ler Cartões");
            System.out.println("3. Editar Cartão");
            System.out.println("4. Remover Cartão");
            System.out.println("5. Voltar ao Menu de Listas");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    criarCartao(lista);
                    break;
                case 2:
                    lerCartoes(lista);
                    break;
                case 3:
                    editarCartao(lista);
                    break;
                case 4:
                    removerCartao(lista);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void criarCartao(Lista lista) {
        System.out.print("Digite o nome do cartão: ");
        String nome = scanner.nextLine();

        Cartao cartao = new Cartao(contadorIdCartao++, nome, StatusCartao.A_FAZER);
        lista.getCartoes().add(cartao);
        System.out.println("Cartão criado com sucesso.");
    }

    private static void lerCartoes(Lista lista) {
        System.out.println("\nCartões na Lista: " + lista.getNome());
        for (Cartao cartao : lista.getCartoes()) {
            System.out.println(cartao.getId() + ". " + cartao.getNome() + " (Status: " + cartao.getStatus() + ")");
        }
    }

    private static void editarCartao(Lista lista) {
        lerCartoes(lista);
        System.out.print("Digite o número do cartão para editar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= lista.getCartoes().size()) {
            Cartao cartaoParaEditar = lista.getCartoes().get(escolha - 1);
            System.out.print("Digite o novo nome do cartão: ");
            String novoNome = scanner.nextLine();
            cartaoParaEditar.setNome(novoNome);
            System.out.println("Cartão editado com sucesso.");
        }
    }

    private static void removerCartao(Lista lista) {
        lerCartoes(lista);
        System.out.print("Digite o número do cartão para remover: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolha > 0 && escolha <= lista.getCartoes().size()) {
            lista.getCartoes().remove(escolha - 1);
            System.out.println("Cartão removido com sucesso.");
        }
    }
}