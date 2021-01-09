package animalshelter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cat extends Animal {

    private boolean isAgressive;
    private int hungerRatio = catHungerLimit;

    public Cat(int id,String name, int age, String gender, boolean isSterilize, double length, double weight, String place, String stateOfHealth, boolean isAgressive,String personnel) {
        super(id,name, age, gender, isSterilize, length, weight, place, stateOfHealth,personnel);
        this.isAgressive = isAgressive;

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(decraseHungerRatio, 0, 3, TimeUnit.SECONDS);
    }

    public boolean isIsAgressive() {
        return isAgressive;
    }

    public void setIsAgressive(boolean isAgressive) {
        this.isAgressive = isAgressive;
    }

    public int getHungerRatio() {
        return hungerRatio;
    }

    public void setHungerRatio(int hungerRatio) {
        this.hungerRatio = hungerRatio;
    }
    
    

    Runnable decraseHungerRatio = new Runnable() {
        public void run() {
            hungerRatio--;
        }
    };

    
    
    @Override
    public int findRemainingLifeTime() {
         return (int) (catAverageLifeTime - this.getAge());
    }

    @Override
    public int giveFood() {
       hungerRatio++;
        return hungerRatio;
    }

}
