/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private Arma arma;
    private Armadura armadura;
    private PocionCuracion pocion;
    private Saco saco = new Saco(); 
    private Integer vidamax;
    private Integer vida;

    public Entidad(Integer x, Integer y, Integer nivel, String nombre, Integer vidamax) {
        this.x = x;
        this.y = y;
        this.nivel = nivel;
        this.nombre = nombre;
        this.direccion = 'S';
        this.vidamax = vida = vidamax;
        generarSaco();
    }

    public void generarSaco() {
        
    }

    private static Integer Myrandom(Integer ini, Integer fin) {
        List<Integer> lista = new ArrayList<>();
        for (int i = ini; i <= fin; i += 1) {
            lista.add(i);
        }
        Collections.shuffle(lista);
        return lista.get(0);
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

    public void showEntity() {
        System.out.print('X');
    }

    /**
     * @return the arma
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * @param arma the arma to set
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /**
     * @return the armadura
     */
    public Armadura getArmadura() {
        return armadura;
    }

    /**
     * @param armadura the armadura to set
     */
    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    /**
     * @return the saco
     */
    public Saco getSaco() {
        return saco;
    }

    /**
     * @param saco the saco to set
     */
    public void setSaco(Saco saco) {
        this.saco = saco;
    }

    /**
     * @return the vidamax
     */
    public Integer getVidamax() {
        return vidamax;
    }

    /**
     * @param vidamax the vidamax to set
     */
    public void setVidamax(Integer vidamax) {
        this.vidamax = vidamax;
    }

    /**
     * @return the vida
     */
    public Integer getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(Integer vida) {
        this.vida = vida;
    }

    /**
     * @return the pocion
     */
    public PocionCuracion getPocion() {
        return pocion;
    }

    /**
     * @param pocion the pocion to set
     */
    public void setPocion(PocionCuracion pocion) {
        this.pocion = pocion;
    }

    public void imprimirEntidad() {
        imprimirNVeces("-", 100);
        System.out.println();
        if (this.getClass() == Avatar.class) {
            System.out.print("Player Info");
        } else {
            System.out.print("Enemigo");
        }
        imprimirNVeces(" ", 20);
        System.out.print("Arma Principal");
        imprimirNVeces(" ", 15);
        System.out.println("Armadura Principal");
        imprimirNVeces("_", 20);
        imprimirNVeces(" ", 10);
        imprimirNVeces("_", 20);
        imprimirNVeces(" ", 10);
        imprimirNVeces("_", 20);
        System.out.println();
        System.out.print("Nombre: " + getNombre());
        imprimirNVeces(" ", 15);
        //System.out.println("Arma principal");
        if (getArma() != null) {
            getArma().imprimir();
        } else {
            System.out.print("Empty ");
            imprimirNVeces(" ", 25);
        }

        if (getArmadura() != null) {
            getArmadura().imprimir();
            System.out.println();
        } else {
            System.out.println("Empty ");

        }
        System.out.println("Vida Max: " + vidamax);
        System.out.println("Vida : " + vida);
        System.out.println("Direccion : " + getDireccion());
        
        System.out.println();
        getSaco().imprimir();
        imprimirNVeces("-", 100);
        System.out.println();
        System.out.println();

    }

    private void imprimirNVeces(String l, Integer n) {
        for (int i = 0; i < n; i++) {
            System.out.print(l);
        }
    }

    public void atacar(Entidad e) {
        int dano=Myrandom(arma.getDanoMin(),arma.getDanoMax());
        //dano> e.getArmadura().getDefensa(){
        Integer daño = Math.max(dano - e.getArmadura().getDefensa(),0);
        e.setVida(Math.max(e.getVida() - daño, 0));
        //System.out.print(e.getVida());
        //}
    }

    public Artefacto botarAleatorio() {
        Artefacto art = getSaco().getArtefacto(Myrandom(1,2));
        art.setX(x);
        art.setY(y);
        return art;
    }

}
