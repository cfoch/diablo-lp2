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

    private Integer x;
    private Integer y;
    private Integer tipo;
    // 0 PARED
    // 1 AFUERA
    // 2 DENTRO
    // 3 ANTERIOR
    // 4 SIGUIENTE
    // 5 ENEMIGO
    // 6 ARMA
    // 7 ARMADURA
    // 8 POCION

    public Celda(Integer x, Integer y, Integer tipo) {
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
    public Integer getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public void imprimir() {
        switch(tipo){
            case 0: System.out.print("#");  // PARED
                    break;
            case 2: System.out.print(" ");  // DENTRO
                    break;
            case 3: System.out.print("-");  // ANTERIOR
                    break;
            case 4: System.out.print("+");  // SIGUIENTE
                    break;
            case 5: System.out.print("E");  // ENEMIGO
                    break;
            case 6: System.out.print("A");  // ARMA
                    break;
            case 7: System.out.print("A");  // ARMADURA
                    break;
            case 8: System.out.print("A");  // POCION
                    break;
        }  
    }

    public void imprimirInfo() {
        System.out.println("(" + x + "," + y + ")" + " " + tipo);
    }
}
