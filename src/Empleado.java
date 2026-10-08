/**
 * ============================================================================
 * UNIVERSIDAD ESPAM MFL - CARRERA DE COMPUTACION / SOFTWARE
 * Asignatura: Programacion Orientada a Objetos (CDS-0201)
 * Docente: Luiggi Alexander Jalca Saltos
 * Clase 02: Taller de Trabajo Autonomo (Material para el Estudiante)
 * ============================================================================
 * CLASE Empleado (Plantilla de Trabajo Autonomo):
 * 
 * OBJETIVO DEL ESTUDIANTE:
 * Implementar la proteccion de invariantes mediante Setters validados:
 * 1. setEdad(int nuevaEdad):
 *    - Invariante: La edad debe ser legal para trabajar en Ecuador (18 a 70 anios).
 *    - Si es valida: asignar a this.edad y retornar true.
 *    - Si es invalida: mostrar mensaje de error en consola y retornar false.
 * 
 * 2. setSueldo(double nuevoSueldo):
 *    - Invariante: El sueldo no puede ser menor al Salario Basico Unificado ($460.00).
 *    - Si es valido: asignar a this.sueldo y retornar true.
 *    - Si es invalido: mostrar mensaje de error en consola y retornar false.
 */
public class Empleado {

    // Constante institucional: Salario Basico Unificado en Ecuador
    public static final double SALARIO_BASICO_ECUADOR = 460.00;

    // Atributos privados (Encapsulamiento estricto)
    private String cedula;
    private String nombre;
    private int edad;
    private double sueldo;
    private String cargo;

    /**
     * Constructor con inicializacion protegida.
     * Utiliza los setters para aplicar las invariantes de validacion desde la creacion.
     */
    public Empleado(String cedula, String nombre, int edad, double sueldo, String cargo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.cargo = cargo;

        // Invocacion a los setters que deben validar las invariantes
        setEdad(edad);
        setSueldo(sueldo);
    }

    // ------------------------------------------------------------------------
    // GETTERS BASICOS (Lectura publica del estado interno)
    // ------------------------------------------------------------------------
    public String getCedula() {
        return this.cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public String getCargo() {
        return this.cargo;
    }

    // ------------------------------------------------------------------------
    // SETTERS BASICOS
    // ------------------------------------------------------------------------
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            System.out.println("  [ERROR] El nombre no puede estar vacio.");
        }
    }

    public void setCargo(String cargo) {
        if (cargo != null && !cargo.trim().isEmpty()) {
            this.cargo = cargo.trim();
        } else {
            System.out.println("  [ERROR] El cargo no puede estar vacio.");
        }
    }

    // ------------------------------------------------------------------------
    // ACTIVIDAD DEL ESTUDIANTE: IMPLEMENTAR INVARIANTES DE CLASE
    // ------------------------------------------------------------------------

    /**
     * TODO (ACTIVIDAD ESTUDIANTE):
     * Valida y asigna la edad del empleado.
     * 
     * Regla de Negocio / Invariante:
     * - La edad debe estar en el rango legal laboral de 18 a 70 anios inclusive.
     * - Si cumple: asignar this.edad = nuevaEdad y retornar true.
     * - Si NO cumple: imprimir mensaje de error "[ERROR INVARIANTE]...",
     *   si this.edad == 0 asignar valor por defecto seguro (18), y retornar false.
     * 
     * @param nuevaEdad La edad a asignar
     * @return true si la edad es valida y fue asignada; false en caso contrario
     */
    public boolean setEdad(int nuevaEdad) {
        // ====================================================================
        // ESCRIBE TU CODIGO AQUI:
        // PISTA: Evalua con un if (nuevaEdad >= 18 && nuevaEdad <= 70)
        // ====================================================================

        // [PLANTILLA TEMPORAL]: Reemplazar con tu implementacion completa
        this.edad = nuevaEdad; 
        return true;
    }

    /**
     * TODO (ACTIVIDAD ESTUDIANTE):
     * Valida y asigna el sueldo del empleado.
     * 
     * Regla de Negocio / Invariante:
     * - El sueldo no puede ser inferior a SALARIO_BASICO_ECUADOR ($460.00).
     * - Si cumple: asignar this.sueldo = nuevoSueldo y retornar true.
     * - Si NO cumple: imprimir mensaje de error "[ERROR INVARIANTE]...",
     *   si this.sueldo == 0 asignar valor por defecto (SALARIO_BASICO_ECUADOR), y retornar false.
     * 
     * @param nuevoSueldo El salario mensual en dolares
     * @return true si el salario cumple con la invariante; false en caso contrario
     */
    public boolean setSueldo(double nuevoSueldo) {
        // ====================================================================
        // ESCRIBE TU CODIGO AQUI:
        // PISTA: Evalua con un if (nuevoSueldo >= SALARIO_BASICO_ECUADOR)
        // ====================================================================

        // [PLANTILLA TEMPORAL]: Reemplazar con tu implementacion completa
        this.sueldo = nuevoSueldo;
        return true;
    }

    // ------------------------------------------------------------------------
    // METODO DE IMPRESION DE FICHA LABORAL
    // ------------------------------------------------------------------------
    public void imprimirFicha() {
        System.out.println("  [EMPLEADO] Cedula: " + this.cedula +
                           " | Nombre: " + this.nombre +
                           " | Edad: " + this.edad + " anios" +
                           " | Cargo: " + this.cargo +
                           " | Sueldo: $" + String.format("%.2f", this.sueldo));
    }
}
