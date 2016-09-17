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
public class Arma extends Artefacto {
    Integer danoMin;
    Integer danoMax;
    
    public Arma(Integer x,Integer y,Integer tipo,String nombre,Integer danomin,Integer danomax){
        super(x,y,tipo,nombre);
        this.danoMin=danomin;
        this.danoMax=danomax;
    }
    @Override
    public void imprimir(){
        //super.imprimirNVeces("_", 20);
        //System.out.println();
        //super.imprimirNVeces(" ", 30);
        System.out.print("Arma: "+super.getNombre());
        //super.imprimirNVeces(" ", 10);
        System.out.print(" Dano:"+danoMin +"-"+ danoMax);
        for (int i=0;i<10;i++)
            System.out.print(" ");
        //super.imprimirNVeces(" ", 30);
        //System.out.println("Dano Max: "+danoMax);
        //super.imprimirNVeces("_", 20);
             
    }
  
}
