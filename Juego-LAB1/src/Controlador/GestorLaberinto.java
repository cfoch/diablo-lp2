/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Celda;
import Modelo.Laberinto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author 
 */
public class GestorLaberinto {
    
    
    public GestorLaberinto(){
    
    }
    
    
    private Integer Myrandom(Integer m){
        List<Integer> lista= new ArrayList<>();
        for (int i=1;i<2*m+1;i+=2)
            lista.add(i);
        Collections.shuffle(lista);
        return lista.get(0); 
    }
    public Laberinto crear(Integer m,Integer n){
        Laberinto l= new Laberinto(m,n, Celda.Tipo.PARED);
        l.pintarArea(1, 1, 2*m-1,2*n-1 , Celda.Tipo.AFUERA);
        for (int i=2;i<2*m+1;i+=2){
            l.pintarArea(i, 1, i, 2*n, Celda.Tipo.PARED );
        }
        for (int i=2;i<2*n+1;i+=2){            
            l.pintarArea(1,i, 2*m,i,Celda.Tipo.PARED );
        }
        Stack<Celda> pila= new Stack();
        
        
        Integer x=Myrandom(m),y=Myrandom(n);
        pila.push(l.getCelda(x, y));
        l.pintarCelda(x, y, Celda.Tipo.ADENTRO);
        Celda finLab= new Celda(0,0,Celda.Tipo.MUNDO_SIGUIENTE);
        while(!pila.isEmpty()){
            Celda ultimo = pila.peek();
            x=ultimo.getX();
            y=ultimo.getY();
            Celda siguiente= l.solve(x,y);
            if (siguiente==null){
                pila.pop();
            }else{
                l.pintarArea(x, y, siguiente.getX(), siguiente.getY(), Celda.Tipo.ADENTRO);
                pila.push(siguiente);
                finLab.setX(siguiente.getX());
                finLab.setY(siguiente.getY());
            }        
        }
        l.cambiarTipo(x, y, Celda.Tipo.MUNDO_ANTERIOR);
        l.setInicio(l.getCelda(x, y));
        l.cambiarTipo(finLab.getX(), finLab.getY(), Celda.Tipo.MUNDO_SIGUIENTE);
        l.setFin(l.getCelda(finLab.getX(), finLab.getY()));
        for (int i=0;i<l.getFilas();i++)
            for (int j=0;j<l.getColumnas();j++)
                if (l.getCelda(i, j).getTipo()==Celda.Tipo.ADENTRO)
                    l.addDentro(l.getCelda(i, j));
        
        return l;
    }
        
}
