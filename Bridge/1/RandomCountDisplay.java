import java.util.Random;

public class RandomCountDisplay extends CountDisplay {
    private Random rand = new Random();

    public RandomCountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        multiDisplay(rand.nextInt(times));
    }
}