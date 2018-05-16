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
public class ListaDesordenada<T> extends Lista<T> implements ListaDesordenadaADT<T>{
    
    public ListaDesordenada(){
        super();
    }

    @Override
    public void addInicio(T dato) {
        NodoDoble<T> nuevo;
        
        nuevo = new NodoDoble(dato);
        if(isEmpty())
            ultimo = nuevo;
        else{
            primero.setDireccionAntes(nuevo);
            nuevo.setDireccionDespues(primero);
        }
        primero = nuevo;
    }

    @Override
    public void addFin(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAntesQue(T referencia, T dato) {
        boolean agregado;
        NodoDoble<T> apuntador, nuevo;
        
        agregado = false;
        if(dato != null && referencia != null && !isEmpty()){
            if(referencia.equals(primero.getDato())){
                agregado = true;
                addInicio(dato);
            }
            else{
                apuntador = primero.getDireccionDespues();
                while(apuntador != null && !apuntador.getDato().equals(referencia))
                    apuntador = apuntador.getDireccionDespues();
                if(apuntador != null){//referencia si es un dato en la lista
                    nuevo = new NodoDoble(dato);
                    nuevo.setDireccionDespues(apuntador);
                    nuevo.setDireccionAntes(apuntador.getDireccionAntes());
                    apuntador.getDireccionAntes().setDireccionDespues(nuevo);
                    apuntador.setDireccionAntes(nuevo);
                    agregado = true;
                }
            }
        }
        return agregado;
    }

    @Override
    public boolean addDespuesQue(T referencia, T dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
