package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

public class Receita {
    private String nome;
    private Categoria categoria;
    private int tempoPreparo;
    private Rendimento rendimento;
    private List<Ingrediente> ingredientes;
    private List<String> modoPreparo;

    public Receita(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.ingredientes = new ArrayList<>();
        this.modoPreparo = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Rendimento getRendimento() {
        return rendimento;
    }

    public void setRendimento(Rendimento rendimento) {
        this.rendimento = rendimento;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(List<String> modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receita receita = (Receita) o;

        return nome.equals(receita.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public String toString() {
        int horas = tempoPreparo / (60*60);
        int minutos = tempoPreparo % (60*60) / 60;
        int segundos = tempoPreparo % (60*60) % 60;
        String tempo = horas > 0 ? horas + " hora(s) " : "";
        tempo += minutos > 0 ? minutos + " minuto(s) " : "";
        tempo += segundos > 0 ? segundos + " segundo(s) " : "";

        String ingredientes = "";
        for (Ingrediente item : this.ingredientes) {
            ingredientes += String.format("  - %s%n", item);
        }

        String modoPreparo = "";
        for (int i = 0; i < this.modoPreparo.size(); i++) {
            modoPreparo += String.format("  %d° passo:%n", i+1);
            modoPreparo += String.format("  - %s%n", this.modoPreparo.get(i));
        }

        return String.format("%s%n\t%s%n%nRendimento: %s%nTempo: %s%nIngredientes:%n%sModo de preparo:%n%s", nome, categoria, rendimento, tempo, ingredientes, modoPreparo);
    }
}
