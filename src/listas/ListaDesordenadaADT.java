/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author Regina Vazquez
 */
public interface ListaDesordenadaADT<T> extends ListaADT<T>{
    void addInicio(T dato);
    void addFin(T dato);
    boolean addAntesQue(T referencia, T dato);
    boolean addDespuesQue(T referencia, T dato);
}
