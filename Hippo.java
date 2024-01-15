

import java.util.Random;


//@Author Viljami Vahvaselkä

public class Hippo extends Animal {
    public Hippo(Random random){
        super(random);
        setMinRun(3.3);
        setMaxRun(3.7);
        setStopChance(0.02);
        setName("Hippo");
    }

    @Override
    public boolean willRun() {
        addTimeElapsed(1);
        if (!(getTimeElapsedCurrent()%7==0) && getNextDouble() > getStopChance()) {
            return true;
        }
        else{
            return false;
        }
    }
}
