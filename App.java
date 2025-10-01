public class App {
    public static void main(String[] args) {
        // Crear carrera
        Carrera carrera = new Carrera("Programacion");

        // Crear estudiantes con constructor sin parámetros y luego setear atributos
        Estudiante est1 = new Estudiante();
        est1.setNombre("Ana");
        est1.setApellido("Gómez");
        est1.setEdad(20);
        est1.setCarrera(carrera);

        // Crear estudiantes con constructor con parámetros
        Estudiante est2 = new Estudiante("Luis", "Pérez", 22, carrera, 0);
        Estudiante est3 = new Estudiante("María", "López", 19, carrera, 0);

        // Agregar estudiantes a la carrera
        carrera.agregarEstudiante(est1);
        carrera.agregarEstudiante(est2);
        carrera.agregarEstudiante(est3);

        // Crear materias
        Materia mat1 = new Materia("Matemáticas", "MAT101", 5, 8.5);
        Materia mat2 = new Materia("Programación", "PROG201", 6, 9.0);
        Materia mat3 = new Materia("Física", "FIS301", 4, 7.5);
        Materia mat4 = new Materia("Bases de Datos", "BD401", 5, 9.5);

        // Asignar materias a estudiantes
        est1.agregarMateria(mat1);
        est1.agregarMateria(mat2);

        est2.agregarMateria(mat2);
        est2.agregarMateria(mat3);
        est2.agregarMateria(mat4);

        est3.agregarMateria(mat1);
        est3.agregarMateria(mat3);

        // Mostrar nombre y promedio de cada estudiante
        System.out.println("Nombre y promedio de estudiantes:");
        for (Estudiante e : carrera.getEstudiantes()) {
            System.out.println(e.getNombre() + " - Promedio: " + String.format("%.2f", e.getPromedio()));
        }

        System.out.println();

        // Listar todos los estudiantes de la carrera
        carrera.listarEstudiantes();

        System.out.println();

        // Buscar un estudiante por nombre
        String buscarNombre = "Luis";
        Estudiante encontrado = carrera.buscarEstudiante(buscarNombre);
        if (encontrado != null) {
            System.out.println("Estudiante encontrado: " + encontrado);
        } else {
            System.out.println("Estudiante con nombre " + buscarNombre + " no encontrado.");
        }
    }
}
