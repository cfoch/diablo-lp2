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
public class Avatar extends Entidad {

    public Avatar(Integer x, Integer y, String nombre, Integer vidaMax) {
        super(x, y, 0, nombre,vidaMax);        
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
        super.setVida(Math.min(super.getVida() + pocion.getPuntos_vida(),super.getVidamax()));
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
