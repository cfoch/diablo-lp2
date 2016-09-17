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
public abstract class Artefacto {
	private Integer x;
	private Integer y;
	private Integer tipo;
	private String nombre;
	public Artefacto(Integer x,Integer y,Integer tipo,String nombre){
		this.x=x;
		this.y=y;
		this.tipo=tipo;
		this.nombre=nombre;
	}

	public void imprimirNVeces(String l,Integer n){
		for (int i=0; i<n; i++)
			System.out.print(l);
		System.out.println();
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
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

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract void imprimir();

}
