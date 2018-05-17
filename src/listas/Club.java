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
 * @author Regina Vazquez
 */
public class Club {
    String nombre;
    ListaOrdenada<Persona> miembros;

    public Club(String nombre) {
        this.nombre = nombre;
    }

    public Club() {
        nombre = "No dado";
    }

    public String getNombre() {
        return nombre;
    }
    
        @Override
    public int hashCode() {
        int hash = 5;
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
        final Club other = (Club) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Club{" + "nombre=" + nombre + ", miembros=" + 
                miembros.toString() + '}';
    }

    public boolean agregaSocio(String nombre, char sexo, int edad){
        Persona nuevoSocio;
        boolean agregado;
        
        agregado = false;
        if(edad < 15 && (sexo == 'F' || sexo == 'M' || sexo == 'f' || sexo == 
                'm') && nombre != null){
            nuevoSocio = new Persona(nombre, sexo, edad);
            agregado = miembros.add(nuevoSocio);
        }
        return agregado;
    }
    
    public boolean eliminaSocio(String nombre){
        Persona socio;
        boolean eliminado;
        
        eliminado = false;
        if(nombre != null){
            socio = new Persona(nombre, 'f', 0);
            if(miembros.remove(socio) != null)
                eliminado = true;    
        }
        return eliminado;
    }
    
    private Persona consultaSocio(Persona socio, Iterator<Persona> iterador){
        Persona actual;
        
        if(iterador.hasNext()){//mientras sigan habiendo,
            actual = iterador.next();
            if(actual.equals(socio))//comparo
                return actual;
            else if(actual.compareTo(socio) < 0)//ver el rden alfabetico para ver si ya me pase su lugar o no
                return consultaSocio(socio, iterador);    
        }
        return null;
    }
    
    public Persona consultaSocio(String nombre){
        Persona socio;
        
        socio = null;
        if(nombre != null){
            socio = new Persona(nombre, 'f', 0);
            if(socio.compareTo(miembros.obtienePrimero()) > -1 && 
                    socio.compareTo(miembros.obtieneUltimo()) < 1)
                socio = consultaSocio(socio, miembros.iterator());//llama a recursiv   
        }
        return socio;
    }
    
    
}
