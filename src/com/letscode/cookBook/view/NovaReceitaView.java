package com.letscode.cookBook.view;

import com.letscode.cookBook.domain.Ingrediente;
import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.domain.Rendimento;
import com.letscode.cookBook.enums.Categoria;
import com.letscode.cookBook.enums.TipoMedida;
import com.letscode.cookBook.enums.TipoRendimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NovaReceitaView {
    private Scanner scanner;
    private Receita receita;
    private String nome;
    private TipoRendimento tipoRendimento;

    public NovaReceitaView() {
        this.scanner = new Scanner(System.in);
    }

    public void askNome() {
        System.out.println("Qual o nome da receita?");
        nome = scanner.next();
        if (nome.isBlank()) {
            System.out.println("Nome inválido!");
            askNome();
        }
    }

    public void askCategoria() {
        System.out.println("Qual a categoria da receita?");
        for (Categoria cat : Categoria.values()) {
            System.out.printf("%d - %s%n", cat.ordinal(), cat.name());
        }
        int categoria = scanner.nextInt();
        if (categoria < 0 || categoria >= Categoria.values().length) {
            System.out.println("Categoria inválida!");
            askCategoria();
        }

        receita = new Receita(nome, Categoria.values()[categoria]);
    }

    public void askTipoRendimento() {
        System.out.println("Qual o tipo de rendimento?");
        for (TipoRendimento tipoRendimento : TipoRendimento.values()) {
            System.out.printf("%d - %s%n", tipoRendimento.ordinal(), tipoRendimento.name());
        }
        int tipoRendimento = scanner.nextInt();
        if (tipoRendimento < 0 || tipoRendimento >= Categoria.values().length) {
            System.out.println("Categoria inválida!");
            askCategoria();
        }

        this.tipoRendimento = TipoRendimento.values()[tipoRendimento];
    }

    public void askQuantidadeRendimento() {
        System.out.println("Qual a quantidade de rendimento?");
        int quantidade = scanner.nextInt();
        if (quantidade < 1) {
            System.out.println("Quantidade inválida!");
            askQuantidadeRendimento();
        }

        Rendimento rendimento = new Rendimento(quantidade, this.tipoRendimento);
        receita.setRendimento(rendimento);
    }

    public void askTempoPreparo() {
        System.out.println("Quais a tempo de preparo em minutos?");
        int tempoPreparo = scanner.nextInt();
        if (tempoPreparo < 1) {
            System.out.println("Quantidade inválida!");
            askTempoPreparo();
        }

        receita.setTempoPreparo(tempoPreparo);
    }

    public void askIngredientes() {
        List<Ingrediente> ingredientes = new ArrayList<>();

        System.out.println("Adicione os ingredientes: ");

        do {
            System.out.println("Qual o nome do ingrediente?");
            String nome = scanner.next();
            System.out.println("Qual a quantidade do ingrediente?");
            double quantidade = scanner.nextDouble();
            System.out.println("Qual o tipo de medida do ingrediente?");
            for (TipoMedida tipoMedida : TipoMedida.values()) {
                System.out.printf("%d - %s%n", tipoMedida.ordinal(), tipoMedida.name());
            }
            int tipoMedida = scanner.nextInt();

            Ingrediente ingrediente = new Ingrediente(nome, quantidade, TipoMedida.values()[tipoMedida]);
            ingredientes.add(ingrediente);

            System.out.println("Deseja adicionar um novo ingrediente? y/N");
            String addNew = scanner.next();

            if(!addNew.equalsIgnoreCase("y"))
                break;
        } while (true);

        if (ingredientes.isEmpty()) {
            System.out.println("Adicione pelo menos um ingrediente!");
            askIngredientes();
        }
        receita.setIngredientes(ingredientes);
    }

    public void askModoPreparo() {
        List<String> modoPreparo = new ArrayList<>();

        System.out.println("Qual é o modo de preparo?");

        int passo = 1;
        do {
            System.out.printf("Adicione o %dº passo: %n", passo);
            modoPreparo.add(scanner.next());

            System.out.println("Deseja adicionar um novo passo? y/N");
            String addNew = scanner.next();

            if(!addNew.equalsIgnoreCase("y"))
                break;

            passo++;
        } while (true);

        if (modoPreparo.isEmpty()) {
            System.out.println("Modo de preparo precisa ter pelo menos um passo!");
            askModoPreparo();
        }

        receita.setModoPreparo(modoPreparo);
    }

    public Receita getReceita() {
        return receita;
    }
}
