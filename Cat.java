

import java.util.Random;
//@Author Viljami Vahvaselkä


public class Cat extends Animal {
	private boolean catHasEaten= false;
    public Cat(Random random) {
        super(random);
        setMinRun(3.3);
        setMaxRun(3.9);
        setStopChance(0.03);
        setName("Cat");
    }
    
    
    @Override
    public boolean willRun() {
        addTimeElapsed(1);
        if (!catHasEaten) {
            if (getNextDouble() > getStopChance()) {
                return true;
            }
            else{
                catHasEaten = true;
                return false;
            }

        }
        catHasEaten = false;
        return false;
    }
}
        

       
       




