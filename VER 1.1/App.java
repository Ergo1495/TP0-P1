import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrera carrera = new Carrera("Programacion");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar estudiante por nombre");
            System.out.println("3. Listar todos los estudiantes");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    try {
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();

                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(scanner.nextLine());

                        Estudiante nuevoEstudiante = new Estudiante();
                        nuevoEstudiante.setNombre(nombre);
                        nuevoEstudiante.setApellido(apellido);
                        nuevoEstudiante.setEdad(edad);
                        nuevoEstudiante.setCarrera(carrera);
                        nuevoEstudiante.setPromedio(0);

                        carrera.agregarEstudiante(nuevoEstudiante);

                        System.out.println("Estudiante agregado correctamente.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Edad debe ser un número entero.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Ingrese el nombre del estudiante a buscar: ");
                    String nombreBuscado = scanner.nextLine();
                    Estudiante encontrado = carrera.buscarEstudiante(nombreBuscado);
                    if (encontrado != null) {
                        System.out.println("Estudiante encontrado: " + encontrado);
                    } else {
                        System.out.println("Estudiante con nombre '" + nombreBuscado + "' no encontrado.");
                    }
                    break;

                case "3":
                    carrera.listarEstudiantes();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
