public class Polynomial {
    private FractionSet fractionSet = new FractionSet();

    Polynomial(FractionSet fs) {
        fractionSet = fs;
    }

    public int size() {
        return fractionSet.size();
    }

    public FractionSet getFractionSet() {
        return fractionSet;
    }

    public Polynomial add(Polynomial p) {
        FractionSet fsBig, fsSmall;
        if (fractionSet.size() > p.getFractionSet().size()) {
            fsBig = fractionSet;
            fsSmall = p.getFractionSet();
        } else {
            fsBig = p.getFractionSet();
            fsSmall = fractionSet;
        }
        FractionSet nfs = new FractionSet();
        int diff = fsBig.size() - fsSmall.size();
        for (int i = 0; i < fsBig.size(); ++i) {
            if (i >= diff) {
                nfs.addFraction(fsBig.getFractions().get(i).add(fsSmall.getFractions().get(i - diff)));
            } else {
                nfs.addFraction(fsBig.getFractions().get(i));
            }
        }
        return new Polynomial(nfs);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i + 2 < fractionSet.size(); i++)
            result += fractionSet.getFractions().get(i) + "x^" + (fractionSet.size() - 1 - i) + " + ";
        if (fractionSet.size() > 1)
            result += fractionSet.getFractions().get(fractionSet.size() - 2) + "x" + " + ";
        if (fractionSet.size() > 0)
            result += fractionSet.getFractions().get(fractionSet.size() - 1);
        return "Polynom [" + result + ']';
    }
}
