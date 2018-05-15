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
public interface ListaADT<T> {
    Iterator<T> iterator();
    boolean isEmpty();
    T removeFirst();
    T removeLast();
    T remove(T dato);
    String toString();
    boolean equals(Object otro);
    boolean contains(T dato);
    int calculaSize();
    T obtienePrimero();
    T obtieneUltimo();
    
}
