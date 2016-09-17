/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Scanner;


/**
 *
 * @author
 */
public class Dibujador {
	Integer A;
	Integer B;
	private boolean isValid(Integer x,Integer y,Integer m,Integer n){
		return (x>=0 && x<m && y>=0 && y<n);
	}
	public Dibujador(Integer A,Integer B){
		this.A=A;
		this.B=B;
	}
	private void imprimirNVeces(String l,Integer n){
		for (int i=0; i<n; i++)
			System.out.print("_");
		System.out.println();
	}
	public void showInstruccions(){

		System.out.println();
		System.out.println("Ingrese una instruccion: ");
	}
	public void showMessage(String mensaje){
		System.out.println(mensaje);

	}

	public void Dibujar(Laberinto l,Avatar avatar,String mensaje,
	                    String movs[]){

		System.out.println();
		System.out.println();
		System.out.println("LEYENDA DE COMO MOVERSE");
		System.out.println(
			"--"+movs[2]+"--: IZQUIERDA\n--"+movs[3]+"--: ABAJO\n--"+
			movs[1]+"--: DERECHA\n--"+movs[4]+"--: ARRIBA");
		System.out.println(
			"--"+movs[5]+"--: INTERACTUAR\n--"+movs[0]+
			"--: SALIR°");
		int x=avatar.getX();
		int y=avatar.getY();
		int filas= l.getFilas();
		int columnas=l.getColumnas();
		imprimirNVeces("_",2*B+5);
		for (int i=x-A-1; i<=x+A+1; i++) {
			System.out.print("|");
			for (int j=y-B-1; j<=y+B+1; j++ ) {
				if (isValid(i,j,filas,columnas)) {
					if (i==x&&j==y)
						avatar.showEntity();
					else
						l.getCelda(i, j).imprimir();
				}
				else
					System.out.print("#");
			}
			System.out.print("|");
			System.out.println();
		}
		imprimirNVeces("_",2*B+5);
		avatar.imprimir();
		showInstruccions();
		showMessage(mensaje);
	}
	public void win(){


		System.out.println("888     8888888888 .d8888b.88888888888 .d88888b. 8888888b. 8888888       d8888 \n"+
		                   "888     888  888  d88P  Y88b   888    d88P"+"Y88b888   Y88b  888        d88888\n"+
		                   "888     888  888  888    888   888    888     888888    888  888       d88P888\n"+
		                   "Y88b   d88P  888  888          888    888     888888   d88P  888      d88P 888\n"+
		                   " Y88b d88P   888  888          888    888     8888888888P    888     d88P  888\n"+
		                   "  Y88o88P    888  888    888   888    888     888888 T88b    888    d88P   888\n"+
		                   "   Y888P     888   Y88b d88P   888    Y88b. .d88P888  T88b   888   d8888888888\n"+
		                   "    Y8P    8888888  Y8888P     888     Y88888P   888   T88b8888888d88P     888\nº");


	}
	private void formatear(String cadena, int cantXLin) {
		for (int i = 0; i < cadena.length(); i++) {
			if (((i % cantXLin) == 0) && cadena.charAt(i) != '\n') {
				System.out.println();
			}
			System.out.print(cadena.charAt(i));
		}
	}

	public String imprimir_historia(int decision){
		System.out.println("   |\\                     /)\n"
		                   + " /\\_\\\\__               (_//\n"
		                   + "|   `>\\-`     _._       //`)\n"
		                   + " \\ /` \\\\  _.-`:::`-._  //\n"
		                   + "  `    \\|`    :::    `|/\n"
		                   + "        |     :::     |\n"
		                   + "        |.....:::.....|\n"
		                   + "        |:::::::::::::|\n"
		                   + "        |     :::     |\n"
		                   + "        \\     :::     /\n"
		                   + "         \\    :::    /\n"
		                   + "          `-. ::: .-'\n"
		                   + "           //`:::`\\\\\n"
		                   + "          //   '   \\\\\n"
		                   + "         |/         \\\\");
		//System.out.flush();
		System.out.print("\033[H\033[2J");


		formatear("Poseidón, el senor que todo lo sabe, había decidido dar un paseo por la tierra de los humanos. Se vistió de lluvia. El cielo entonces tornó su celeste color a gris y se nubló. Cada gota viajaba libre como él. En todo el mundo llovió, y así el senor observó a la humanidad, libre como él. Sin embargo, esta libertad había sido abusada.\n"
		          + "El senor danzó, y las olas del mar danzaron con él. El baile no había hecho más que empezar. Los botes de pesca y barcos de transporte de carga pesada que flotaban los mares del Pacífico se entregaron a él. Luego el senor cantó, y las gotas de agua se convirtieron en chorros que impactaban el mar. La tierra de los humanos al senor también se entregó. \n"
		          + "Desde entonces, la tierra de los humanos ya no era más de ellos. Poseidón vio, sin embargo, que debía crear un nuevo ser. Fue así que el senor que todo lo sabe arrojó al mar huevos de varios colores. Cada huevo representaba una especie nueva.\n"
		          + "Atlas, que había sido castigado, fue llamado por Poseidón. Le entregó un saco el cual él debía cargar sobre su espalda. Poseidón ordenó a Atlas deambular las aguas en busca de los huevos. Cada huevo que Atlas encontrara debía ser descascarado hasta que el huevo del superhombre sea hallado.\n"
		          + "Personaje: Atlas\n"
		          + "Objetos a recoger con Q: huevos\n"
		          + "Objetos a usar (descascarar): huevos",
		          70);
		System.out.println();
		System.out.println("Desea iniciar el juego (SI) (NO)");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();

	}

}
