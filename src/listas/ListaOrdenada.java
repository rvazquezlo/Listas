/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author Regina Vazquez
 */
public class ListaOrdenada<T extends Comparable <T>> extends Lista<T> implements ListaOrdenadaADT<T>{
    public ListaOrdenada(){
        super();
    }
    
    private boolean contains(T dato, Iterator<T> iterador){
        T actual;
        
        actual = iterador.next();
        if(actual.equals(dato))
            return true;
        else{
            if(actual.compareTo(dato) > 0)
                return false;
            else
                return contains(dato, iterador);
        }
    }
    
    @Override
    public boolean contains(T dato){
        boolean contains;
        
        contains = false;
        if(dato != null && !isEmpty() && dato.compareTo(ultimo.getDato()) <= 0){
            if(dato.equals(ultimo.getDato()))
                contains = true;
            else
                contains = contains(dato, iterator()); 
        }
        return contains;
    }
    
    private T remove(T dato, NodoDoble<T> actual){
        if(dato.equals(actual.getDato())){
            actual.getDireccionDespues().setDireccionAntes(actual.getDireccionAntes());
            actual.getDireccionAntes().setDireccionDespues(actual.getDireccionDespues());
            actual.setDireccionAntes(null);
            actual.setDireccionDespues(null);
            return actual.getDato();
        }
        else{
            if(dato.compareTo(actual.getDato()) < 0)
                return remove(dato, actual.getDireccionAntes());
            else
                return null;
        }
    }
    
    @Override
    public T remove(T dato){
        T removed;
        
        removed = null;
        if(dato != null && !isEmpty() && dato.compareTo(primero.getDato()) >= 0
                && dato.compareTo(ultimo.getDato()) <= 0){
            if(dato.equals(primero.getDato()))
                removed = removeFirst();
            else{
                if(dato.equals(ultimo.getDato()))
                    removed = removeLast();
                else
                    removed = remove(dato, ultimo.getDireccionAntes());
            }
        }
        return removed;
    }

    @Override
    public boolean add(T dato) {
        boolean added;
        NodoDoble<T> nuevo, apuntador;
        
        added = false;
        if(dato != null){
            if(isEmpty() || dato.compareTo(primero.getDato()) < 0){
                nuevo = new NodoDoble(dato);
                nuevo.setDireccionDespues(primero);
                if(isEmpty())
                    ultimo = nuevo;
                else
                    primero.setDireccionAntes(nuevo);
                primero = nuevo;
                added = true;
            }
            else if(dato.compareTo(ultimo.getDato()) > 0){
                added = true;
                nuevo = new NodoDoble(dato);
                nuevo.setDireccionAntes(ultimo);
                ultimo.setDireccionDespues(nuevo);
                ultimo = nuevo;
            }
            else{
                apuntador = primero;
                while(dato.compareTo(apuntador.getDato()) > 0)
                    apuntador = apuntador.getDireccionDespues();
                if(dato.compareTo(apuntador.getDato()) < 0){
                    nuevo = new NodoDoble(dato);
                    nuevo.setDireccionDespues(apuntador);
                    nuevo.setDireccionAntes(apuntador.getDireccionAntes());
                    apuntador.getDireccionAntes().setDireccionDespues(nuevo);
                    apuntador.setDireccionAntes(nuevo);
                    added = true;
                }  
            }       
        }
        return added;
    }
}
