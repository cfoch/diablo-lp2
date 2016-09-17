/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author
 */
public class Saco {
	private ArrayList<Artefacto> artefactos;

	public Saco(){
		this.artefactos = new ArrayList<>();
	}
	public void addArtefacto(Artefacto artefacto){
		artefactos.add(artefacto);
	}
	public Integer getSize(){
		return artefactos.size();
	}
	private void imprimirNVeces(String l,Integer n){
		for (int i=0; i<n; i++)
			System.out.print(l);
		//System.out.println();
	}
	public void imprimir(){
		imprimirNVeces("_", 50);
		System.out.println();
		System.out.print("Saco: ");
		if (artefactos.isEmpty())
			System.out.println(" Empty ");
		else{
			Iterator<Artefacto> iterator = artefactos.iterator();
			Integer n=0;
			while (iterator.hasNext()) {
				System.out.println();
				System.out.println("("+(n+1)+")");
				iterator.next().imprimir();
				n++;
			}
		}

		//imprimirNVeces("_", 20);
	}
	public Artefacto getArtefacto(Integer n){
		if (artefactos.isEmpty())
			return null;
		else{
			Iterator<Artefacto> iterator = artefactos.iterator();
			Integer i=0;
			while (iterator.hasNext()) {
				Artefacto a=iterator.next();
				i++;
				if (i==n) {
					artefactos.remove(a);
					return a;
				}
			}
		}
		return null;

	}

}
