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

public class Laberinto {

    private Integer filas;
    private Integer columnas;
    Double pct_enemigo = Math.random() / 2;
    List<Integer> niveles_enemigo = new ArrayList<>();
    ;
    Celda[][] celdas;
    private Celda inicio;
    private Celda fin;
    List<Celda> dentro = new ArrayList<>();
    List<Entidad> enemigos = new ArrayList<>();
    List<Artefacto> artefactos = new ArrayList<>();

    private Integer Myrandom(Integer ini, Integer fin) {
        List<Integer> lista = new ArrayList<>();
        for (int i = ini; i <= fin; i += 1) {
            lista.add(i);
        }
        Collections.shuffle(lista);
        return lista.get(0);
    }

    public Laberinto(Integer m, Integer n, Integer tipo) {
        filas = 2 * m + 1;
        columnas = 2 * n + 1;
        celdas = new Celda[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda(i, j, tipo);
            }
        }
    }

    public void pintarArea(Integer x, Integer y, Integer x1, Integer y1, Integer tipo) {
        Integer xI, xF, yI, yF;
        xI = x;
        yI = y;
        xF = x1;
        yF = y1;
        if (x1 < x || y1 < y) {
            xI = x1;
            yI = y1;
            xF = x;
            yF = y;
        }
        for (int i = xI; i <= xF; i++) {
            for (int j = yI; j <= yF; j++) {
                celdas[i][j].setTipo(tipo);
            }
        }

    }

    public void pintarCelda(Integer x, Integer y, Integer tipo) {
        celdas[x][y].setTipo(tipo);
    }

    public void mostrarLaberinto() {
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                celdas[i][j].imprimir();
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public Celda getCelda(Integer x, Integer y) {
        return celdas[x][y];
    }

    public boolean esPared(Integer x, Integer y) {
        return (celdas[x][y].getTipo() == 0);
    }

    public Integer getFilas() {
        return filas;
    }

    public void setFilas(Integer filas) {
        this.filas = filas;
    }

    public Integer getColumnas() {
        return columnas;
    }

    public void setColumnas(Integer columnas) {
        this.columnas = columnas;
    }

    public void cambiarTipo(Integer x, Integer y, Integer tipo) {
        celdas[x][y].setTipo(tipo);
    }

    public Celda getInicio() {
        return inicio;
    }

    public void setInicio(Celda inicio) {
        this.inicio = inicio;
    }

    public Celda getFin() {
        return fin;
    }

    public void setFin(Celda fin) {
        this.fin = fin;
    }

    public void addDentro(Celda c) {
        dentro.add(c);
    }

    public void mostrarDentro() {
        Iterator<Celda> iterator = dentro.iterator();
        while (iterator.hasNext()) {
            iterator.next().imprimirInfo();
        }
    }

    public void anadirElementos(int n) {
        Integer numDisp = dentro.size();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < numDisp; i++) {
            index.add(i);
        }
        Collections.shuffle(index);
        int i;
        //int numEnemigos = (int) (10 * pct_enemigo * n);
        int numEnemigos = 100, numArmas = 3, numArmaduras = 1, numPociones = 2;
        for (i = 0; i < numEnemigos; i++) {
            Celda c = dentro.get(index.get(i));
            enemigos.add(new Enemigo(c.getX(), c.getY(), 0, i, "Tipo " + i));
            cambiarTipo(c.getX(), c.getY(), 5);
        }
        for (; i < numEnemigos + numArmas; i++) {
            Celda c = dentro.get(index.get(i));
            artefactos.add(new Arma(c.getX(), c.getY(), i - numEnemigos, "Tipo " + (i - numEnemigos), Myrandom(5, 10), Myrandom(10, 15)));
            cambiarTipo(c.getX(), c.getY(), 6);
        }
        for (; i < numEnemigos + numArmas + numArmaduras; i++) {
            Celda c = dentro.get(index.get(i));
            artefactos.add(new Armadura(c.getX(), c.getY(), Myrandom(20, 30), i - (numEnemigos + numArmas), "Tipo " + (i - (numEnemigos + numArmas))));
            cambiarTipo(c.getX(), c.getY(), 7);
        }
        for (; i < numEnemigos + numArmas + numArmaduras + numPociones; i++) {
            Celda c = dentro.get(index.get(i));
            artefactos.add(new PocionCuracion(c.getX(), c.getY(), Myrandom(15, 25), i - (numEnemigos + numArmas + numArmaduras), "Tipo " + (i - (numEnemigos + numArmas + numArmaduras))));
            cambiarTipo(c.getX(), c.getY(), 8);
        }
    }

    public Artefacto extraerArtefacto(Integer x, Integer y) {
        Integer t = getCelda(x, y).getTipo();
        if (t <= 5) {
            return null;//retorna null para indicar operacion invalida en la funcion que lo llamo        
        }
        Class c;
        if (t == 6) {
            c = Arma.class;
        } else if (t == 7) {
            c = Armadura.class;
        } else {
            c = PocionCuracion.class;
        }
        Iterator<Artefacto> iterator = artefactos.iterator();

        while (iterator.hasNext()) {
            Artefacto a = iterator.next();
            if (a.getClass().equals(c)) {
                if (a.getX() == x && a.getY() == y) {
                    artefactos.remove(a);
                    cambiarTipo(x, y, 2);
                    return a;
                }
            }
        }
        return null;
    }

    public Integer comprobarTipo(Integer x, Integer y) {
        if (getCelda(x, y).getTipo() == 0 || getCelda(x, y).getTipo() == 5 || getCelda(x, y).getTipo() == 6 || getCelda(x, y).getTipo() == 7 || getCelda(x, y).getTipo() == 8) { // SIN EL ENEMIGO AHORA CON EL
            return -1;
        }
        return getCelda(x, y).getTipo();
    }
    
    
   

    private boolean isValid(Integer x, Integer y, Integer m, Integer n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public Celda solve(Integer x, Integer y) {

        int[][] movs = new int[4][2];
        movs[0][0] = 2;
        movs[0][1] = 0;
        movs[1][0] = 0;
        movs[1][1] = 2;
        movs[2][0] = -2;
        movs[2][1] = 0;
        movs[3][0] = 0;
        movs[3][1] = -2;
        Integer newX, newY;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            index.add(i);
        }
        Collections.shuffle(index);
        for (int i = 0; i < 4; i++) {
            newX = x + movs[index.get(i)][0];
            newY = y + movs[index.get(i)][1];

            if (isValid(newX, newY, getFilas(), getColumnas())) {
                if (getCelda(newX, newY).getTipo() == 1) {
                    return getCelda(newX, newY);
                }
            }
        }
        return null;
    }

    //----------
    public void moverEnemigos(int av_X,int av_Y) {

        char[] movsEnemigo = new char[10];

        movsEnemigo[1] = 'D';  //DERECHA
        movsEnemigo[2] = 'A';  //IZQUIERDA
        movsEnemigo[3] = 'S';  //ABAJO
        movsEnemigo[4] = 'W';  //ARRIBA

        Integer respuesta =-1;
        Integer posX,posY;
        
        List<Integer>  index= new ArrayList<>() ;
        
        for (int i = 0; i < enemigos.size(); i++) {
            
            for (int j=0;j<4;j++)
                index.add(j);
            Collections.shuffle(index);
            
            posX = enemigos.get(i).getX();
            posY = enemigos.get(i).getY();
            if (index.get(0) == 1) {
                enemigos.get(i).setDireccion('E');
                respuesta = comprobarTipo(enemigos.get(i).getX(), enemigos.get(i).getY() + 1);
                if ((enemigos.get(i).getX()==av_X && (enemigos.get(i).getY() + 1)==av_Y)) respuesta =-1;
                if (respuesta != -1) {
                    enemigos.get(i).setY((Integer) (enemigos.get(i).getY() + 1));
                }
            } else if (index.get(0) == 2) {
                enemigos.get(i).setDireccion('O');
                respuesta = comprobarTipo(enemigos.get(i).getX(), enemigos.get(i).getY() - 1);
                if ((enemigos.get(i).getX()==av_X && (enemigos.get(i).getY() - 1)==av_Y)) respuesta =-1;
                if (respuesta != -1) {
                    enemigos.get(i).setY((Integer) (enemigos.get(i).getY() - 1));
                }
            } else if (index.get(0) == 3) {
                enemigos.get(i).setDireccion('S');
                respuesta = comprobarTipo(enemigos.get(i).getX() + 1, enemigos.get(i).getY());
                if (((enemigos.get(i).getX()+1)==av_X && (enemigos.get(i).getY())==av_Y)) respuesta =-1;
                if (respuesta != -1) {
                    enemigos.get(i).setX((Integer) (enemigos.get(i).getX() + 1));
                }
            } else if (index.get(0) == 4) {
                enemigos.get(i).setDireccion('N');
                respuesta = comprobarTipo(enemigos.get(i).getX() - 1, enemigos.get(i).getY());
                if (((enemigos.get(i).getX()-1)==av_X && (enemigos.get(i).getY())==av_Y)) respuesta =-1;
                if (respuesta != -1) {
                    enemigos.get(i).setX((Integer) (enemigos.get(i).getX() - 1));
                }
            }
            if (respuesta != -1) {
                cambiarTipo(posX, posY, 2);
                cambiarTipo(enemigos.get(i).getX(), enemigos.get(i).getY(), 5);
            }            
        }
    }
}
