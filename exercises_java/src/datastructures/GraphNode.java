package datastructures;

import java.util.Collection;

public class GraphNode<T extends Comparable<T>> extends Node<T>  {

    protected Collection<GraphNode<T>> _neighbours;
    protected boolean _visited;
    public GraphNode(T value, Collection<GraphNode<T>> neighbours) {
        super(value);
        _neighbours = neighbours;
        _visited = false;
    }

    public GraphNode(T value){
        this(value, null);
    }

    public Collection<GraphNode<T>> get_neighbours(){
        return _neighbours;
    }

    public void visit(){
        _visited = true;
    }

    public boolean is_visited(){
        return _visited;
    }

}
