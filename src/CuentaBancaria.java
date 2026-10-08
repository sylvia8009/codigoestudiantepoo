/**
 * ============================================================================
 * UNIVERSIDAD ESPAM MFL - CARRERA DE COMPUTACION / SOFTWARE
 * Asignatura: Programacion Orientada a Objetos (CDS-0201)
 * Docente:    Luiggi Alexander Jalca Saltos
 * Clase 02:   Fundamentos de POO, Encapsulamiento y Modificadores de Acceso
 * ============================================================================
 * CLASE CuentaBancaria:
 * Ejemplo guiado en clase que demuestra:
 * - Atributos estrictamente privados (private).
 * - Ocultamiento de informacion (Information Hiding).
 * - Metodos de negocio que validan las operaciones antes de alterar el saldo.
 */
public class CuentaBancaria {

    // 1. ATRIBUTOS PRIVADOS (Encapsulamiento)
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // 2. CONSTRUCTOR
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldoInicial >= 0.0) {
            this.saldo = saldoInicial;
        } else {
            System.out.println("  [ERROR] Saldo inicial invalido. Se asigna $0.00.");
            this.saldo = 0.0;
        }
    }

    // 3. GETTERS (Lectura controlada)
    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // 4. SETTER CON VALIDACION
    public void setTitular(String nuevoTitular) {
        if (nuevoTitular != null && !nuevoTitular.trim().isEmpty()) {
            this.titular = nuevoTitular.trim();
        } else {
            System.out.println("  [ERROR] El titular no puede estar vacio.");
        }
    }

    // 5. METODOS DE NEGOCIO (Operaciones financieras protegidas)
    public boolean depositar(double monto) {
        if (monto > 0.0) {
            this.saldo += monto;
            System.out.println("  [+] Deposito exitoso de $" + String.format("%.2f", monto) +
                               " en cuenta " + this.numeroCuenta + ". Saldo actual: $" + String.format("%.2f", this.saldo));
            return true;
        } else {
            System.out.println("  [ERROR] El monto a depositar debe ser estrictamente positivo. Intento: $" + monto);
            return false;
        }
    }

    public boolean retirar(double monto) {
        if (monto <= 0.0) {
            System.out.println("  [ERROR] El monto a retirar debe ser mayor a cero.");
            return false;
        }
        if (monto <= this.saldo) {
            this.saldo -= monto;
            System.out.println("  [-] Retiro exitoso de $" + String.format("%.2f", monto) +
                               " de cuenta " + this.numeroCuenta + ". Saldo restante: $" + String.format("%.2f", this.saldo));
            return true;
        } else {
            System.out.println("  [ERROR] Fondos insuficientes. Saldo disponible: $" + String.format("%.2f", this.saldo) +
                               " | Intento de retiro: $" + String.format("%.2f", monto));
            return false;
        }
    }

    public void mostrarEstado() {
        System.out.println("  [CUENTA BANCARIA] No: " + this.numeroCuenta +
                           " | Titular: " + this.titular +
                           " | Saldo: $" + String.format("%.2f", this.saldo));
    }
}
