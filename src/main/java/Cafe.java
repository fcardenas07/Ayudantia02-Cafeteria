public class Cafe {
    private final Tipo tipo;
    private final Size size;
    private double gramos;
    private double mlAgua;

    public Cafe(Tipo tipo, double gramos, double mlAgua, Size size) {
        this.tipo = tipo;
        this.gramos = gramos;
        this.mlAgua = mlAgua;
        this.size = size;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getGramos() {
        return gramos;
    }

    private void setGramos(double gramos) {
        this.gramos = gramos;
    }

    public double getMlAgua() {
        return mlAgua;
    }

    public void setMlAgua(double mlAgua) {
        this.mlAgua = mlAgua;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "tipo='" + tipo + '\'' +
                ", gramos=" + gramos +
                ", mlAgua=" + mlAgua +
                ", size='" + size + '\'' +
                '}';
    }
}
