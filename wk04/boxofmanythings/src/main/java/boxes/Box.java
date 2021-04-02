
package boxes;

import java.util.Objects;

public class Box<G> {
    private final G element;

    public Box(G element) {
        this.element = element;
    }

    public G get() {
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(element, box.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public String toString() {
        return "Box{" +
                "element=" + element +
                '}';
    }
}
