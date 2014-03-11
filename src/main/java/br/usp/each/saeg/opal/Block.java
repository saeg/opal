/**
 * OPAL - Open-source Program Analysis Library
 * Copyright (c) 2014 University of Sao Paulo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
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
