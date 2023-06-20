package modelo;

public enum Size {
    PEQUEÑO(50, 100, 100),
    MEDIANO(75, 150, 200),
    GRANDE(100, 200, 300);

    private final int precio;
    private final double gramos;
    private final double mlAgua;

    Size(double gramos, double mlAgua, int precio) {
        this.precio = precio;
        this.gramos = gramos;
        this.mlAgua = mlAgua;
    }

    public int getPrecio() {
        return precio;
    }
}
