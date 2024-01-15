

import java.util.Random;

//@Author Viljami Vahvaselkä

public class Dog extends Animal {
    public Dog(Random random){
        super(random);
        setMinRun(3.5);
        setMaxRun(4.1);
        setStopChance(0.09);
        setName("Dog");
    }
}
