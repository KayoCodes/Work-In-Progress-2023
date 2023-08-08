package com.example.work_in_progress_2023;

import androidx.activity.ComponentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import work_in_progress_2023.User;

public class ProfileActivity extends ComponentActivity {
    private User user = null;
    BarChart barChart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        setUpProfile();

        barChart = findViewById(R.id.bar_chart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for( int i = 1; i <10; i++){
            float value = (float)(i * 10);
            BarEntry barEntry = new BarEntry(i, value);
            barEntries.add(barEntry);
        }
        BarDataSet barDataSet = new BarDataSet(barEntries,"A");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));


    }

    public void setUpProfile(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        File f = new File(getFilesDir().getAbsolutePath()+ "/accounts.txt");
        Scanner scan;
        String str = "";
        String arr[];
        try{
            if(f.exists()){
                scan = new Scanner(openFileInput("accounts.txt"));
                while (scan.hasNextLine()){
                    str = scan.nextLine();
                    arr = str.split(",");
                    if(Integer.parseInt(arr[0]) == id){
                      user = new User(id,arr[1],Integer.parseInt(arr[2]),arr[3],Integer.parseInt(arr[4]));
                        break;
                    }
                }
                scan.close();
            }

        }catch (IOException e){
            Toast.makeText(getBaseContext(),"IOException" + e.getMessage(),Toast.LENGTH_SHORT).show();

        }
        if(user != null){
            TextView nameField = (TextView) findViewById(R.id.apName);
            TextView ageField = (TextView) findViewById(R.id.apAge);
            TextView heightField= (TextView) findViewById(R.id.apHeight);
            TextView weightField= (TextView) findViewById(R.id.apWeight);

            nameField.setText(user.getName());
            ageField.setText(String.valueOf(user.getAge()));
            heightField.setText(user.getHeight());
            weightField.setText(String.valueOf(user.getWeight()));




        }

    }
}