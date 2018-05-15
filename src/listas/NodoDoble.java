/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Objects;

/**
 *
 * @author Regina Vazquez
 */
public class NodoDoble<T> {
    private T dato;
    private NodoDoble<T> direccionAntes;
    private NodoDoble<T> direccionDespues;
    
    public NodoDoble(){
        direccionAntes = null;
        direccionDespues = null;
    }
    
    public NodoDoble(T dato){
        this();
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getDireccionAntes() {
        return direccionAntes;
    }

    public void setDireccionAntes(NodoDoble<T> direccionAntes) {
        this.direccionAntes = direccionAntes;
    }

    public NodoDoble<T> getDireccionDespues() {
        return direccionDespues;
    }

    public void setDireccionDespues(NodoDoble<T> direccionDespues) {
        this.direccionDespues = direccionDespues;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoDoble<?> other = (NodoDoble<?>) obj;
        if (!Objects.equals(this.dato, other.dato)) {
            return false;
        }
        if (!Objects.equals(this.direccionAntes, other.direccionAntes)) {
            return false;
        }
        if (!Objects.equals(this.direccionDespues, other.direccionDespues)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NodoDoble{" + "dato=" + dato + ", direccionAntes=" + direccionAntes + ", direccionDespues=" + direccionDespues + '}';
    }
    

    
}
