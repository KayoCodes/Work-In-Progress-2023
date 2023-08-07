package work_in_progress_2023;

public class User {
    private int id;
    private String name;
    private int age;
    private double height;
    private double weight;
    private Workout[] listWorkouts;

    public User(int id, String name, int age, double height, double weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public User(int id, String name, int age, double height, double weight, Workout[] listWorkouts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.listWorkouts = listWorkouts;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Workout[] getListWorkouts() {
        return listWorkouts;
    }

    public void setListWorkouts(Workout[] listWorkouts) {
        this.listWorkouts = listWorkouts;
    }
}
