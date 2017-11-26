package datastructures;

public class Tuple<E,F> {
    private E _first;
    private F _second;

    public Tuple(E first, F second){
        _first = first;
        _second = second;
    }

    public E get_first() {
        return _first;
    }

    public F get_second() {
        return _second;
    }

    public void set_first(E value){
        _first = value;
    }

    public void set_seccond(F value){
        _second = value;
    }
}
