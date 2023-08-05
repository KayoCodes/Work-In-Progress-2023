package work_in_progress_2023;

public class Exercise {

    private String name;
    private int repGoal;
    private int repActual;
    private double weightGoal;
    private double weightActual;

    public Exercise(String name, int repGoal, int repActual, double weightGoal, double weightActual) {
        this.name = name;
        this.repGoal = repGoal;
        this.repActual = repActual;
        this.weightGoal = weightGoal;
        this.weightActual = weightActual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepGoal() {
        return repGoal;
    }

    public void setRepGoal(int repGoal) {
        this.repGoal = repGoal;
    }

    public int getRepActual() {
        return repActual;
    }

    public void setRepActual(int repActual) {
        this.repActual = repActual;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public double getWeightActual() {
        return weightActual;
    }

    public void setWeightActual(double weightActual) {
        this.weightActual = weightActual;
    }
}
