package com.example.new_mentalcalcul;

public enum TypeOperationEnum {

    ADD(" + "),
    SUBSTRACT(" - "),
    MULTIPLY(" * "),
    DIVIDE(" / ");

    TypeOperationEnum(String symbole){
        this.symbole = symbole;
    }
    public String getSymbole(){
        return symbole;
    }
    private String symbole;
}
