/**
 * ============================================================================
 * UNIVERSIDAD ESPAM MFL - CARRERA DE COMPUTACION / SOFTWARE
 * Asignatura: Programacion Orientada a Objetos (CDS-0201)
 * Docente: Luiggi Alexander Jalca Saltos
 * Clase 02: Taller Practico - Encapsulamiento, Invariantes y Modificadores
 * ============================================================================
 * PROGRAMA PRINCIPAL DE PRUEBA (Main.java) - CODIGO PARA ESTUDIANTES
 *
 * Como ejecutar en VS Code:
 *   1. Abre la carpeta 'codigoestudiante' en Visual Studio Code.
 *   2. Abre este archivo 'Main.java'.
 *   3. Presiona el boton 'Run Java' (triangulo de play) arriba a la derecha.
 *   4. O ejecuta en la terminal integrada:
 *        javac src/*.java
 *        java -cp src Main
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=======================================================================");
        System.out.println("  ESPAM MFL - PROGRAMACION ORIENTADA A OBJETOS (CDS-0201)");
        System.out.println("  Docente: Luiggi Alexander Jalca Saltos");
        System.out.println("  Taller Practico: Encapsulamiento, Modificadores e Invariantes");
        System.out.println("=======================================================================\n");

        // --------------------------------------------------------------------
        // PARTE 1: CLASE CuentaBancaria (Demostracion Vista en Clase)
        // --------------------------------------------------------------------
        System.out.println(">>> PARTE 1: Proteccion del Estado con Encapsulamiento (CuentaBancaria)");
        System.out.println("  Creando cuenta de ahorros para Estudiante 1 con $500.00:");
        CuentaBancaria cuenta1 = new CuentaBancaria("CTA-001-2026", "Estudiante 1", 500.00);
        cuenta1.mostrarEstado();
        System.out.println();

        System.out.println("  1. Intento de operacion legitima (Deposito de $150.00):");
        cuenta1.depositar(150.00);
        System.out.println();

        System.out.println("  2. Intento de operacion invalida (Deposito negativo de -$50.00):");
        cuenta1.depositar(-50.00);
        System.out.println();

        System.out.println("  3. Intento de retiro legitimo (Retiro de $200.00):");
        cuenta1.retirar(200.00);
        System.out.println();

        System.out.println("  4. Intento de sobregiro invalido (Retiro de $900.00 excediendo saldo):");
        cuenta1.retirar(900.00);
        System.out.println();

        System.out.println("  Estado final de la cuenta protegida:");
        cuenta1.mostrarEstado();
        System.out.println();

        // --------------------------------------------------------------------
        // PARTE 2: CLASE Empleado (Taller Autonomo del Estudiante)
        // --------------------------------------------------------------------
        System.out.println(">>> PARTE 2: Prueba de Invariantes en Empleado (Taller Autonomo)");
        System.out.println("  Registrando empleado inicial de prueba:");
        Empleado emp1 = new Empleado("1312345678", "Estudiante 2", 28, 850.00, "Desarrollador Junior");
        emp1.imprimirFicha();
        System.out.println();

        // ====================================================================
        // INSTRUCCIONES PARA EL ESTUDIANTE:
        // Una vez que completes los metodos setEdad() y setSueldo() en Empleado.java,
        // observa como reacciona el sistema ante las siguientes pruebas de validacion:
        // ====================================================================

        System.out.println("  [PRUEBA 1] Intento de violar invariante de edad (14 anios - menor de edad):");
        emp1.setEdad(14);
        System.out.println();

        System.out.println("  [PRUEBA 2] Intento de violar invariante de salario ($200.00 < SBU $460.00):");
        emp1.setSueldo(200.00);
        System.out.println();

        System.out.println("  [PRUEBA 3] Asignacion de valores legitimos (29 anios, $950.00):");
        emp1.setEdad(29);
        emp1.setSueldo(950.00);
        emp1.imprimirFicha();
        System.out.println();

        System.out.println("=======================================================================");
        System.out.println("  [TALLER FINALIZADO] Revisa que las invariantes no permitan datos corruptos");
        System.out.println("=======================================================================");
    }
}
