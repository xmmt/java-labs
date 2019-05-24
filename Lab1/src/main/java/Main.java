import java.io.File;

public class Main {
    public static void main(String[] args) {
        FractionSet fractionSet = new FractionSet();
        fractionSet.loadFromFile(new File("C:\\Users\\mkmax\\IdeaProjects\\Labs\\Lab1\\Lab1\\src\\main\\resources\\file.txt"));
        FractionSet fs2 = new FractionSet();
        fs2.addFraction(new Fraction(4, 5));
        fs2.addFraction(new Fraction(4, 6));
        fs2.addFraction(new Fraction(4, 7));
        fs2.addFraction(new Fraction(4, 8));
        fs2.addFraction(new Fraction(4, 9));

        System.out.println(fractionSet.toString());
        System.out.println(fs2.toString());

        Polynomial p1 = new Polynomial(fractionSet);
        Polynomial p2 = new Polynomial(fs2);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        Polynomial p3 = p1.add(p2);
        System.out.println(p3.toString());
    }
}
