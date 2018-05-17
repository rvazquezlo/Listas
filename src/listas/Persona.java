/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Objects;

/**
 *
 * @author edi
 */
public class Persona implements Comparable<Persona>{
    private String nom;
    char sexo;
    private int edad;

    public Persona() {
    }

    public Persona(String nom, char gender, int edad) {
        this.nom = nom;
        this.sexo = gender;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nom + "\nSexo: " + sexo + "\nEdad: " + edad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Persona other = (Persona) obj;
//        if (this.edad != other.edad) {
//            return false;
//        }
//        if (!Objects.equals(this.nom, other.nom)) {
//            return false;
//        }
//        if (!Objects.equals(this.sexo, other.sexo)) {
//            return false;
//        }
//        return true;
//    }

    
//    @Override
//    public int compareTo(Persona otra) {
//        int comparacion;
//        
//        if(nom.compareToIgnoreCase(otra.nom) < 0 && pais.compareToIgnoreCase(
//                otra.pais) < 0 && edad < otra.edad)
//            comparacion = -1;
//        else if(nom.compareToIgnoreCase(otra.nom) > 0 && 
//                pais.compareToIgnoreCase(otra.pais) > 0 && edad > otra.edad)
//            comparacion = 1;
//        else 
//            comparacion = 0;
//        return comparacion;
//    }
    
    
    @Override
    public int compareTo(Persona otra) {//por orden alfabetico
        return nom.compareToIgnoreCase(otra.nom);
    }
    
//    @Override
//    public int compareTo(Persona otra) {//por edad
//        int comparacion;
//        
//        if(edad < otra.edad)
//            comparacion = -1;
//        else if(edad > otra.edad)
//            comparacion = 1;
//        else 
//            comparacion = 0;
//        return comparacion;
//    }
//    
}
