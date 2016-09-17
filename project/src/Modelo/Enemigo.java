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
public class Enemigo extends Entidad {
	private Integer tipo;
	public Enemigo(Integer x,Integer y,Integer nivel,Integer tipo,
	               String nombre){
		super(x,y,nivel,nombre);
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
}
