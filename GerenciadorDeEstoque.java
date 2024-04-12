import java.util.Scanner;

public class GerenciadorDeEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] estoque = new Produto[100]; // Capacidade máxima do estoque

        int opcao;
        int contadorProdutos = 0;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar novo produto");
            System.out.println("2. Atualizar preço ou quantidade em estoque de um produto");
            System.out.println("3. Exibir detalhes de um produto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade em estoque: ");
                    int quantidadeEmEstoque = scanner.nextInt();

                    estoque[contadorProdutos] = new Produto(nome, preco, quantidadeEmEstoque);
                    contadorProdutos++;
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    if (contadorProdutos == 0) {
                        System.out.println("Nenhum produto cadastrado!");
                        break;
                    }

                    System.out.print("Digite o índice do produto que deseja atualizar: ");
                    int indice = scanner.nextInt();
                    if (indice < 0 || indice >= contadorProdutos) {
                        System.out.println("Índice inválido!");
                        break;
                    }

                    System.out.println("1. Atualizar preço");
                    System.out.println("2. Atualizar quantidade em estoque");
                    System.out.print("Escolha uma opção: ");
                    int escolha = scanner.nextInt();

                    if (escolha == 1) {
                        System.out.print("Novo preço: ");
                        double novoPreco = scanner.nextDouble();
                        estoque[indice].setPreco(novoPreco);
                        System.out.println("Preço atualizado com sucesso!");
                    } else if (escolha == 2) {
                        System.out.print("Nova quantidade em estoque: ");
                        int novaQuantidade = scanner.nextInt();
                        estoque[indice].setQuantidadeEmEstoque(novaQuantidade);
                        System.out.println("Quantidade em estoque atualizada com sucesso!");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 3:
                    if (contadorProdutos == 0) {
                        System.out.println("Nenhum produto cadastrado!");
                        break;
                    }

                    System.out.print("Digite o índice do produto que deseja exibir: ");
                    int indiceExibicao = scanner.nextInt();
                    if (indiceExibicao < 0 || indiceExibicao >= contadorProdutos) {
                        System.out.println("Índice inválido!");
                        break;
                    }

                    Produto produtoExibicao = estoque[indiceExibicao];
                    System.out.println("\nDetalhes do Produto:");
                    System.out.println("Nome: " + produtoExibicao.getNome());
                    System.out.println("Preço: R$" + produtoExibicao.getPreco());
                    System.out.println("Quantidade em estoque: " + produtoExibicao.getQuantidadeEmEstoque());
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}