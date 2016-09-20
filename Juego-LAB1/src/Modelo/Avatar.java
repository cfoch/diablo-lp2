/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Avatar extends Entidad {

    public Avatar(Integer x, Integer y, String nombre, Integer vidaMax) {
        super(x, y, 0, nombre, vidaMax);
        Integer tipoArma = Myrandom(1, 3);
        Arma arma = new Arma(getX(), getY(), tipoArma, "Tipo" + tipoArma, Myrandom(20, 40), Myrandom(40, 50));
        Integer tipoArmadura = Myrandom(1, 3);
        Armadura armadura = new Armadura(getX(), getY(), Myrandom(20, 30), tipoArmadura, "Tipo" + tipoArmadura);
        
        super.setArma(arma);
        super.setArmadura(armadura);
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
    
    public void addArtefacto(Artefacto a) {
        super.getSaco().addArtefacto(a);
    }

    public Integer usar(Integer n) {
        Artefacto artefacto = super.getSaco().getArtefacto(n);
        if (artefacto == null) {
            return -2;
        }
        if (artefacto.getClass().equals(PocionCuracion.class)) {
            curar(artefacto);
        } else if (artefacto.getClass().equals(Arma.class)) {
            armar(artefacto);
        } else if (artefacto.getClass().equals(Armadura.class)) {
            defender(artefacto);
        }
        return 0;
    }

    private void curar(Artefacto a) {
        PocionCuracion pocion = (PocionCuracion) a;
        super.setVida(Math.min(super.getVida() + pocion.getPuntos_vida(), super.getVidamax()));
    }

    private void armar(Artefacto a) {
        Arma _arma = (Arma) a;
        if (super.getArma() != null) {
            super.getSaco().addArtefacto(super.getArma());
        }
        super.setArma(_arma);

    }

    private void defender(Artefacto a) {
        Armadura _armadura = (Armadura) a;
        if (super.getArmadura() != null) {
            super.getSaco().addArtefacto(super.getArmadura());
        }
        super.setArmadura(_armadura);
    }

    public Integer getVariacionX() {
        if (super.getDireccion() == 'N') {
            return -1;
        }
        if (super.getDireccion() == 'S') {
            return 1;
        }
        return 0;
    }

    public Integer getVariacionY() {
        if (super.getDireccion() == 'O') {
            return -1;
        }
        if (super.getDireccion() == 'E') {
            return 1;
        }
        return 0;
    }

}
