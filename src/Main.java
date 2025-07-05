/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jhpcp
 */
import Model.Universidad;
import Model.Profesor;
import Model.GeneradorReporte;
import Model.Estudiante;
import Model.Curso;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad("Universidad Técnica");

        while (true) {
            System.out.println("\n===== GESTIÓN UNIVERSITARIA =====");
            System.out.println("1. Agregar departamento");
            System.out.println("2. Contratar profesor");
            System.out.println("3. Crear curso y asignar profesor");
            System.out.println("4. Inscribir estudiante");
            System.out.println("5. Generar reporte de curso");
            System.out.println("6. Guardar datos");
            System.out.println("7. Cargar datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del departamento: ");
                    String nombreDep = scanner.nextLine();
                    universidad.agregarDepartamento(nombreDep);
                    System.out.println("Departamento agregado.");
                    break;

                case 2:
                    System.out.print("Nombre del profesor: ");
                    String nombreProf = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();
                    Profesor profesor = new Profesor(nombreProf, especialidad);

                    mostrarDepartamentos(universidad);
                    System.out.print("Número del departamento: ");
                    int depIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (depIndex >= 0 && depIndex < universidad.getDepartamentos().size()) {
                        universidad.getDepartamentos().get(depIndex).contratarProfesor(profesor);
                        System.out.println("Profesor contratado.");
                    } else {
                        System.out.println("Departamento inválido.");
                    }
                    break;

                case 3:
                    System.out.print("Código del curso: ");
                    String codigoCurso = scanner.nextLine();
                    System.out.print("Nombre del curso: ");
                    String nombreCurso = scanner.nextLine();

                    mostrarProfesores(universidad);
                    System.out.print("Número del profesor: ");
                    int profIndex = scanner.nextInt();
                    scanner.nextLine();

                    Curso curso = new Curso(codigoCurso, nombreCurso);
                    Profesor profSeleccionado = universidad.obtenerTodosProfesores().get(profIndex);
                    curso.asignarProfesor(profSeleccionado);

                    mostrarDepartamentos(universidad);
                    System.out.print("Número del departamento: ");
                    int deptIndex = scanner.nextInt();
                    scanner.nextLine();
                    universidad.getDepartamentos().get(deptIndex).ofrecerCurso(curso);

                    System.out.println("Curso creado y asignado.");
                    break;

                case 4:
                    System.out.print("Nombre del estudiante: ");
                    String nombreEst = scanner.nextLine();
                    System.out.print("Código del estudiante: ");
                    String codEst = scanner.nextLine();
                    Estudiante estudiante = new Estudiante(codEst, nombreEst);

                    mostrarCursos(universidad);
                    System.out.print("Número del curso: ");
                    int cursoIndex = scanner.nextInt();
                    scanner.nextLine();

                    Curso cursoSel = universidad.getDepartamentos().stream()
                            .flatMap(dep -> dep.getCursos().stream())
                            .toList().get(cursoIndex);
                    cursoSel.inscribirEstudiante(estudiante);

                    System.out.println("Estudiante inscrito.");
                    break;

                case 5:
                    mostrarCursos(universidad);
                    System.out.print("Número del curso para reporte: ");
                    int cursoRep = scanner.nextInt();
                    scanner.nextLine();

                    Curso cursoRepSel = universidad.getDepartamentos().stream()
                            .flatMap(dep -> dep.getCursos().stream())
                            .toList().get(cursoRep);
                    new GeneradorReporte().generar(cursoRepSel);
                    break;

                case 6:
                    Persistencia.guardarUniversidad(universidad, "universidad.dat");
                    break;

                case 7:
                    Universidad cargada = Persistencia.cargarUniversidad("universidad.dat");
                    if (cargada != null) {
                        universidad = cargada;
                        System.out.println("Universidad cargada correctamente.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void mostrarDepartamentos(Universidad uni) {
        System.out.println("\nDepartamentos:");
        for (int i = 0; i < uni.getDepartamentos().size(); i++) {
            System.out.println(i + ". " + uni.getDepartamentos().get(i).getNombre());
        }
    }

    private static void mostrarProfesores(Universidad uni) {
        System.out.println("\nProfesores:");
        var lista = uni.obtenerTodosProfesores();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i).getNombre());
        }
    }

    private static void mostrarCursos(Universidad uni) {
        System.out.println("\nCursos:");
        var lista = uni.getDepartamentos().stream()
                .flatMap(dep -> dep.getCursos().stream())
                .toList();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i).getNombre() + " (" + lista.get(i).getCodigo() + ")");
        }
    }
}

