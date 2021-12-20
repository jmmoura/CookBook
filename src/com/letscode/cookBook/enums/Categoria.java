package com.letscode.cookBook.enums;

public enum Categoria {
    BOLOS_E_TORTAS_DOCES,
    CARNES,
    AVES,
    PEIXES_E_FRUTOS_DO_MAR,
    SALADAS_MOLHOS_E_ACOMPANHAMENTOS,
    SOPAS,
    MASSAS,
    BEBIDAS,
    DOCES_E_SOBREMESAS,
    LANCHES,
    PRATO_UNICO,
    LIGHT,
    SAUDAVEL;

    @Override
    public String toString() {
        String categoria = "";
        switch (this.name()) {
            case "BOLOS_E_TORTAS_DOCES":
                categoria = "Bolos e tortas doces";
                break;
            case "CARNES":
                categoria = "Carnes";
                break;
            case "AVES":
                categoria = "Aves";
                break;
            case "PEIXES_E_FRUTOS_DO_MAR":
                categoria = "Peixes e frutos do mar";
                break;
            case "SALADAS_MOLHOS_E_ACOMPANHAMENTOS":
                categoria = "Saladas, molhos e acompanhamentos";
                break;
            case "SOPAS":
                categoria = "Sopas";
                break;
            case "MASSAS":
                categoria = "Massas";
                break;
            case "BEBIDAS":
                categoria = "Bebidas";
                break;
            case "DOCES_E_SOBREMESAS":
                categoria = "Doces e sobremesas";
                break;
            case "LANCHES":
                categoria = "Lanches";
                break;
            case "PRATO_UNICO":
                categoria = "Prato único";
                break;
            case "LIGHT":
                categoria = "Light";
                break;
            case "SAUDAVEL":
                categoria = "Saudável";
                break;
        }

        return categoria;
    }
}
