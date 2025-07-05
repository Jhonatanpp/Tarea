package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso implements Serializable {
    private String codigo;
    private String nombre;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
        if (!profesor.getCursosImpartidos().contains(this)) {
            profesor.asignarCurso(this);
        }
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            estudiante.inscribirse(this);
        }
    }

    public void desinscribirEstudiante(String codigoEstudiante) {
        estudiantes.removeIf(est -> est.getCodigo().equalsIgnoreCase(codigoEstudiante));
    }

    public void generarReporte(GeneradorReporte generador) {
        generador.generar(this);
    }

    @Override
    public String toString() {
        return "Curso: " + nombre + " (" + codigo + ") | Profesor: " +
                (profesor != null ? profesor.getNombre() : "Sin asignar");
    }
}
