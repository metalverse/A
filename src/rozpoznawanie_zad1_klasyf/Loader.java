/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozpoznawanie_zad1_klasyf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Michał
 */
public class Loader {
    
    int featuresAmount = 3;
    int trainingNumbersAmount = 0;
    int unknownNumbersAmount = 0;
    int classesAmount = 0;
    float[][] trainingFeatures = null;
    float[][] unknownFeatures = null;
    
    
    void LoadUnknownGroup(String filepath){
        try {
            Scanner read = new Scanner (new File(filepath));
            read.useDelimiter(";");
            unknownNumbersAmount = Integer.parseInt(read.next());
            featuresAmount = Integer.parseInt(read.next());
            classesAmount = Integer.parseInt(read.next());
            System.out.println("featuresAmount " + featuresAmount);
            unknownFeatures = new float[unknownNumbersAmount][featuresAmount+1];
            //System.out.println("Unknown features");
            for(int i=0; i<unknownNumbersAmount; i++)
            {
                for(int j=0; j<featuresAmount+1; j++){
                    /*if(j<featuresAmount-1)*/ unknownFeatures[i][j] = Float.parseFloat(read.next());
                    //else unknownFeatures[i][j] = -1;
                    //System.out.print(unknownFeatures[i][j] + "; ");
                }
                //System.out.println("Poprawny wynik: " + unknownFeatures[i][featuresAmount]);
                //System.out.println("");
            }
            read.close();
            //System.out.println("Czytam: " + unknownFeatures[unknownNumbersAmount-1][featuresAmount]);
            
        } catch (FileNotFoundException ex) {
            //s
        } catch (IOException ex) {
            //
        }
    }
    
    
    void LoadTrainingGroup(String filepath){
        try {
            System.out.println("Load " + filepath);
            Scanner read = new Scanner (new File(filepath));
            read.useDelimiter(";");
            trainingNumbersAmount = Integer.parseInt(read.next());
            featuresAmount = Integer.parseInt(read.next());
            classesAmount = Integer.parseInt(read.next());
            System.out.println("featuresAmount " + featuresAmount);
            trainingFeatures = new float[trainingNumbersAmount][featuresAmount+1];
            //System.out.println("Training features");
            for(int i=0; i<trainingNumbersAmount; i++)
            {
                for(int j=0; j<featuresAmount+1; j++){
                    trainingFeatures[i][j] = Float.parseFloat(read.next());
                    //System.out.print(trainingFeatures[i][j] + "; ");
                    //if(j==featuresAmount) System.out.println(trainingFeatures[i][j] + "; ");
                }
                //System.out.println("");
            }
            read.close();
            
            
            
        } catch (FileNotFoundException ex) {
            //s
        } catch (IOException ex) {
            //
        }
    }
    
    public void UnknownSetChart()
    {
        ChartRenderer chart = new ChartRenderer("Unknown group");
        chart.Render2(unknownFeatures, "Unknown group2");
    }
    
    public void TrainingSetChart()
    {
        ChartRenderer chart1 = new ChartRenderer("Training group");
        chart1.Render(trainingFeatures, "Training group2");
    }
    
}
