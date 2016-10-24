/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozpoznawanie_zad1_klasyf;


import javax.swing.Timer;

/**
 *
 * @author Michał
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    private Timer t = null;
    MainWindow window = null;
    
    long start_time;
    long end_time;
    long difference;
    long minutes;
    long seconds;
    
    
    
    public Program()
    {
        window = new MainWindow();
        window.setVisible(true);
        window.GetData();
        /*
        Loader k = new Loader();
        System.out.print("Wczytywanie danych... ");
        start_time = System.currentTimeMillis();
        k.LoadTrainingGroup(window.traningSetFilepath);
        k.LoadUnknownGroup(window.unknownSetFilepath);
        end_time = System.currentTimeMillis();
        difference = end_time - start_time;
        minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        
        difference -= TimeUnit.MINUTES.toMillis(minutes);
        seconds = TimeUnit.MILLISECONDS.toSeconds(difference);
        difference -= TimeUnit.SECONDS.toMillis(seconds);
        System.out.print("Obliczenia WYKONANO (" + minutes + "m " + seconds + "s " + difference + "ms)");
        KNN knn = new KNN();
        System.out.println("");
        System.out.println("Obliczam...");
        start_time = System.currentTimeMillis();
        window.ShowProgressPanel(true);
        
        t = new Timer(200, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                float progress = knn.GetProgress();
                long tmpTime = System.currentTimeMillis() - getStartTime();
                tmpTime = (long) (tmpTime * 100.0/progress-tmpTime);
                minutes = TimeUnit.MILLISECONDS.toMinutes(tmpTime);
                tmpTime -= TimeUnit.MINUTES.toMillis(minutes);
                seconds = TimeUnit.MILLISECONDS.toSeconds(tmpTime);
                String estimatedTime = (minutes + "m " + seconds + "s");
                if(minutes<1000) window.SetProgress((int)progress, estimatedTime);
                else window.SetProgress((int)progress, "?");
            }
        });
        t.start();
        knn.RunKNN(k.unknownFeatures, k.trainingFeatures, 5);
        t.stop();
        window.SetProgress(100, "Finished");
        end_time = System.currentTimeMillis();
        difference = end_time - start_time;
        minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        difference -= TimeUnit.MINUTES.toMillis(minutes);
        seconds = TimeUnit.MILLISECONDS.toSeconds(difference);
        difference -= TimeUnit.SECONDS.toMillis(seconds);
        System.out.print("Obliczenia WYKONANO (" + minutes + "m " + seconds + "s " + difference + "ms)");
                */
    }
    
    public long getStartTime()
    {
     return start_time;   
    }
    
    public static void main(String[] args) {
    //public void RunProgram(){
        // TODO code application logic here
        Program p = new Program();
    }
    
}
