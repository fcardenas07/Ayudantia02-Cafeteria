public class Cafe {
    private final String tipo;
    private final String size;
    private double gramos;
    private double mlAgua;

    public Cafe(String tipo, double gramos, double mlAgua, String size) {
        this.tipo = tipo;
        this.gramos = gramos;
        this.mlAgua = mlAgua;
        this.size = size;
    }

    public String getTipo() {
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

    public String getSize() {
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
