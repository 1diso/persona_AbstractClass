package Ejemploherencia;

import javax.swing.JOptionPane;

public class principal {
    public static void main(String[] args)
    {
    int respuesta = 0, r = 0, codigo = 0, edad = 0;
    String apellido = "", RFC = "", nombre = "", gradoa = "";
    // Arreglo de objetos
    Persona personas[] = new Persona[2];
    int i = 0;
    do {
    respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "1.-Leer \n 2.-Imprimir \n 3.-Buscar por nombre \n 4.-Ver salario por horas \n 5.-Eliminar \n 6.-Salir \n elegir opcion"));
    switch (respuesta) {
        case 1:
                if (i >= personas.length) {
                JOptionPane.showMessageDialog(null, "No puede ingresar más datos, el arreglo está lleno.");
                break;
                }

                r = Integer.parseInt(JOptionPane.showInputDialog(null, "1.-Estudiante \n 2.-Profesor \n elegir opcion"));
                nombre = JOptionPane.showInputDialog(null, "Introduce el nombre");
                apellido = JOptionPane.showInputDialog(null, "Introduce el apellido");
                edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la edad"));
            if (r == 1) 
            {
            codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el codigo del estudiante"));
            int notaf = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la nota final"));
            Estudiante alumno = new Estudiante(nombre, apellido, edad, codigo, notaf);
            personas[i] = alumno;
            } 
        else {
             RFC = JOptionPane.showInputDialog(null, "Introduce el RFC");
            gradoa = JOptionPane.showInputDialog(null, "Introduce el grado Academico");
            int opcionDocente = Integer.parseInt(JOptionPane.showInputDialog(null, "1.- Trabaja jornada completa \n 2.- Trabaja por horas \n elegir opcion"));
        if (opcionDocente == 1)
            {
                float salario = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduce el salario"));
                int antiguedad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la antigüedad"));
                TiempoCompleto ptc = new TiempoCompleto(nombre, apellido, edad, RFC, gradoa, salario, antiguedad);
                personas[i] = ptc;
            }
        else if (opcionDocente == 2)
            {
                int numerodeHoras = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el número de horas trabajadas"));
                int pagoporHora = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el pago por hora"));
                PorHoras ph = new PorHoras(nombre, apellido, edad,RFC,gradoa, numerodeHoras, pagoporHora);
                personas[i] = ph;
            }
        }
            i++;
            break;
        case 2:
            for (int j = 0; j < i; j++) 
            {
            personas[j].mostrarDatos();
            }
            break;
        case 3:
            String nombreBuscado = JOptionPane.showInputDialog(null, "Introduce el nombre a buscar");
            boolean encontrado = false;
            for (int j = 0; j < i; j++) 
            {
            if (personas[j].getNombre().equalsIgnoreCase(nombreBuscado)) 
            {
            encontrado = true;
            break;
            }
            }
            if (encontrado) {
             JOptionPane.showMessageDialog(null, "Nombre encontrado.");
            } else {
            JOptionPane.showMessageDialog(null, "Nombre no encontrado.");
            }
            break;
            case 4:
            for (int j = 0; j < i; j++)
            {
                if (personas[j] instanceof PorHoras)
                {
                    PorHoras ph = (PorHoras) personas[j];
                    float salarioPorHoras = ph.pagoDocente();
                    JOptionPane.showMessageDialog(null, "El salario por horas de " + ph.getNombre() + " es: " + salarioPorHoras);
                }
            }
            break;
            case 5:
                String nombreEliminar = JOptionPane.showInputDialog(null, "Introduce el nombre de la persona a eliminar");
                boolean eliminado = false;
                for (int j = 0; j < i; j++) {
                if (personas[j].getNombre().equalsIgnoreCase(nombreEliminar)) {
                for (int k = j; k < i - 1; k++) {
                personas[k] = personas[k + 1];
                }
                i--;
             eliminado = true;
                break;
                }
                 }
             if (eliminado) {
            JOptionPane.showMessageDialog(null, "Persona eliminada.");
            } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada.");
            }
            break;
            }
            } while (respuesta != 6);
    }
}