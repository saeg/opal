package br.usp.each.saeg.opal;

import java.util.BitSet;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import br.usp.each.saeg.commons.BitSetIterator;

public class Block implements Identifiable {

    public final int id;

    private final BitSet defs = new BitSet();
    private final BitSet cuses = new BitSet();
    private final BitSet puses = new BitSet();

    private final Set<Integer> lines = new TreeSet<Integer>();

    public Block(final int id) {
        this.id = id;
    }

    public void def(final int x) {
        defs.set(x);
    }

    public void cuse(final int x) {
        cuses.set(x);
    }

    public void puse(final int x) {
        puses.set(x);
    }

    public void line(final int x) {
        lines.add(x);
    }

    public boolean isDef(final int x) {
        return defs.get(x);
    }

    public boolean isCUse(final int x) {
        return cuses.get(x);
    }

    public boolean isPUse(final int x) {
        return puses.get(x);
    }

    public boolean isLine(final int x) {
        return lines.contains(x);
    }

    public BitSetIterator defs() {
        return new BitSetIterator(defs);
    }

    public BitSetIterator cuses() {
        return new BitSetIterator(cuses);
    }

    public BitSetIterator puses() {
        return new BitSetIterator(puses);
    }

    public Set<Integer> lines() {
        return Collections.unmodifiableSet(lines);
    }

    // --- Identifiable

    @Override
    public int id() {
        return id;
    }

    @Override
    public Block clone() {
        final Block clone = new Block(id);
        clone.defs.or(defs);
        clone.puses.or(puses);
        clone.cuses.or(cuses);
        clone.lines.addAll(lines);
        return clone;
    }

}
