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
    
    public void imprimir(){
        System.out.print("Arma: "+super.getNombre());
        System.out.print(" Daño:"+danoMin +"-"+ danoMax);
        for (int i=0;i<10;i++)
            System.out.print(" ");             
    }
  
    /**
     * @return the danoMin
     */
    public Integer getDanoMin() {
        return danoMin;
    }

    /**
     * @param danoMin the danoMin to set
     */
    public void setDanoMin(Integer danoMin) {
        this.danoMin = danoMin;
    }

    /**
     * @return the danoMax
     */
    public Integer getDanoMax() {
        return danoMax;
    }

    /**
     * @param danoMax the danoMax to set
     */
    public void setDanoMax(Integer danoMax) {
        this.danoMax = danoMax;
    }
}
