/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 
 */

public class Celda {
    static public enum Tipo {
        PARED,
        AFUERA, // Fuera del mapa.
        ADENTRO,
        MUNDO_ANTERIOR,
        MUNDO_SIGUIENTE,
        ENEMIGO,
        ARMA,
        ARMADURA,
        POCION
    };

    private Integer x;
    private Integer y;
    private Tipo tipo;

    public Celda(Integer x, Integer y, Tipo tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    /**
     * @return the x
     */
    public Integer getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public Integer getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean esArtefacto() {
        switch (tipo) {
            case ARMA:
            case ARMADURA:
            case POCION:
                return true;
            default:
                return false;
        }
    }

    public void imprimir() {
        switch(tipo){
            case PARED:
                System.out.print("#");
                break;
            case ADENTRO:
                System.out.print(" ");
                break;
            case MUNDO_ANTERIOR:
                System.out.print("-");
                break;
            case MUNDO_SIGUIENTE:
                System.out.print("+");
                break;
            case ENEMIGO:
                System.out.print("E");
                break;
            case ARMA:
                System.out.print("A");
                break;
            case ARMADURA:
                System.out.print("A");
                break;
            case POCION:
                System.out.print("A");
                break;
        }  
    }

    public void imprimirInfo() {
        System.out.println("(" + x + "," + y + ")" + " " + tipo);
    }
}
