import java.util.Random;

public class Robot {

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
        java.util.Random random = new Random();
        char c1 = (char)(random.nextInt(26) + 'A');
        char c2 = (char)(random.nextInt(26) + 'A');
        char n1 = (char)(random.nextInt(9) + '0');
        char n2 = (char)(random.nextInt(9) + '0');
        char n3 = (char)(random.nextInt(9) + '0');

        return String.valueOf(c1) + c2 + n1 + n2 + n3;
    }
}
