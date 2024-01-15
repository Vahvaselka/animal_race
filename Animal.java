

import java.util.Random;

public abstract class Animal {

//@Author Viljami Vahvaselkä


    private Random rng;
    public Double getNextDouble() {
        return rng.nextDouble();
    }



    public Animal(Random random) {
        rng = random;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private double minRun;
    public void setMinRun(double minRun) {
        this.minRun = minRun;
    }
    private double maxRun;
    public void setMaxRun(double maxRun) {
        this.maxRun = maxRun;
    }
    private double stopChance;
    public void setStopChance(double stopChance) {
        this.stopChance = stopChance;
    }
    public double getStopChance() {
        return stopChance;
    }
    private int timeElapsedCurrent=0;
    public int getTimeElapsedCurrent() {
        return timeElapsedCurrent;
    }
    public void addTimeElapsed(int time){
    	timeElapsedCurrent+=time;
    }

    public void run(){
        addDistanceTravelled(minRun+(maxRun-minRun)*rng.nextDouble());
    }

    public boolean willRun(){
        addTimeElapsed(1);
        if (rng.nextDouble() > stopChance) {
            return true;
        }
        else{
            return false;
        }
    }
    private Double distanceTravelled = 0.0;
    public Double getDistanceTravelled(){
        return distanceTravelled;
    }
    public void addDistanceTravelled(Double distance){
        distanceTravelled+=distance;

    }

}
 