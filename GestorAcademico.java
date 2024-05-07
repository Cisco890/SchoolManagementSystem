import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Integer>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("El estudiante ya está matriculado.");
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        } else {
            System.out.println("El curso ya existe.");
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) {
        if (!inscripciones.containsKey(idCurso)) {
            inscripciones.put(idCurso, new ArrayList<>());
        }
        ArrayList<Integer> estudiantesInscritos = inscripciones.get(idCurso);
        if (!estudiantesInscritos.contains(estudiante.getId())) {
            estudiantesInscritos.add(estudiante.getId());
            inscripciones.put(idCurso, estudiantesInscritos);
        } else {
            System.out.println("El estudiante ya está inscrito en el curso.");
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) {
        if (!inscripciones.containsKey(idCurso) || !inscripciones.get(idCurso).contains(idEstudiante)) {
            System.out.println("El estudiante no está inscrito en el curso o el ID del curso no es válido.");
        }
        ArrayList<Integer> estudiantesInscritos = inscripciones.get(idCurso);
        estudiantesInscritos.remove(Integer.valueOf(idEstudiante));
        inscripciones.put(idCurso, estudiantesInscritos);
    }
}
