package Ejemploherencia;

import java.util.*;

import javax.swing.JOptionPane;
abstract class Docentes extends Persona 
{
    protected String RFC;
    protected String gradoAcademico;
    
    public Docentes(String nombre, String apellido,int edad, String RFC, String gradoAcademico) 
    {	super(nombre,apellido,edad);
    	this.RFC=RFC;
    	this.gradoAcademico=gradoAcademico;
    }
  
    public abstract void mostrarDatos();

}