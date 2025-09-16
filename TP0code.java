public class App {
    public static void main(String[] args) {
        // Crear estudiantes con constructor sin parámetros y luego asignar atributos
        Estudiante est1 = new Estudiante();
        est1.setNombre("Ana");
        est1.setApellido("Gómez");
        est1.setEdad(20);
        est1.setCarrera("Ingeniería");
        // promedio se calcula luego

        Estudiante est2 = new Estudiante();
        est2.setNombre("Luis");
        est2.setApellido("Pérez");
        est2.setEdad(22);
        est2.setCarrera("Medicina");

        // Crear estudiante con constructor con parámetros
        Estudiante est3 = new Estudiante("María", "López", 19, "Derecho", 0);

        // Crear materias
        Materia mat1 = new Materia("Matemáticas", "MAT101", 4, 8.5);
        Materia mat2 = new Materia("Física", "FIS101", 3, 7.0);
        Materia mat3 = new Materia("Química", "QUI101", 4, 9.0);
        Materia mat4 = new Materia("Anatomía", "ANA101", 5, 8.0);
        Materia mat5 = new Materia("Constitucional", "CON101", 3, 7.5);

        // Asignar materias a estudiantes
        est1.agregarMateria(mat1);
        est1.agregarMateria(mat2);

        est2.agregarMateria(mat4);

        est3.agregarMateria(mat5);
        est3.agregarMateria(mat3);

        // Crear carrera y agregar estudiantes
        Carrera carrera = new Carrera("Ingeniería");

        carrera.agregarEstudiante(est1);
        carrera.agregarEstudiante(est2);
        carrera.agregarEstudiante(est3);

        // Mostrar nombre y promedio de cada estudiante
        System.out.println("Nombre y promedio de estudiantes:");
        Estudiante[] arregloEstudiantes = {est1, est2, est3};
        for (Estudiante e : arregloEstudiantes) {
            System.out.println(e.getNombre() + " - Promedio: " + e.getPromedio());
        }

        // Listar todos los estudiantes de la carrera
        System.out.println();
        carrera.listarEstudiantes();

        // Buscar estudiante por nombre
        String buscar = "Luis";
        Estudiante encontrado = carrera.buscarEstudiante(buscar);
        if (encontrado != null) {
            System.out.println("\nEstudiante encontrado: " + encontrado.getNombre() + " " + encontrado.getApellido());
        } else {
            System.out.println("\nEstudiante " + buscar + " no encontrado.");
        }
    }
}
