/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author Regina
 */
public abstract class Lista<T> implements ListaADT<T>{
    protected NodoDoble<T> primero;
    protected NodoDoble<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    @Override
    public String toString() {
        return "Lista{" + "primero=" + primero.toString() + ", ultimo=" + ultimo.toString() + '}';
    }

    /**
     * Pendiente
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        return true;
    }
    

    @Override
    public Iterator iterator() {
        return new IteradorLista(primero);
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public T removeFirst() {
        T eliminado;
        NodoDoble<T> auxiliar;
        
        eliminado = null;
        if(!isEmpty()){
            eliminado = primero.getDato();
            auxiliar = primero;
            primero = primero.getDireccionDespues();
            if(!isEmpty())
                primero.setDireccionAntes(null); 
            else
                ultimo = null;
            auxiliar.setDireccionDespues(null);
        }
        return eliminado;
    }

    @Override
    public T removeLast() {
        T removed;
        NodoDoble<T> auxiliar;
        
        removed = null;
        if(!isEmpty()){
            removed = ultimo.getDato();
            auxiliar = ultimo;
            ultimo = ultimo.getDireccionAntes();
            if(ultimo == null)
                primero = null;
            else
                ultimo.setDireccionDespues(null);
            auxiliar.setDireccionAntes(null);
        }
        return removed;
    }

    private T remove(T dato, NodoDoble<T> actual){
        NodoDoble<T> siguiente;
        
        siguiente = actual.getDireccionDespues();
        if(siguiente == null)//llegue al fin
            return null;
        if(actual.getDato().equals(dato)){
            actual.getDireccionAntes().setDireccionDespues(siguiente);
            siguiente.setDireccionAntes(actual.getDireccionAntes());
            actual.setDireccionAntes(null);
            actual.setDireccionDespues(null);
            return actual.getDato();
        }
        else
            return remove(dato, siguiente);
        
    }
    
    @Override
    public T remove(T dato) {
        T removed;
        
        removed = null;
        if(dato != null && !isEmpty()){
            if(primero.getDato().equals(dato)){
                removed = removeFirst();
            }
            else if(ultimo.getDato().equals(dato)){
                removed = removeLast();
            }
            else
                removed = remove(dato, primero);
        }
        return removed;
    }

    private boolean contains(T dato, Iterator<T> iterador){
        if(!iterador.hasNext())
            return false;
        if(dato.equals(iterador.next()))
            return true;
        return contains(dato, iterador);
    }
    
    @Override
    public boolean contains(T dato) {
        boolean contains;
        
        contains = false;
        if(dato != null && !isEmpty())
            contains = contains(dato, iterator());
        return contains;    
    }

    @Override
    public int calculaSize() {
        Iterator<T> iterador;
        int size;
        
        iterador = this.iterator();
        size = 0;
        while(iterador.hasNext()){
            size++;
            iterador.next();
        }
        return size;
    }

    @Override
    public T obtienePrimero() {
        T datoPrimero;
        
        datoPrimero = null;
        if(!isEmpty())
            datoPrimero = primero.getDato();
        return datoPrimero;
    }

    @Override
    public T obtieneUltimo() {
        T datoUltimo;
        
        datoUltimo = null;
        if(!isEmpty())
            datoUltimo = ultimo.getDato();
        return datoUltimo;
    }
    
    
    
    
}
