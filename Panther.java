

import java.util.Random;

//@Author Viljami Vahvaselkä

public class Panther extends Animal {
    public Panther(Random random){
        super(random);
        setMinRun(3.7);
        setMaxRun(5.3);
        setStopChance(0.23);
        setName("Panther");
    }
}