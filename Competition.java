


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


//@Author Viljami Vahvaselkä

public class Competition {

	private List<Animal> animals;         
	private Map<Animal, Integer> scoring; 
	private final double COURSE_LENGTH;   
	private Random rng;                   
	
	public List<Animal> getAnimals() {
		return animals;
	}
	
	public void setAnimals(List<Animal> anims) {
		animals = anims;
	}
	
	public Map<Animal, Integer> getScoring() {
		return scoring;
	}
	
	public void setScoring(Map<Animal, Integer> sc) {
		scoring = sc;
	}
	
	public void setRNG(Random rand) {
		rng = rand;
	}
	
	/** Use this constructor when you want everything set to default
	 * 
	 */
	public Competition() {
		this(new Random());
	}
	
	/** Use this constructor when you want the default course length, and
	 * when you want to control the random number generator
	 * @param random the random number generator to use in the application
	 */
	public Competition(Random random) {
		this(100.0, random);
	}
	
	
	/** Use this constructor when you want to specify the length of 
	 * the course yourself
	 * @param courseLength the length of the course
	 * @param random the random number generator to use in the application
	 */
	public Competition(double courseLength, Random random) {
		animals = new ArrayList<>();
		scoring = new HashMap<>();
		COURSE_LENGTH = courseLength;
		rng = random;
	}
    
    public void initializeCompetition() {
        animals.add(new Cat(rng));
        animals.add(new Dog(rng));
        animals.add(new Hippo(rng));
        animals.add(new Lion(rng));
        animals.add(new Panther(rng));
        animals.add(new Rabbit(rng));


    }

    public List<Animal> go() {
        int winnerTime=-1;
        List<Animal> winners = new ArrayList<Animal>();
        for (Animal animal : animals) {
            int currentAnimalTime = runAnimal(animal);
            if (winnerTime==-1) {
                winnerTime = currentAnimalTime;
                winners.add(animal);
            }
            else if (currentAnimalTime==winnerTime) {
                winners.add(animal);
            }
            else if (currentAnimalTime < winnerTime) {
                winnerTime = currentAnimalTime;
                winners.clear();
                winners.add(animal);
            }

        }
        displayRatings();
        getPlacings();
        System.out.println("The Winner is / The Winners are: ");
        for (Animal animal : winners) {
        System.out.println(animal.getName());
        }
        return winners;
    }
    
    public int runAnimal(Animal anim) {
        while (anim.getDistanceTravelled() < COURSE_LENGTH) {
            if (anim.willRun()) {
                anim.run();
                
            }
        }
        scoring.put(anim, anim.getTimeElapsedCurrent());
        return anim.getTimeElapsedCurrent();
    }
    public void displayRatings() {
        System.out.println("Time units for the animals are:");        System.out.println("-------------------------");
        for (Animal animal : scoring.keySet()) {        System.out.println(animal.getName()+": "+scoring.get(animal));
        }
    }
    public List<Animal> getPlacings(){
        ArrayList<Integer> intsToSort = new ArrayList<Integer>();
        for (Animal animal : scoring.keySet()) {
            intsToSort.add(scoring.get(animal));
        }
        Collections.sort(intsToSort);
       int limit = intsToSort.size();
        while (limit > 0) {
            int currentMax = 0;
            int iNow = 0;
            for (int i = 0; i < limit; i++) {
                if (intsToSort.get(i)>currentMax) {
                    currentMax=intsToSort.get(i);
                    iNow=i;
                }
            }
            int temp = intsToSort.get(limit-1);
            intsToSort.set(limit-1, intsToSort.get(iNow));
            intsToSort.set(iNow, temp);

            if (limit==0) {
                break;
            }
            limit-=1;
        }
        Map<Animal,Integer> interimScoring = new HashMap<Animal,Integer>();
        for (Animal animal : scoring.keySet()) {
            interimScoring.put(animal, scoring.get(animal));
        }

        List<Animal> readyAnimals = new ArrayList<Animal>();
        ArrayList<Animal> outcastAnimals=new ArrayList<Animal>();
        for (Integer score : intsToSort) {
            for (Animal animal : interimScoring.keySet()) {
                if (interimScoring.get(animal).equals(score)) {
                    if (outcastAnimals.contains(animal)) {
                        break;
                    }
                    readyAnimals.add(animal);
                    outcastAnimals.add(animal);
                }
            }
        }

        for (Animal animal : readyAnimals) {
            System.out.println(animal.getName());
        }

    return readyAnimals;

    }
}