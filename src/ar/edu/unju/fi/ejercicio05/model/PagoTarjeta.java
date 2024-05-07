package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago {
    private String numeroDeTarjeta;
    private LocalDate fechaDePago;
    private double montoPagado;

    public PagoTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    @Override
    public void realizarPago(double monto) {
        this.montoPagado = monto + monto * 0.15; // 15% recargo
        this.fechaDePago = LocalDate.now();
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Número de tarjeta: " + numeroDeTarjeta);
        System.out.println("Fecha de pago: " + fechaDePago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}
