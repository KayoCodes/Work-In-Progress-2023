package work_in_progress_2023;

public class User {
    private int id;
    private String name;
    private int age;
    private String height;
    private int weight;
    private Workout[] listWorkouts;

    public User(int id, String name, int age, String height, int weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public User(int id, String name, int age, String height, int weight, Workout[] listWorkouts) {
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Workout[] getListWorkouts() {
        return listWorkouts;
    }

    public void setListWorkouts(Workout[] listWorkouts) {
        this.listWorkouts = listWorkouts;
    }
}
