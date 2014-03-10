package br.usp.each.saeg.opal.requirement;

public class Dua extends Requirement {

    public final int def;

    public final Use use;

    public final int var;

    public Dua(final int def, final Use use, final int var) {
        this.def = def;
        this.use = use;
        this.var = var;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final Dua other = (Dua) obj;

        if (def != other.def || var != other.var)
            return false;
        if (!use.equals(other.use))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + def;
        result = prime * result + use.hashCode();
        result = prime * result + var;
        return result;
    }

}
