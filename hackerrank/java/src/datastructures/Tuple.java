package datastructures;

public class Tuple<E extends Comparable<E>, F extends Comparable<F>> implements Comparable<Tuple<E, F>> {
    final public E first;
    final public F second;

    public Tuple(E first, F second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public F getSecond() {
        return second;
    }

    public static <E extends Comparable<E>, F extends Comparable<F>> Tuple<E, F> build(E first, F second) {
        return new Tuple<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        Tuple other = (Tuple) o;
        return first == other.first && second == other.second;
    }

    @Override
    public int hashCode() {
        return first.hashCode() & second.hashCode();
    }

    @Override
    public int compareTo(Tuple<E, F> o) {
        int compareFirst = first.compareTo(o.first);
        return compareFirst == 0 ? second.compareTo(o.second) : compareFirst;
    }
}
