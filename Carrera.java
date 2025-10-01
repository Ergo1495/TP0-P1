import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Carrera() {
        this.estudiantes = new ArrayList<>();
    }

    public Carrera(String nombre) {
        this();
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la carrera no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            estudiantes.add(estudiante);
            estudiante.setCarrera(this);
        }
    }

    public void listarEstudiantes() {
        System.out.println("Estudiantes de la carrera " + nombre + ":");
        for (Estudiante e : estudiantes) {
            System.out.println("- " + e);
        }
    }

    public Estudiante buscarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre.trim())) {
                return e;
            }
        }
        return null;
    }
}
