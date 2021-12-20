package com.letscode.cookBook.enums;

public enum TipoMedida {
    KILOS,
    GRAMAS,
    LITROS,
    MILILITROS,
    CHICARA,
    COPO,
    COLHER_DE_SOPA,
    COLHER_DE_CHA,
    COLHER_DE_CAFE,
    GOTAS,
    UNIDADES;


    @Override
    public String toString() {
        String tipoMedida = "";
        switch (this.name()) {
            case "KILOS":
                tipoMedida = "kilo(s)";
                break;
            case "GRAMAS":
                tipoMedida = "grama(s)";
                break;
            case "LITROS":
                tipoMedida = "litro(s)";
                break;
            case "MILILITROS":
                tipoMedida = "mililitro(s)";
                break;
            case "CHICARA":
                tipoMedida = "chícara(s)";
                break;
            case "COPO":
                tipoMedida = "copo(s)";
                break;
            case "COLHER_DE_SOPA":
                tipoMedida = "colhere(s) de sopa";
                break;
            case "COLHER_DE_CHA":
                tipoMedida = "colhere(s) de chá";
                break;
            case "COLHER_DE_CAFE":
                tipoMedida = "colhere(s) de café";
                break;
            case "GOTAS":
                tipoMedida = "gota(s)";
                break;
            case "UNIDADES":
                tipoMedida = "unidade(s)";
                break;
        }
        return tipoMedida;
    }
}
