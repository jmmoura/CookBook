package com.letscode.cookBook.enums;

public enum TipoRendimento {
    UNIDADES,
    PORCOES,
    COPOS;

    @Override
    public String toString() {
        String tipoRendimento = "";
        switch (this.name()) {
            case "UNIDADES":
                tipoRendimento = "unidade(s)";
                break;
            case "PORCOES":
                tipoRendimento = "porção(ões)";
                break;
            case "COPOS":
                tipoRendimento = "copo(s)";
                break;
        }

        return tipoRendimento;
    }
}
