import java.io.File;

public class Main {
    public static void main(String[] args) {
        FractionSet fractionSet = new FractionSet();
        fractionSet.loadFromFile(new File("C:\\Users\\mkmax\\IdeaProjects\\Labs\\Lab1\\Lab1\\src\\main\\resources\\file.txt"));
        System.out.println(fractionSet.toString());
    }
}
