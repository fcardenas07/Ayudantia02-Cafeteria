public class Te {
    private final String tipo;
    private final Size size;
    private double gramos;
    private double mlAgua;

    public Te(String tipo, Size size, double gramos, double mlAgua) {
        this.tipo = tipo;
        this.size = size;
        this.gramos = gramos;
        this.mlAgua = mlAgua;
    }

    public String getTipo() {
        return tipo;
    }

    public Size getSize() {
        return size;
    }

    public double getGramos() {
        return gramos;
    }

    public double getMlAgua() {
        return mlAgua;
    }

    public void setGramos(double gramos) {
        this.gramos = gramos;
    }

    public void setMlAgua(double mlAgua) {
        this.mlAgua = mlAgua;
    }

    @Override
    public String toString() {
        return "Te{" +
                "tipo='" + tipo + '\'' +
                ", size=" + size +
                ", gramos=" + gramos +
                ", mlAgua=" + mlAgua +
                '}';
    }
}
