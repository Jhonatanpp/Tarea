package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.Curso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estudiante implements Serializable {
    private String codigo;
    private String nombre;
    private List<Curso> cursosInscritos;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cursosInscritos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void inscribirse(Curso curso) {
        if (!cursosInscritos.contains(curso)) {
            cursosInscritos.add(curso);
            curso.inscribirEstudiante(this);
        }
    }

    public void cancelarInscripcion(String codigoCurso) {
        cursosInscritos.removeIf(curso -> curso.getCodigo().equalsIgnoreCase(codigoCurso));
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + " | Código: " + codigo;
    }
}

