
//@Author Viljami Vahvaselkä

import java.util.Random;
public class Lion extends Animal {
    public Lion(Random random){
        super(random);
        setMinRun(3.5);
        setMaxRun(4.5);
        setStopChance(0.13);
        setName("Lion");
    }
}
