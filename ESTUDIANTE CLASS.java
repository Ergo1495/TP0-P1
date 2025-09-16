import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    // Atributos privados
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;
    private List<Materia> materias;

    // Constructor sin parámetros
    public Estudiante() {
        this.materias = new ArrayList<>();
    }

    // Constructor con parámetros
    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio) {
        this();
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setCarrera(carrera);
        setPromedio(promedio);
    }

    // Getters y setters con validaciones

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre no puede estar vacío.");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido;
        } else {
            System.out.println("El apellido no puede estar vacío.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 16) {
            this.edad = edad;
        } else {
            System.out.println("La edad debe ser mayor a 16 años.");
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    // El promedio se calcula con el método calcularPromedio, no se setea directamente
    private void setPromedio(double promedio) {
        if (promedio >= 0 && promedio <= 10) {
            this.promedio = promedio;
        } else {
            System.out.println("El promedio debe estar entre 0 y 10.");
        }
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    // Métodos para gestionar materias

    public void agregarMateria(Materia materia) {
        if (materia != null) {
            materias.add(materia);
            calcularPromedio();
        }
    }

    public void calcularPromedio() {
        if (materias.isEmpty()) {
            this.promedio = 0;
            return;
        }
        double suma = 0;
        for (Materia m : materias) {
            suma += m.getCalificacion();
        }
        this.promedio = suma / materias.size();
    }
}