import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private Carrera carrera;
    private double promedio;
    private List<Materia> materias;

    // Constructor sin parámetros
    public Estudiante() {
        this.materias = new ArrayList<>();
    }

    // Constructor con parámetros
    public Estudiante(String nombre, String apellido, int edad, Carrera carrera, double promedio) {
        this();
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setCarrera(carrera);
        setPromedio(promedio);
    }

    // Getters y Setters con validaciones

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        this.apellido = apellido.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 16) {
            throw new IllegalArgumentException("La edad debe ser mayor a 16 años");
        }
        this.edad = edad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    // El promedio se calcula a partir de las materias, pero permitimos setearlo también
    public void setPromedio(double promedio) {
        if (promedio < 0 || promedio > 10) {
            throw new IllegalArgumentException("El promedio debe estar entre 0 y 10");
        }
        this.promedio = promedio;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    // Métodos para gestionar materias

    public void agregarMateria(Materia materia) {
        if (materia != null) {
            materias.add(materia);
            calcularPromedio(); // Actualiza el promedio al agregar materia
        }
    }

    public void calcularPromedio() {
        if (materias.isEmpty()) {
            this.promedio = 0;
            return;
        }
        double suma = 0;
        int count = 0;
        for (Materia m : materias) {
            suma += m.getCalificacion();
            count++;
        }
        this.promedio = suma / count;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - Promedio: " + String.format("%.2f", promedio);
    }
}
