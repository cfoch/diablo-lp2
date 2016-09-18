/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Utils.Utils;

/**
 *
 * @author
 */
public class Enemigo extends Entidad{
    private Integer tipo;
    public Enemigo(Integer x,Integer y,Integer nivel,Integer tipo,String nombre){
        super(x,y,nivel,nombre,120);
        generarSaco();
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

    private void generarSaco(){
        Integer tipoArma=Utils.randInt(1,3);
        Arma arma=new Arma(super.getX(),super.getY(),tipoArma,"Tipo"+tipoArma,Utils.randInt(5,10),Utils.randInt(10,15));
        super.getSaco().addArtefacto(arma);
        Integer tipoArmadura=Utils.randInt(1,3);
        Armadura armadura=new Armadura(super.getX(),super.getY(),Utils.randInt(20,30),tipoArmadura,"Tipo"+tipoArmadura);
        super.getSaco().addArtefacto(armadura);
        Integer tipoPocion=Utils.randInt(1,3);
        PocionCuracion pocion=new PocionCuracion(super.getX(),super.getY(),Utils.randInt(15,25),tipoPocion,"Tipo"+tipoPocion);
        super.getSaco().addArtefacto(pocion);
        super.setArma(arma);
        super.setArmadura(armadura);
    }


}
