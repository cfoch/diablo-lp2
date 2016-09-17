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
public class Entidad {

    
    private Integer x;
    private Integer y;
    private Integer nivel;
    private String nombre;
    private char direccion;
    

    public Entidad(Integer x, Integer y, Integer nivel, String nombre) {
        this.x = x;
        this.y = y;
        this.nivel = nivel;
        this.nombre = nombre;
        this.direccion='S';
    } 

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public char getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }
    
    public void showEntity(){
        System.out.print('X');
    }

//    public void atacar(Entidad e)
//    {
//        int vida = 
//        vida = Math.min(vida + pocion.getPuntos_vida(), vidamax);
//    }
}
