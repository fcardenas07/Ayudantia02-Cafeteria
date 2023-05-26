public enum Size {
    PEQUEÑO(100), MEDIANO(200), GRANDE(300);

    private final int precio;

    Size(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
