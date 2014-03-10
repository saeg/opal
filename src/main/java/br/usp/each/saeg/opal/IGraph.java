package br.usp.each.saeg.opal;

import java.util.Set;

public interface IGraph<K> extends Iterable<K> {

    K get(int id);

    boolean add(K k);

    boolean remove(int id);

    boolean adjacent(int from, int to);

    Set<K> neighbors(int id);

    boolean addEdge(int from, int to);

    boolean removeEdge(int from, int to);

    IGraph<K> inverse();

    int size();

}
