package com.example.work_in_progress_2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

import work_in_progress_2023.Exercise;

public class WorkoutActivity extends ComponentActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workouts);
        setUpButtons();
    }

    private void setUpButtons(){
        Button addEX = (Button) findViewById(R.id.add_workout);
        ImageButton profile = (ImageButton) findViewById(R.id.imageButton3);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        addEX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()){
                        createExercise();
                }else{
                    Toast.makeText(getBaseContext(),"One or more values is missing",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validation(){
        EditText exName = (EditText) findViewById(R.id.input_exercise_name);
        EditText exRG = (EditText) findViewById(R.id.input_rep_goal);
        EditText exRA = (EditText) findViewById(R.id.input_rep_actual);
        EditText exWG = (EditText) findViewById(R.id.input_weight_goal);
        EditText exWA = (EditText) findViewById(R.id.input_weight_actual);

        if(!exName.getText().toString().equals("") && !exRG.getText().toString().equals("")&& !exRA.getText().toString().equals("") &&
                !exWG.getText().toString().equals("") && !exWA.getText().toString().equals("")){
            return true;
        }
        return false;

    }

    private void createExercise(){
        EditText exName = (EditText) findViewById(R.id.input_exercise_name);
        EditText exRG = (EditText) findViewById(R.id.input_rep_goal);
        EditText exRA = (EditText) findViewById(R.id.input_rep_actual);
        EditText exWG = (EditText) findViewById(R.id.input_weight_goal);
        EditText exWA = (EditText) findViewById(R.id.input_weight_actual);

        String name = exName.getText().toString();
        int rg = Integer.parseInt(exRG.getText().toString());
        int ra = Integer.parseInt(exRA.getText().toString());
        double wg = Integer.parseInt(exWG.getText().toString());
        double wa = Integer.parseInt(exWA.getText().toString());

        Exercise ex = new Exercise(name,rg,ra,wg,wa);

        File f = new File(getFilesDir().getAbsolutePath()+"/exercises.txt");
        if(!f.exists()){
            try {
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("exercises.txt",MODE_PRIVATE));
                w.write(ex.getName() +"," + ex.getRepGoal() +"," + ex.getRepActual() + ","+ ex.getWeightGoal() + ","+ ex.getWeightActual() +",");
                w.close();
            }catch(IOException e){
                Toast.makeText(getBaseContext(),"IOException" + e.getMessage(),Toast.LENGTH_SHORT).show();
            }

        }else{
            try{
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("exercises.txt",MODE_APPEND));
                w.append(ex.getName() +"," + ex.getRepGoal() +"," + ex.getRepActual() + ","+ ex.getWeightGoal() + ","+ ex.getWeightActual() +",");
                w.close();
            }catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException" + e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        }


        ;
    }
}

