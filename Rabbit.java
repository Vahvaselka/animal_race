

import java.util.Random;

//@Author Viljami Vahvaselkä

public class Rabbit extends Animal {
    public Rabbit(Random random){
        super(random);
        setMinRun(0.2);
        setMaxRun(6.6);
        setStopChance(0.02);
        setName("Rabbit");
    }
}
