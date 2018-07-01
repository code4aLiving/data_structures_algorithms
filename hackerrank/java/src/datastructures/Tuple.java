package datastructures;

public class Tuple<E,F> {
    final public E first;
    final public F second;

    public Tuple(E first, F second){
        this.first = first;
        this.second = second;
    }

    public E get_first() { return first; }

    public F get_second() {
        return second;
    }

    public static <E,F> Tuple<E, F> build(E first, F seccond){
        return new Tuple<>(first, seccond);
    }
}
