/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Regina Vazquez
 */
public class IteradorLista<T> implements Iterator<T>{
    
    private NodoDoble<T> actual;
    
    public IteradorLista(NodoDoble<T> inicio){
        actual = inicio;
    }
    
    public boolean hasNext(){
        return actual != null;
    }
    
    public T next(){
        T dato;
        
        if(hasNext()){
            dato = actual.getDato();
            actual = actual.getDireccionDespues();
            return dato;
        }
        throw new NoSuchElementException();
    }
    
}
