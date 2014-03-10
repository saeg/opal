package br.usp.each.saeg.opal.requirement;

public class Edge extends Requirement {

    public final int from;

    public final int to;

    public Edge(final int from, final int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final Edge other = (Edge) obj;

        if (from != other.from || to != other.to)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + from;
        result = prime * result + to;
        return result;
    }

}
