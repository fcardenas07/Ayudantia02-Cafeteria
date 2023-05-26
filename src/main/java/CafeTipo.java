public enum CafeTipo {
    EXPRESSO(1000),
    MOKA(1200),
    CAPUCHINO(1100),
    LATTE(1300);

    private final int precio;

    CafeTipo(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}

