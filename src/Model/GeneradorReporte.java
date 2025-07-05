package Model;


import Model.Estudiante;
import Model.Curso;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class GeneradorReporte {
    public void generar(Curso curso) {
        System.out.println("\n📄 Reporte del Curso:");
        System.out.println("Nombre: " + curso.getNombre());
        System.out.println("Código: " + curso.getCodigo());
        System.out.println("Profesor: " + (curso.getProfesor() != null ? curso.getProfesor().getNombre() : "No asignado"));
        System.out.println("Estudiantes inscritos:");
        for (Estudiante est : curso.getEstudiantes()) {
            System.out.println("- " + est.getNombre() + " (" + est.getCodigo() + ")");
        }
    }
}
