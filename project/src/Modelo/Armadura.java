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
public class Armadura extends Artefacto {
	Integer defensa;
	public Armadura(Integer x,Integer y,Integer defensa,Integer tipo,
	                String nombre){
		super(x,y,tipo,nombre);
		this.defensa=defensa;
	}
	@Override
	public void imprimir(){
		//super.imprimirNVeces("_", 20);
		//super.imprimirNVeces(" ", 20);
		System.out.print(
			"Armadura: "+super.getNombre() +"; DF: "+defensa);
//       super.imprimirNVeces(" ", 20);
//        System.out.println("Defensa: "+defensa);
//        super.imprimirNVeces("_", 20);
	}

}
