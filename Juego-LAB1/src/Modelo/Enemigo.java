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
        Integer tipoArma=Myrandom(1,3);
        Arma arma=new Arma(super.getX(),super.getY(),tipoArma,"Tipo"+tipoArma,Myrandom(5,10),Myrandom(10,15));
        super.getSaco().addArtefacto(arma);
        Integer tipoArmadura=Myrandom(1,3);
        Armadura armadura=new Armadura(super.getX(),super.getY(),Myrandom(20,30),tipoArmadura,"Tipo"+tipoArmadura);
        super.getSaco().addArtefacto(armadura);
        Integer tipoPocion=Myrandom(1,3);
        PocionCuracion pocion=new PocionCuracion(super.getX(),super.getY(),Myrandom(15,25),tipoPocion,"Tipo"+tipoPocion);
        super.getSaco().addArtefacto(pocion); 
        super.setArma(arma);
        super.setArmadura(armadura);
    }
    
        
    private static Integer Myrandom(Integer ini,Integer fin){
        List<Integer> lista= new ArrayList<>();
        for (int i=ini;i<=fin;i+=1)
            lista.add(i);
        Collections.shuffle(lista);
        return lista.get(0); 
    }
}
