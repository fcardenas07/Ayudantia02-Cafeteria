public enum TeTipo {
    NORMAL(1000), VERDE(1200), NEGRO(1300);

    private final int precio;
    TeTipo(int precio) {
        this.precio = precio;
    }

    public int precio() {
        return precio;
    }
}
