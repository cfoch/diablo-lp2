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

	private Integer vidamax;
	private Integer vida;
	private Arma arma;
	private Armadura armadura;
	private Saco saco = new Saco();

	public Avatar(Integer x, Integer y, String nombre, Integer vidaMax) {
		super(x, y, 0, nombre);
		this.vidamax = this.vida = vidaMax;
	}

	public Integer getVidaMax() {
		return vidamax;
	}

	public void setVidaMax(Integer VidaMax) {
		this.vidamax = VidaMax;
	}

	/**
	 * @return the Vida
	 */
	public Integer getVida() {
		return vida;
	}

	/**
	 * @param Vida the Vida to set
	 */
	public void setVida(Integer Vida) {
		this.vida = Vida;
	}

	/**
	 * @return the arma
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * @param arma the arma to set
	 */
	public void setArma(Arma arma) {
		this.arma = arma;
	}

	/**
	 * @return the armadura
	 */
	public Armadura getArmadura() {
		return armadura;
	}

	/**
	 * @param armadura the armadura to set
	 */
	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	/**
	 * @return the saco
	 */
	public Saco getSaco() {
		return saco;
	}

	/**
	 * @param saco the saco to set
	 */
	public void setSaco(Saco saco) {
		this.saco = saco;
	}

	private void imprimirNVeces(String l, Integer n) {
		for (int i = 0; i < n; i++) {
			System.out.print(l);
		}
		//System.out.println();
	}

	private void instrucciones()
	{
		System.out.println(" Q = Interactuar");
		System.out.println(" E = Salir");
		System.out.println(" A = Moverse hacia la izquierda");
		System.out.println(" A = Moverse hacia la izquierda");

	}

	public void imprimir() {

		System.out.print("Player Info");
		imprimirNVeces(" ", 20);
		System.out.print("Arma Principal");
		imprimirNVeces(" ", 15);
		System.out.println("Armadura Principal");
		imprimirNVeces("_", 20);
		imprimirNVeces(" ", 10);
		imprimirNVeces("_", 20);
		imprimirNVeces(" ", 10);
		imprimirNVeces("_", 20);
		System.out.println();
		System.out.print("Nombre: " + getNombre());
		imprimirNVeces(" ", 15);
		//System.out.println("Arma principal");
		if (arma != null) {
			arma.imprimir();
		} else {
			System.out.print("Empty");
			imprimirNVeces(" ", 25);
		}

		if (armadura != null) {
			armadura.imprimir();
			System.out.println();
		} else {
			System.out.println("Empty");

		}
		System.out.println("Vida Max: " + vidamax);
		System.out.println("Vida : " + vida);
		System.out.println("Direccion : " + super.getDireccion());
//        System.out.println("Arma principal");
//        if (arma!=null) {
//            arma.imprimir();
//        }
//        else{
//            System.out.print("Empty");
//        }
		// System.out.println("Armadura principal");
//        if (armadura != null) {
//            armadura.imprimir();
//        } else {
//            System.out.println("Empty");
//        }
		imprimirNVeces("_", 20);
		saco.imprimir();
	}

	public void addArtefacto(Artefacto a) {
		saco.addArtefacto(a);
	}

	public Integer usar(Integer n) {
		Artefacto artefacto = saco.getArtefacto(n);
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
		vida = Math.min(vida + pocion.getPuntos_vida(), vidamax);
	}

	private void armar(Artefacto a) {
		Arma _arma = (Arma) a;
		if (arma != null) {
			saco.addArtefacto(arma);
		}
		this.arma = _arma;
	}

	private void defender(Artefacto a) {
		Armadura _armadura = (Armadura) a;
		if (armadura != null) {
			saco.addArtefacto(armadura);
		}
		this.armadura = _armadura;
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
