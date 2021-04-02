package boxes;

import java.util.Objects;

public class Pair<P,Q> {
    private final P elementP;
    private final Q elementQ;

    public Pair(P element1, Q element2) {
        this.elementP = element1;
        this.elementQ = element2;
    }

    public P getElementP() {
        return elementP;
    }

    public Q getElementQ() {
        return elementQ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(elementP, pair.elementP) &&
                Objects.equals(elementQ, pair.elementQ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementP, elementQ);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "elementP=" + elementP +
                ", elementQ=" + elementQ +
                '}';
    }
}
