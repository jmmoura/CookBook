package com.letscode.cookBook.view;

import com.letscode.cookBook.controller.Catalogo;
import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.enums.Categoria;

import java.util.Scanner;

public class CatalogoView {
    private final Receita NONE_FOUND = new Receita("Nenhuma receita encontrada", Categoria.PRATO_UNICO);
    private Receita receita;
    Catalogo controller = new Catalogo();
    private int curIndex = -1;

    private void showHeader() {
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # ##    ###  #  # #  # ##  ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("", 80, true, '=');
    }

    private void showReceita(Receita receita) {
        System.out.println(receita.toString());
    }

    private void showAnterior() {
        if (curIndex > 0) {
            this.receita = controller.getReceita(curIndex - 1);
            if (receita != null) curIndex--;
        }
    }

    private void showSeguinte() {
        this.receita = controller.getReceita(curIndex + 1);
        if (receita != null) curIndex++;
        else this.receita = controller.getReceita(curIndex);
    }

    private void add() {
        //TODO: Implement Add
        NovaReceitaView novaReceitaView = new NovaReceitaView();
        novaReceitaView.askNome();
        novaReceitaView.askCategoria();
        novaReceitaView.askTipoRendimento();
        novaReceitaView.askQuantidadeRendimento();
        novaReceitaView.askTempoPreparo();
        novaReceitaView.askIngredientes();
        novaReceitaView.askModoPreparo();

        receita = novaReceitaView.getReceita();
        controller.add(receita);

        curIndex++;

        System.out.println("Receita adicionada com sucesso!");
    }

    private void del() {
        if (curIndex >= 0) {
            controller.del(receita.getNome());
            receita = controller.getReceita(0);
            if (receita != null) curIndex = 0;
            else curIndex = -1;

            System.out.println("Receita removida com sucesso!");
        }
    }

    private void search() {
        System.out.println("Informe uma palavra contida no nome da receita:");
        receita = controller.getReceita(new Scanner(System.in).nextLine());
        if (receita != null) curIndex = controller.getReceitaIndex(receita.getNome());
        else receita = controller.getReceita(curIndex);
    }

    public void show() {
        do {
            showHeader();
            showReceita(receita == null ? NONE_FOUND : receita);
            ScreenUtil.printTextLine("", 80, true, '=');
            ScreenUtil.printTextLine("P: Receita anterior", 80, true);
            ScreenUtil.printTextLine("N: Receita seguinte", 80, true);
            ScreenUtil.printTextLine("+: Adicionar nova receita", 80, true);
            ScreenUtil.printTextLine("-: Remover receita", 80, true);
            ScreenUtil.printTextLine("S: Pesquisar receita", 80, true);
            ScreenUtil.printTextLine("", 80, true, '=');
            ScreenUtil.printTextLine("#: ", 80);
            String option;
            option = new Scanner(System.in).next();
            switch (option.toUpperCase()) {
                case "P":
                    showAnterior();
                    break;
                case "N":
                    showSeguinte();
                    break;
                case "+":
                    add();
                    break;
                case "-":
                    del();
                    break;
                case "S":
                    //TODO: Implement Search
                    search();
                    break;
                default:
                    ScreenUtil.printTextLine("Opção inválida", 80);
                    ScreenUtil.printTextLine("#: ", 80);
            }
            ScreenUtil.clearScreen();
        } while (true);
    }
}
