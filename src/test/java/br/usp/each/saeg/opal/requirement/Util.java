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
package br.usp.each.saeg.opal.requirement;

import br.usp.each.saeg.commons.ArrayUtils;

public class Util {

    public static boolean contains(final Node node, final Node[] nodes) {
        return ArrayUtils.contains(nodes, node);
    }

    public static boolean contains(final Edge edge, final Edge[] edges) {
        return ArrayUtils.contains(edges, edge);
    }

    public static boolean contains(final Dua dua, final Dua[] duas) {
        return ArrayUtils.contains(duas, dua);
    }

    public static Node node(final int id) {
        return new Node(id);
    }

    public static Edge edge(final int from, final int to) {
        return new Edge(from, to);
    }

    public static Dua cdua(final int def, final int use, final int var) {
        return new Dua(def, new CUse(use), var);
    }

    public static Dua pdua(final int def, final int from, final int to, final int var) {
        return new Dua(def, new PUse(from, to), var);
    }

}
