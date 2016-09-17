/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import Modelo.Avatar;
import Modelo.Dibujador;
import Controlador.GestorLaberinto;
import Modelo.Artefacto;
import Modelo.Laberinto;

/**
 *
 * @author
 */
public class Juego {
	private static Laberinto laberinto;
	private static String[] movs = new String[10];

	private static Integer Myrandom(Integer ini,Integer fin){
		List<Integer> lista= new ArrayList<>();
		for (int i=ini; i<=fin; i+=1)
			lista.add(i);
		Collections.shuffle(lista);
		return lista.get(0);
	}


	private static Integer procesarInstruccion(String cadActual,
	                                           Avatar avatar) {
		Integer respuesta = -1;
		String sufij;
		//enter
		/*if (cadActual.length() >= movs[6].length()) {
		    sufij = cadActual.subSequence(0, movs[6].length()).toString();
		   } else {
		    return -1;
		   }*///descomentar para el usar

		if (cadActual.compareTo(movs[0]) == 0) {
			return 3;
		}
		if (cadActual.compareTo(movs[1]) == 0) {
			avatar.setDireccion('E');
			respuesta = laberinto.comprobarTipo(
				avatar.getX(),avatar.getY() + 1);
			if (respuesta != -1) {
				avatar.setY((Integer) (avatar.getY() + 1));
			}
			if (respuesta == 3) {
				return 1; // ANTERIOR
			}
			if (respuesta == 4) {
				return 2; // SIGUIENTE
			}
		} else if (cadActual.compareTo(movs[2]) == 0) {
			avatar.setDireccion('O');
			respuesta = laberinto.comprobarTipo(
				avatar.getX(), avatar.getY() - 1);
			if (respuesta != -1) {
				avatar.setY((Integer) (avatar.getY() - 1));
			}
			if (respuesta == 3) {
				return 1; // ANTERIOR
			}
			if (respuesta == 4) {
				return 2; // SIGUIENTE
			}
		} else if (cadActual.compareTo(movs[3]) == 0) {
			avatar.setDireccion('S');
			respuesta = laberinto.comprobarTipo(
				avatar.getX() + 1, avatar.getY());
			if (respuesta != -1) {
				avatar.setX((Integer) (avatar.getX() + 1));
			}
			if (respuesta == 3) {
				return 1; // ANTERIOR
			}
			if (respuesta == 4) {
				return 2; // SIGUIENTE
			}
		} else if (cadActual.compareTo(movs[4]) == 0) {
			avatar.setDireccion('N');
			respuesta = laberinto.comprobarTipo(
				avatar.getX() - 1, avatar.getY());
			if (respuesta != -1) {
				avatar.setX((Integer) (avatar.getX() - 1));
			}
			if (respuesta == 3) {
				return 1; // ANTERIOR
			}
			if (respuesta == 4) {
				return 2; // SIGUIENTE
			}
		} else if (cadActual.compareTo(movs[5]) == 0) {
			Integer difX = avatar.getVariacionX();
			Integer difY = avatar.getVariacionY();
			Integer newX = avatar.getX() + difX;
			Integer newY = avatar.getY() + difY;
			if (laberinto.getCelda(newX,
			                       newY).getTipo()==6||
			    laberinto.getCelda(newX,
			                       newY).getTipo()==7||
			    laberinto.getCelda(newX, newY).getTipo()==8) {
				// es artefacto
				Artefacto a = laberinto.extraerArtefacto(newX,
				                                         newY);
				if (a != null) {
					respuesta = 0;
					avatar.getSaco().addArtefacto(a);
				}
			}
			if (laberinto.getCelda(newX, newY).getTipo()==5) {
				// es enemigo
				// batalla que deberia
			}


		} /*else if (sufij.compareTo(movs[6]) == 0) {
		     Integer n = Integer.parseInt(cadActual.replace(movs[6], "").trim().toString());
		     respuesta = avatar.usar(n);
		     }*///descomentar para el usar
		if (respuesta < 0) {
			return respuesta; // si interactua con un objeto que no existe
			                  // al moverme hacia una celda inválida
			                  // si se ingresa un comando que no está en las instrucciones
		}
		return 0;
	}

	public static void main(String[] args) {
		List<Laberinto> mundo= new ArrayList<>();
		GestorLaberinto gestor= new GestorLaberinto();
		Integer cantMinMundos=3,cantMaxMundos=7,limiteInicial=20,
		        limiteFinal=25;
		Integer cantMundos=Myrandom(cantMinMundos,cantMaxMundos);
		for (int i=0; i<cantMundos; i++) {
			Integer fils=Myrandom(limiteInicial,limiteFinal);
			Integer cols=Myrandom(limiteInicial,limiteFinal);
			Laberinto lab=gestor.crear(fils,cols);
			lab.anadirElementos(i+1);
			mundo.add(lab);
			limiteInicial+=1; limiteFinal+=1;
		}

		movs[0] = "E"; //SALIR
		movs[1] = "D"; //DERECHA
		movs[2] = "A"; //IZQUIERDA
		movs[3] = "S"; //ABAJO
		movs[4] = "W"; //ARRIBA
		movs[5] = "Q"; //INTERACTUAR
		//movs[6] = "U";  //USAR N #, N ES LA POSICION DE UN ARTEFACTO EN EL SACO
		//descomentar para el usar
		Integer myWorld=0;
		int tamDibujadorX=15,tamDibujadorY=15;
		Dibujador dib= new Dibujador(tamDibujadorX,tamDibujadorY);
		laberinto= mundo.get(0);
		Avatar a= new Avatar(laberinto.getInicio().getX()
		                     ,laberinto.getInicio().getY()
		                     ,"Atlas",200);
		String mensaje="";
		int decision = 0;
		String inicio = "";
		while (true) {
			if (decision == 0) {
				decision = 1;
				inicio=dib.imprimir_historia(decision);
			} else if ((inicio.compareTo("SI") == 0) ||
			           (inicio.compareTo("si") == 0)||
			           (inicio.compareTo("Si") == 0)) {
				System.out.println(
					"Mundo N°" + (myWorld + 1) + " de " +
					cantMundos);
				dib.Dibujar(laberinto, a, mensaje,movs );
				Scanner sc = new Scanner(System.in);
				String instruccion = sc.nextLine();
				Integer respuesta = procesarInstruccion(
					instruccion, a);
				//direccionRandom = Myrandom(1,4); //----------

				laberinto.moverEnemigos(a.getX(),a.getY()); //----------
				if (respuesta == 2 &&
				    myWorld == cantMundos - 1) {    // ganó (fin del juego)
					//imprimimos victoria
					dib.win();
					break;
				}

				if (respuesta == 1 && myWorld != 0) {// regresar al mundo anterior
					myWorld--;
					laberinto = mundo.get(myWorld);
					a.setX(laberinto.getFin().getX());
					a.setY(laberinto.getFin().getY());
				}
				if (respuesta == 2 &&
				    myWorld != cantMundos - 1) {  // pasar al siguiente mundo
					myWorld++;
					laberinto = mundo.get(myWorld);
					a.setX(laberinto.getInicio().getX());
					a.setY(laberinto.getInicio().getY());

				}
				if (respuesta == 3)//salir del juego
				{
					break;
				}

				if (respuesta == -1) {
					mensaje = "Instruccion Invalida";
				} else if (respuesta == -2) {
					mensaje =
						"No se puede realizar la accion, revisar el saco";
				} else {
					mensaje = "";
				}

			} else {
				break;
			}
		}
	}
}
