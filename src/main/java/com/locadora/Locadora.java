package com.locadora;

import com.locadora.dao.*;
import com.locadora.model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Locadora {
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static FilmeDAO filmeDAO = new FilmeDAO();
    private static AtorDAO atorDAO = new AtorDAO();
    private static EnderecoDAO enderecoDAO = new EnderecoDAO();
    private static GeneroDAO generoDAO = new GeneroDAO();
    private static CategoriaDAO categoriaDAO = new CategoriaDAO();
    private static DependenteDAO dependenteDAO = new DependenteDAO();
    private static LocacaoDAO locacaoDAO = new LocacaoDAO();
    private static ProfissaoDAO profissaoDAO = new ProfissaoDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Locadora de Filmes");
            System.out.println("1. Cliente");
            System.out.println("2. Filme");
            System.out.println("3. Ator");
            System.out.println("4. Endereço");
            System.out.println("5. Gênero");
            System.out.println("6. Categoria");
            System.out.println("7. Dependente");
            System.out.println("8. Locação");
            System.out.println("9. Profissão");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    menuCliente(scanner);
                    break;
                case 2:
                    menuFilme(scanner);
                    break;
                case 3:
                    menuAtor(scanner);
                    break;
                case 4:
                    menuEndereco(scanner);
                    break;
                case 5:
                    menuGenero(scanner);
                    break;
                case 6:
                    menuCategoria(scanner);
                    break;
                case 7:
                    menuDependente(scanner);
                    break;
                case 8:
                    menuLocacao(scanner);
                    break;
                case 9:
                    menuProfissao(scanner);
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 10);

        scanner.close();
    }

    private static void menuCliente(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Cliente");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addCliente(scanner);
                    break;
                case 2:
                    listClientes();
                    break;
                case 3:
                    updateCliente(scanner);
                    break;
                case 4:
                    deleteCliente(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addCliente(Scanner scanner) {
        try {
            Cliente cliente = new Cliente();
            System.out.print("Digite o código do cliente: ");
            cliente.setCod_cli(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o CPF: ");
            cliente.setCpf(scanner.nextLine());

            System.out.print("Digite o nome: ");
            cliente.setNome(scanner.nextLine());

            System.out.print("Digite o telefone: ");
            cliente.setTelefone(scanner.nextLine());

            System.out.print("Digite o código da profissão: ");
            cliente.setCod_prof(scanner.nextInt());

            clienteDAO.addCliente(cliente);
            System.out.println("Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    private static void listClientes() {
        try {
            List<Cliente> clientes = clienteDAO.getAllClientes();
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getCod_cli() +
                        ", Nome: " + cliente.getNome() +
                        ", CPF: " + cliente.getCpf() +
                        ", Telefone: " + cliente.getTelefone() +
                        ", Profissão: " + cliente.getCod_prof());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    private static void updateCliente(Scanner scanner) {
        try {
            Cliente cliente = new Cliente();
            System.out.print("Digite o código do cliente a ser atualizado: ");
            cliente.setCod_cli(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo CPF: ");
            cliente.setCpf(scanner.nextLine());

            System.out.print("Digite o novo nome: ");
            cliente.setNome(scanner.nextLine());

            System.out.print("Digite o novo telefone: ");
            cliente.setTelefone(scanner.nextLine());

            System.out.print("Digite o novo código da profissão: ");
            cliente.setCod_prof(scanner.nextInt());

            clienteDAO.updateCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    private static void deleteCliente(Scanner scanner) {
        try {
            System.out.print("Digite o código do cliente a ser deletado: ");
            int codCli = scanner.nextInt();
            clienteDAO.deleteCliente(codCli);
            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }

    private static void menuFilme(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Filme");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Listar Filmes");
            System.out.println("3. Atualizar Filme");
            System.out.println("4. Deletar Filme");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addFilme(scanner);
                    break;
                case 2:
                    listFilmes();
                    break;
                case 3:
                    updateFilme(scanner);
                    break;
                case 4:
                    deleteFilme(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addFilme(Scanner scanner) {
        try {
            Filme filme = new Filme();
            System.out.print("Digite o código do filme: ");
            filme.setCod_filme(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o título original: ");
            filme.setTitulo_original(scanner.nextLine());

            System.out.print("Digite o título: ");
            filme.setTitulo(scanner.nextLine());

            System.out.print("Digite a quantidade: ");
            filme.setQuantidade(scanner.nextInt());

            System.out.print("Digite o código da categoria: ");
            filme.setCod_cat(scanner.nextInt());

            System.out.print("Digite o código do gênero: ");
            filme.setCod_gen(scanner.nextInt());

            filmeDAO.addFilme(filme);
            System.out.println("Filme adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar filme: " + e.getMessage());
        }
    }

    private static void listFilmes() {
        try {
            List<Filme> filmes = filmeDAO.getAllFilmes();
            for (Filme filme : filmes) {
                System.out.println("ID: " + filme.getCod_filme() +
                        ", Título Original: " + filme.getTitulo_original() +
                        ", Título: " + filme.getTitulo() +
                        ", Quantidade: " + filme.getQuantidade() +
                        ", Categoria: " + filme.getCod_cat() +
                        ", Gênero: " + filme.getCod_gen());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar filmes: " + e.getMessage());
        }
    }

    private static void updateFilme(Scanner scanner) {
        try {
            Filme filme = new Filme();
            System.out.print("Digite o código do filme a ser atualizado: ");
            filme.setCod_filme(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo título original: ");
            filme.setTitulo_original(scanner.nextLine());

            System.out.print("Digite o novo título: ");
            filme.setTitulo(scanner.nextLine());

            System.out.print("Digite a nova quantidade: ");
            filme.setQuantidade(scanner.nextInt());

            System.out.print("Digite o novo código da categoria: ");
            filme.setCod_cat(scanner.nextInt());

            System.out.print("Digite o novo código do gênero: ");
            filme.setCod_gen(scanner.nextInt());

            filmeDAO.updateFilme(filme);
            System.out.println("Filme atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar filme: " + e.getMessage());
        }
    }

    private static void deleteFilme(Scanner scanner) {
        try {
            System.out.print("Digite o código do filme a ser deletado: ");
            int codFilme = scanner.nextInt();
            filmeDAO.deleteFilme(codFilme);
            System.out.println("Filme deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar filme: " + e.getMessage());
        }
    }

    private static void menuAtor(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Ator");
            System.out.println("1. Adicionar Ator");
            System.out.println("2. Listar Atores");
            System.out.println("3. Atualizar Ator");
            System.out.println("4. Deletar Ator");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addAtor(scanner);
                    break;
                case 2:
                    listAtores();
                    break;
                case 3:
                    updateAtor(scanner);
                    break;
                case 4:
                    deleteAtor(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addAtor(Scanner scanner) {
        try {
            Ator ator = new Ator();
            System.out.print("Digite o código do ator: ");
            ator.setCod_ator(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o nome: ");
            ator.setNome(scanner.nextLine());

            atorDAO.addAtor(ator);
            System.out.println("Ator adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar ator: " + e.getMessage());
        }
    }

    private static void listAtores() {
        try {
            List<Ator> atores = atorDAO.getAllAtores();
            for (Ator ator : atores) {
                System.out.println("ID: " + ator.getCod_ator() +
                        ", Nome: " + ator.getNome());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar atores: " + e.getMessage());
        }
    }

    private static void updateAtor(Scanner scanner) {
        try {
            Ator ator = new Ator();
            System.out.print("Digite o código do ator a ser atualizado: ");
            ator.setCod_ator(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo nome: ");
            ator.setNome(scanner.nextLine());

            atorDAO.updateAtor(ator);
            System.out.println("Ator atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar ator: " + e.getMessage());
        }
    }

    private static void deleteAtor(Scanner scanner) {
        try {
            System.out.print("Digite o código do ator a ser deletado: ");
            int codAtor = scanner.nextInt();
            atorDAO.deleteAtor(codAtor);
            System.out.println("Ator deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar ator: " + e.getMessage());
        }
    }

    private static void menuEndereco(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Endereço");
            System.out.println("1. Adicionar Endereço");
            System.out.println("2. Listar Endereços");
            System.out.println("3. Atualizar Endereço");
            System.out.println("4. Deletar Endereço");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addEndereco(scanner);
                    break;
                case 2:
                    listEnderecos();
                    break;
                case 3:
                    updateEndereco(scanner);
                    break;
                case 4:
                    deleteEndereco(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addEndereco(Scanner scanner) {
        try {
            Endereco endereco = new Endereco();
            System.out.print("Digite o código do endereço: ");
            endereco.setCod_end(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o logradouro: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.print("Digite o tipo do logradouro: ");
            endereco.setTipo_log(scanner.nextLine());

            System.out.print("Digite o complemento: ");
            endereco.setComplemento(scanner.nextLine());

            System.out.print("Digite a cidade: ");
            endereco.setCidade(scanner.nextLine());

            System.out.print("Digite a UF: ");
            endereco.setUf(scanner.nextLine().charAt(0));

            System.out.print("Digite o CEP: ");
            endereco.setCep(scanner.nextLine());

            System.out.print("Digite o número: ");
            endereco.setNumero(scanner.nextLine());

            System.out.print("Digite o bairro: ");
            endereco.setBairro(scanner.nextLine());

            enderecoDAO.addEndereco(endereco);
            System.out.println("Endereço adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar endereço: " + e.getMessage());
        }
    }

    private static void listEnderecos() {
        try {
            List<Endereco> enderecos = enderecoDAO.getAllEnderecos();
            for (Endereco endereco : enderecos) {
                System.out.println("ID: " + endereco.getCod_end() +
                        ", Logradouro: " + endereco.getLogradouro() +
                        ", Tipo: " + endereco.getTipo_log() +
                        ", Complemento: " + endereco.getComplemento() +
                        ", Cidade: " + endereco.getCidade() +
                        ", UF: " + endereco.getUf() +
                        ", CEP: " + endereco.getCep() +
                        ", Número: " + endereco.getNumero() +
                        ", Bairro: " + endereco.getBairro());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar endereços: " + e.getMessage());
        }
    }

    private static void updateEndereco(Scanner scanner) {
        try {
            Endereco endereco = new Endereco();
            System.out.print("Digite o código do endereço a ser atualizado: ");
            endereco.setCod_end(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo logradouro: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.print("Digite o novo tipo do logradouro: ");
            endereco.setTipo_log(scanner.nextLine());

            System.out.print("Digite o novo complemento: ");
            endereco.setComplemento(scanner.nextLine());

            System.out.print("Digite a nova cidade: ");
            endereco.setCidade(scanner.nextLine());

            System.out.print("Digite a nova UF: ");
            endereco.setUf(scanner.nextLine().charAt(0));

            System.out.print("Digite o novo CEP: ");
            endereco.setCep(scanner.nextLine());

            System.out.print("Digite o novo número: ");
            endereco.setNumero(scanner.nextLine());

            System.out.print("Digite o novo bairro: ");
            endereco.setBairro(scanner.nextLine());

            enderecoDAO.updateEndereco(endereco);
            System.out.println("Endereço atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar endereço: " + e.getMessage());
        }
    }

    private static void deleteEndereco(Scanner scanner) {
        try {
            System.out.print("Digite o código do endereço a ser deletado: ");
            int codEnd = scanner.nextInt();
            enderecoDAO.deleteEndereco(codEnd);
            System.out.println("Endereço deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar endereço: " + e.getMessage());
        }
    }

    private static void menuGenero(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Gênero");
            System.out.println("1. Adicionar Gênero");
            System.out.println("2. Listar Gêneros");
            System.out.println("3. Atualizar Gênero");
            System.out.println("4. Deletar Gênero");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addGenero(scanner);
                    break;
                case 2:
                    listGeneros();
                    break;
                case 3:
                    updateGenero(scanner);
                    break;
                case 4:
                    deleteGenero(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addGenero(Scanner scanner) {
        try {
            Genero genero = new Genero();
            System.out.print("Digite o código do gênero: ");
            genero.setCod_gen(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o nome: ");
            genero.setNome(scanner.nextLine());

            generoDAO.addGenero(genero);
            System.out.println("Gênero adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar gênero: " + e.getMessage());
        }
    }

    private static void listGeneros() {
        try {
            List<Genero> generos = generoDAO.getAllGeneros();
            for (Genero genero : generos) {
                System.out.println("ID: " + genero.getCod_gen() +
                        ", Nome: " + genero.getNome());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar gêneros: " + e.getMessage());
        }
    }

    private static void updateGenero(Scanner scanner) {
        try {
            Genero genero = new Genero();
            System.out.print("Digite o código do gênero a ser atualizado: ");
            genero.setCod_gen(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo nome: ");
            genero.setNome(scanner.nextLine());

            generoDAO.updateGenero(genero);
            System.out.println("Gênero atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar gênero: " + e.getMessage());
        }
    }

    private static void deleteGenero(Scanner scanner) {
        try {
            System.out.print("Digite o código do gênero a ser deletado: ");
            int codGen = scanner.nextInt();
            generoDAO.deleteGenero(codGen);
            System.out.println("Gênero deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar gênero: " + e.getMessage());
        }
    }

    private static void menuCategoria(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Categoria");
            System.out.println("1. Adicionar Categoria");
            System.out.println("2. Listar Categorias");
            System.out.println("3. Atualizar Categoria");
            System.out.println("4. Deletar Categoria");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addCategoria(scanner);
                    break;
                case 2:
                    listCategorias();
                    break;
                case 3:
                    updateCategoria(scanner);
                    break;
                case 4:
                    deleteCategoria(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addCategoria(Scanner scanner) {
        try {
            Categoria categoria = new Categoria();
            System.out.print("Digite o código da categoria: ");
            categoria.setCod_cat(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o nome: ");
            categoria.setNome(scanner.nextLine());

            System.out.print("Digite o valor: ");
            categoria.setValor(scanner.nextDouble());

            categoriaDAO.addCategoria(categoria);
            System.out.println("Categoria adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar categoria: " + e.getMessage());
        }
    }

    private static void listCategorias() {
        try {
            List<Categoria> categorias = categoriaDAO.getAllCategorias();
            for (Categoria categoria : categorias) {
                System.out.println("ID: " + categoria.getCod_cat() +
                        ", Nome: " + categoria.getNome() +
                        ", Valor: " + categoria.getValor());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
        }
    }

    private static void updateCategoria(Scanner scanner) {
        try {
            Categoria categoria = new Categoria();
            System.out.print("Digite o código da categoria a ser atualizada: ");
            categoria.setCod_cat(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo nome: ");
            categoria.setNome(scanner.nextLine());

            System.out.print("Digite o novo valor: ");
            categoria.setValor(scanner.nextDouble());

            categoriaDAO.updateCategoria(categoria);
            System.out.println("Categoria atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar categoria: " + e.getMessage());
        }
    }

    private static void deleteCategoria(Scanner scanner) {
        try {
            System.out.print("Digite o código da categoria a ser deletada: ");
            int codCat = scanner.nextInt();
            categoriaDAO.deleteCategoria(codCat);
            System.out.println("Categoria deletada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar categoria: " + e.getMessage());
        }
    }

    private static void menuDependente(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Dependente");
            System.out.println("1. Adicionar Dependente");
            System.out.println("2. Listar Dependentes");
            System.out.println("3. Atualizar Dependente");
            System.out.println("4. Deletar Dependente");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addDependente(scanner);
                    break;
                case 2:
                    listDependentes();
                    break;
                case 3:
                    updateDependente(scanner);
                    break;
                case 4:
                    deleteDependente(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addDependente(Scanner scanner) {
        try {
            Dependente dependente = new Dependente();
            System.out.print("Digite o código do cliente: ");
            dependente.setCod_cli(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o código do dependente: ");
            dependente.setCod_dep(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o parentesco: ");
            dependente.setParentesco(scanner.nextLine());

            dependenteDAO.addDependente(dependente);
            System.out.println("Dependente adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar dependente: " + e.getMessage());
        }
    }

    private static void listDependentes() {
        try {
            List<Dependente> dependentes = dependenteDAO.getAllDependentes();
            for (Dependente dependente : dependentes) {
                System.out.println("Cliente ID: " + dependente.getCod_cli() +
                        ", Dependente ID: " + dependente.getCod_dep() +
                        ", Parentesco: " + dependente.getParentesco());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar dependentes: " + e.getMessage());
        }
    }

    private static void updateDependente(Scanner scanner) {
        try {
            Dependente dependente = new Dependente();
            System.out.print("Digite o código do cliente: ");
            dependente.setCod_cli(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o código do dependente a ser atualizado: ");
            dependente.setCod_dep(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo parentesco: ");
            dependente.setParentesco(scanner.nextLine());

            dependenteDAO.updateDependente(dependente);
            System.out.println("Dependente atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar dependente: " + e.getMessage());
        }
    }

    private static void deleteDependente(Scanner scanner) {
        try {
            System.out.print("Digite o código do cliente: ");
            int codCli = scanner.nextInt();
            System.out.print("Digite o código do dependente a ser deletado: ");
            int codDep = scanner.nextInt();
            dependenteDAO.deleteDependente(codCli, codDep);
            System.out.println("Dependente deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar dependente: " + e.getMessage());
        }
    }

    private static void menuLocacao(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Locação");
            System.out.println("1. Adicionar Locação");
            System.out.println("2. Listar Locações");
            System.out.println("3. Atualizar Locação");
            System.out.println("4. Deletar Locação");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addLocacao(scanner);
                    break;
                case 2:
                    listLocacoes();
                    break;
                case 3:
                    updateLocacao(scanner);
                    break;
                case 4:
                    deleteLocacao(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addLocacao(Scanner scanner) {
        try {
            Locacao locacao = new Locacao();
            System.out.print("Digite o código da locação: ");
            locacao.setCad_loc(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite a data da locação (YYYY-MM-DD): ");
            locacao.setData_loc(java.sql.Date.valueOf(scanner.nextLine()));

            System.out.print("Digite o desconto: ");
            locacao.setDesconto(scanner.nextDouble());

            System.out.print("Digite a multa: ");
            locacao.setMulta(scanner.nextDouble());

            System.out.print("Digite o subtotal: ");
            locacao.setSub_total(scanner.nextDouble());

            System.out.print("Digite o código do cliente: ");
            locacao.setCod_cli(scanner.nextInt());

            locacaoDAO.addLocacao(locacao);
            System.out.println("Locação adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar locação: " + e.getMessage());
        }
    }

    private static void listLocacoes() {
        try {
            List<Locacao> locacoes = locacaoDAO.getAllLocacoes();
            for (Locacao locacao : locacoes) {
                System.out.println("ID: " + locacao.getCad_loc() +
                        ", Data: " + locacao.getData_loc() +
                        ", Desconto: " + locacao.getDesconto() +
                        ", Multa: " + locacao.getMulta() +
                        ", Subtotal: " + locacao.getSub_total() +
                        ", Cliente ID: " + locacao.getCod_cli());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar locações: " + e.getMessage());
        }
    }

    private static void updateLocacao(Scanner scanner) {
        try {
            Locacao locacao = new Locacao();
            System.out.print("Digite o código da locação a ser atualizada: ");
            locacao.setCad_loc(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite a nova data da locação (YYYY-MM-DD): ");
            locacao.setData_loc(java.sql.Date.valueOf(scanner.nextLine()));

            System.out.print("Digite o novo desconto: ");
            locacao.setDesconto(scanner.nextDouble());

            System.out.print("Digite a nova multa: ");
            locacao.setMulta(scanner.nextDouble());

            System.out.print("Digite o novo subtotal: ");
            locacao.setSub_total(scanner.nextDouble());

            System.out.print("Digite o novo código do cliente: ");
            locacao.setCod_cli(scanner.nextInt());

            locacaoDAO.updateLocacao(locacao);
            System.out.println("Locação atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar locação: " + e.getMessage());
        }
    }

    private static void deleteLocacao(Scanner scanner) {
        try {
            System.out.print("Digite o código da locação a ser deletada: ");
            int codLoc = scanner.nextInt();
            locacaoDAO.deleteLocacao(codLoc);
            System.out.println("Locação deletada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar locação: " + e.getMessage());
        }
    }

    private static void menuProfissao(Scanner scanner) {
        int option;
        do {
            System.out.println("Menu Profissão");
            System.out.println("1. Adicionar Profissão");
            System.out.println("2. Listar Profissões");
            System.out.println("3. Atualizar Profissão");
            System.out.println("4. Deletar Profissão");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addProfissao(scanner);
                    break;
                case 2:
                    listProfissoes();
                    break;
                case 3:
                    updateProfissao(scanner);
                    break;
                case 4:
                    deleteProfissao(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);
    }

    private static void addProfissao(Scanner scanner) {
        try {
            Profissao profissao = new Profissao();
            System.out.print("Digite o código da profissão: ");
            profissao.setCod_prof(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o nome: ");
            profissao.setNome(scanner.nextLine());

            profissaoDAO.addProfissao(profissao);
            System.out.println("Profissão adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar profissão: " + e.getMessage());
        }
    }

    private static void listProfissoes() {
        try {
            List<Profissao> profissoes = profissaoDAO.getAllProfissoes();
            for (Profissao profissao : profissoes) {
                System.out.println("ID: " + profissao.getCod_prof() +
                        ", Nome: " + profissao.getNome());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar profissões: " + e.getMessage());
        }
    }

    private static void updateProfissao(Scanner scanner) {
        try {
            Profissao profissao = new Profissao();
            System.out.print("Digite o código da profissão a ser atualizada: ");
            profissao.setCod_prof(scanner.nextInt());
            scanner.nextLine();  // Consume newline

            System.out.print("Digite o novo nome: ");
            profissao.setNome(scanner.nextLine());

            profissaoDAO.updateProfissao(profissao);
            System.out.println("Profissão atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar profissão: " + e.getMessage());
        }
    }

    private static void deleteProfissao(Scanner scanner) {
        try {
            System.out.print("Digite o código da profissão a ser deletada: ");
            int codProf = scanner.nextInt();
            profissaoDAO.deleteProfissao(codProf);
            System.out.println("Profissão deletada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar profissão: " + e.getMessage());
        }
    }
}
