/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Regina
 */
public abstract class Lista<T> implements ListaADT{
    protected NodoDoble<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public String toString() {
        return "Lista{" + "primero=" + primero.toString() + '}';
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
            auxiliar.setDireccionDespues(null);
        }
        return eliminado;
    }

    @Override
    public T removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculaSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
