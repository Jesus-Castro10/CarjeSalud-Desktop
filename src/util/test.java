/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dominio.Paciente;
import dominio.Persona;

/**
 *
 * @author Lenovo
 */
public class test {
    public static void main(String[] args) {
        Persona pa = new Paciente();
        
        Paciente p = (Paciente) pa;
        System.out.println("p = " + p);
        
        System.out.println("pa = " + pa);
    }
}
