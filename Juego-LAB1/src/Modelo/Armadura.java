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
public class Armadura extends Artefacto{
    Integer defensa;
     public Armadura(Integer x,Integer y,Integer defensa,Integer tipo,String nombre){
        super(x,y,tipo,nombre);
        this.defensa=defensa;
    }
      public void imprimir(){
        System.out.print("Armadura: "+super.getNombre() +"; DF: "+defensa);               
    }
    /**
     * @return the defensa
     */
    public Integer getDefensa() {
        return defensa;
    }

    /**
     * @param defensa the defensa to set
     */
    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }
}
