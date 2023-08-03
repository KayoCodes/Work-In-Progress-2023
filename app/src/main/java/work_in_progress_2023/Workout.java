package work_in_progress_2023;

import java.util.ArrayList;

public class Workout {

    private String name;
    private ArrayList <Exercise> listExercises;

    public Workout(String name, ArrayList<Exercise> listExercises) {
        this.name = name;
        this.listExercises = listExercises;
    }

    public void AddExercise(Exercise newExercise){
        listExercises.add(newExercise);
    }

    public void deleteExercise(Exercise exercise){
        listExercises.remove(exercise);
    }

    public void EditExercise(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getListExercises() {
        return listExercises;
    }

    public void setListExercises(ArrayList<Exercise> listExercises) {
        this.listExercises = listExercises;
    }
}
