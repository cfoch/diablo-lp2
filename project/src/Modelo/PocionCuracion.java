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
public class PocionCuracion extends Artefacto {
	private Integer puntos_vida;
	public PocionCuracion(Integer x,Integer y,Integer puntos_vida,
	                      Integer tipo,String nombre){
		super(x,y,tipo,nombre);
		this.puntos_vida=puntos_vida;
	}
	@Override
	public void imprimir(){
		//super.imprimirNVeces("_", 20);
		System.out.print(
			"Pocion: "+super.getNombre()+" Curacion:"+
			getPuntos_vida());
		//System.out.println("Puntos Vida: "+getPuntos_vida());
		//super.imprimirNVeces("_", 20);
	}

	/**
	 * @return the puntos_vida
	 */
	public Integer getPuntos_vida() {
		return puntos_vida;
	}

	/**
	 * @param puntos_vida the puntos_vida to set
	 */
	public void setPuntos_vida(Integer puntos_vida) {
		this.puntos_vida = puntos_vida;
	}

}
