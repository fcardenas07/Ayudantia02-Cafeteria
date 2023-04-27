public class Cafe {
    private double gramos;
    private double mlAgua;
    private String tamaño;

    public Cafe(double gramos, double mlAgua, String tamaño) {
        this.gramos = gramos;
        this.mlAgua = mlAgua;
        this.tamaño = tamaño;
    }

    public double getGramos() {
        return gramos;
    }

    public double getMlAgua() {
        return mlAgua;
    }

    public String getTamaño() {
        return tamaño;
    }

    private void setGramos(double gramos) {
        this.gramos = gramos;
    }

    public void setMlAgua(double mlAgua) {
        this.mlAgua = mlAgua;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Café{" +
                "gramos=" + gramos +
                ", mlAgua=" + mlAgua +
                ", tamaño='" + tamaño + '\'' +
                '}';
    }
}
