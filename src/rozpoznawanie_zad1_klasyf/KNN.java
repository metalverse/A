/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozpoznawanie_zad1_klasyf;


/**
 *
 * @author Michał
 */
public class KNN {
 
    int dimensions;
    int metric;
    float progress;
    int recognized = 0;
    float result = 0;
    int[][] resultPerNumber;
    int[][] mistakeTab;
    boolean running = false;
    
    float GetProgress()
    {
        return progress;
    }
    
    float EuklidesMetric(float[] a, float[] b)
    {
        float tmp = 0;
        for(int i=0; i<dimensions; i++){
            tmp += (a[i] - b[i])*(a[i] - b[i]);
        }
        tmp = (float) Math.sqrt(tmp);
        return tmp;
    }
    
    float StreetMetric(float[] a, float[] b)
    {
        float tmp = 0;
        for(int i=0; i<dimensions; i++){
            tmp += Math.abs(a[i] - b[i]);
        }
        return tmp;
    }
    
    float CzebyszewMetric(float[] a, float[] b)
    {
        
        float tmp = 0, tmp2 = 0;
        for(int i=0; i<dimensions; i++){
            tmp2 = Math.abs(a[i] - b[i]);
            if(tmp2 > tmp) tmp = tmp2;
        }
        return tmp;
    }
    
    float MinkowskyMetric(float[] a, float[] b)
    {
        float tmp = 0, tmp2 = 0;
        for(int i=0; i<dimensions; i++){
            //tmp += (float)Math.pow(Math.abs(a[i] - b[i]),3.0f);
            tmp2 = Math.abs(a[i] - b[i]);
            tmp += tmp2*tmp2*tmp2;
        }
        tmp = (float) Math.cbrt(tmp);
        //tmp = (float)Math.pow(tmp, (1.0d/3.0d));
        return tmp;
    }
    
    float CountDistance(float[] a, float[] b)
    {   
        float distance = 0;
        switch(metric)
        {
            case 0:
                distance = EuklidesMetric(a,b);
                break;
            case 1:
                distance = StreetMetric(a,b);
                break;
            case 2:
                distance = CzebyszewMetric(a,b);
                break;
            case 3:
                distance = MinkowskyMetric(a,b);
                break;
            default:
                break;
        }
        return distance;
    }
    
    void RunKNN(float[][] unknownFeatures, float[][] trainingFeatures, int K, int metricType, int classesAmount)
    {
        running = true;
        result = 0;
        recognized = 0;
        resultPerNumber = new int[classesAmount][4]; //0-rozpoznane; 1-rozpoznane niepoprawnie; 2-nierozpoznane, 3-wszystkie
        mistakeTab = new int[classesAmount][classesAmount];
        metric = metricType;
        dimensions = unknownFeatures[0].length - 1;
        System.out.println("dimensions: " + dimensions);
        float[][] distances = new float[trainingFeatures.length][2];
        //System.out.println("Wybierz metryke: ");
        for(int i=0; i<unknownFeatures.length; i++)
        {
            if(!running) break;
            //if(i%100==0) {
            
                //System.out.println("Wykonano " + progress + "% (" + i + " z " + unknownFeatures.length + ")");
            //}
            for(int j=0; j<trainingFeatures.length; j++){
                distances[j][0] = CountDistance(trainingFeatures[j], unknownFeatures[i]);
                ///System.out.println("Distance " + distances[j][0]);
                distances[j][1] = j;                
            }
            java.util.Arrays.sort(distances, new java.util.Comparator<float[]>() {
                @Override
                public int compare(float[] a, float[] b) {
                //System.out.println(a[0] + " | " + b[0]);
                    return Float.compare(a[0], b[0]);
                }
            });
            

            int[] numbers = new int[classesAmount];
            for(int l = 0; l<K; l++)
            {
                int idx = (int) distances[l][1];
                //System.out.println(idx);
                //System.out.println("-> " + (int)trainingFeatures[idx][dimensions]);
                numbers[(int)trainingFeatures[idx][dimensions]]++;
            }
            int tmpResult = 0;
            int tmpIndex = 0;
            int tmpSum = 0;
            for(int k=0; k<10; k++){
                if(numbers[k] > tmpResult){
                    tmpResult = numbers[k];
                    tmpIndex = k;
                    tmpSum += numbers[k];
                }
            }
            if(tmpResult/tmpSum>= 0.0) //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            {
                if(tmpIndex == (int)unknownFeatures[i][dimensions]){
                    recognized++;
                    resultPerNumber[(int)unknownFeatures[i][dimensions]][0]++;
                    resultPerNumber[(int)unknownFeatures[i][dimensions]][3]++;
                    mistakeTab[(int)unknownFeatures[i][dimensions]][tmpIndex]++;
                }else{
                    resultPerNumber[(int)unknownFeatures[i][dimensions]][1]++;
                    resultPerNumber[(int)unknownFeatures[i][dimensions]][3]++;
                    mistakeTab[(int)unknownFeatures[i][dimensions]][tmpIndex]++;
                }
//unknownFeatures[i][2] = tmpIndex;
                ///*if(tmpIndex!=0) */System.out.println("Ostateczny wynik: " + tmpIndex + ". Poprawny wynik: " + unknownFeatures[i][dimensions]);
            }
            else 
            {
                resultPerNumber[(int)unknownFeatures[i][dimensions]][2]++;
                resultPerNumber[(int)unknownFeatures[i][dimensions]][3]++;
                //System.out.println("Ostateczny wynik: nieznany");
            }
            progress = (float) ((i+1)*100.0/unknownFeatures.length);
        }
        result = (float) ((recognized*1.0)/unknownFeatures.length);
        //System.out.println("Wynik: " + (recognized*1.0)/unknownFeatures.length);
        //System.out.println("Sorting...");
        /*for(int i = 0; i<trainingFeatures.length; i++){
            System.out.println(i + ": " + distances[i][0]);
        }*/
        
        //Arrays.sort (distances); 
        
    }  





}
