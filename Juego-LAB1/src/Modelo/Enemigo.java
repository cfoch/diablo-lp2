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
    
    private static Integer Myrandom(Integer ini, Integer fin) {
        List<Integer> lista = new ArrayList<>();
        for (int i = ini; i <= fin; i += 1) {
            lista.add(i);
        }
        Collections.shuffle(lista);
        return lista.get(0);
    }
    
    public void generarSaco() {
        /*ARMA-ARMADURA-POCION INICIALES*/
        Integer tipoArma = Myrandom(1, 3);
        Arma arma = new Arma(getX(), getY(), tipoArma, "Tipo" + tipoArma, Myrandom(20, 40), Myrandom(40, 50));
        Integer tipoArmadura = Myrandom(1, 3);
        Armadura armadura = new Armadura(getX(), getY(), Myrandom(10, 15), tipoArmadura, "Tipo" + tipoArmadura);
        
        
        /*EN EL SACO TIENE ARMA PODEROSA Y POCION PARA CURARSE*/
        
        Integer tipoPocion = Myrandom(1, 3);
        Arma armaPoderosa = new Arma(getX(), getY(), tipoArma, "Tipo" + tipoArma, Myrandom(40, 50), Myrandom(50, 55));
        PocionCuracion pocion = new PocionCuracion(getX(), getY(), Myrandom(20, 30), tipoPocion, "Tipo" + tipoPocion);
            
        super.getSaco().addArtefacto(armaPoderosa);
        super.getSaco().addArtefacto(pocion);
        
        setArma(arma);
        setArmadura(armadura);
    }

}
