package ejercicio_3;

public class Transferencia {
    private String origen;
    private String destino;
    private double monto;

    // Getters y Setters
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
               "origen='" + origen + '\'' +
               ", destino='" + destino + '\'' +
               ", monto=" + monto +
               '}';
    }
}
