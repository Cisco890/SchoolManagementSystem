public class Main {
    public static void main(String[] args) {
        // Crear instancias de Estudiante
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", "2000-01-01", "Matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Maria", "Lopez", "2001-02-02", "Matriculado");

        // Crear instancias de Curso
        Curso curso1 = new Curso(101, "Cálculo 1", "Curso de introducción al cálculo", 4, "1.0");
        Curso curso2 = new Curso(102, "Poo", "Curso de programación orientada a objetos", 5, "1.0");

        // Instanciar GestorAcademico
        GestorAcademico gestorAcademico = new GestorAcademico();

        // Prueba de métodos
        // Agregar estudiantes
        gestorAcademico.matricularEstudiante(estudiante1);
        gestorAcademico.matricularEstudiante(estudiante2);

        // Agregar cursos
        gestorAcademico.agregarCurso(curso1);
        gestorAcademico.agregarCurso(curso2);

        // Inscribir estudiantes en cursos
        gestorAcademico.inscribirEstudianteCurso(estudiante1, curso1.getId());
        gestorAcademico.inscribirEstudianteCurso(estudiante2, curso1.getId());

        // Intentar inscribir un estudiante que ya está inscrito en el mismo curso
        // Esto debería imprimir un mensaje
        gestorAcademico.inscribirEstudianteCurso(estudiante1, curso1.getId());

        // Desinscribir un estudiante de un curso
        gestorAcademico.desinscribirEstudianteCurso(estudiante2.getId(), curso1.getId());

        // Intentar desinscribir un estudiante que no está inscrito en el curso
        // Esto debería imprimir un mensaje
        gestorAcademico.desinscribirEstudianteCurso(estudiante2.getId(), curso1.getId());
    }
}
