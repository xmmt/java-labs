import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FractionSet {
    private List<Fraction> fractions = new ArrayList<Fraction>();
    private Fraction maxFraction = null;
    private Fraction minFraction = null;
    private List<Pair<Fraction, Long>> countGreaterCached = new ArrayList<Pair<Fraction, Long>>();
    private List<Pair<Fraction, Long>> countLessCached = new ArrayList<Pair<Fraction, Long>>();

    public void addFraction(Fraction f) {
        fractions.add(f);
        if (maxFraction == null || f.compareTo(maxFraction) > 0)
            maxFraction = f;
        if (minFraction == null || f.compareTo(minFraction) < 0)
            minFraction = f;
        countGreaterCached.clear();
        countLessCached.clear();
    }

    public Fraction getMaxFraction() {
        return maxFraction;
    }

    public Fraction getMinFraction() {
        return minFraction;
    }

    public long countOfFractionsGreaterThan(Fraction f) {
        for (Pair<Fraction, Long> i : countGreaterCached)
            if (i.getKey().equals(f))
                return i.getValue();
        long result = 0;
        for (Fraction i : fractions) {
            if (f.compareTo(i) < 0)
                 result++;
        }
        countGreaterCached.add(new Pair<Fraction, Long>(f, result));
        if (countGreaterCached.size() > 10)
            countGreaterCached.remove(0);
        return result;
    }

    public long countOfFractionsLessThan(Fraction f) {
        for (Pair<Fraction, Long> i : countLessCached)
            if (i.getKey().equals(f))
                return i.getValue();
        long result = 0;
        for (Fraction i : fractions) {
            if (i.compareTo(f) < 0)
                result++;
        }
        countLessCached.add(new Pair<Fraction, Long>(f, result));
        if (countLessCached.size() > 10)
            countLessCached.remove(0);
        return result;
    }

    @Override
    public String toString() {
        return "FractionSet " + fractions;
    }

    public void loadFromFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] fractionsString = scanner.nextLine().split(" ");
                long n = Long.parseLong(fractionsString[0]);
                long d = Long.parseLong(fractionsString[1]);
                this.addFraction(new Fraction(n, d));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
