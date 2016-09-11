import java.util.Random;

public class Robot {

    private static final java.util.Random RANDOM = new Random();

    private String name;

    public Robot() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        this.name  = generateName();
    }

    private String generateName(){

        char c1 = getRandomUppercaseLetter();
        char c2 = getRandomUppercaseLetter();
        char n1 = getRandomNumber();
        char n2 = getRandomNumber();
        char n3 = getRandomNumber();

        return new StringBuilder()
                .append(c1)
                .append(c2)
                .append(n1)
                .append(n2)
                .append(n3)
                .toString();
    }

    private char getRandomNumber() {
        return (char)(RANDOM.nextInt(9) + '0');
    }

    private char getRandomUppercaseLetter() {
        return (char)(RANDOM.nextInt(26) + 'A');
    }

}
