package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago {
    private double montoPagado;
    private LocalDate fechaDePago;

    @Override
    public void realizarPago(double monto) {
        this.montoPagado = monto - monto * 0.10; // 10% descuento
        this.fechaDePago = LocalDate.now();
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Fecha de pago: " + fechaDePago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}
