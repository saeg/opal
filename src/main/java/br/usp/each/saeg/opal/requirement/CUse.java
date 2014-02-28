package br.usp.each.saeg.opal.requirement;

public class CUse extends Use {

	public final int id;

	public CUse(final int id) {
		super(Type.C_USE);
		this.id = id;
	}

	@Override
	public int id() {
		return id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		return id == ((CUse) obj).id;
	}

	@Override
	public int hashCode() {
		return 31 + id;
	}
}
