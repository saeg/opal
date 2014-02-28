package br.usp.each.saeg.opal.requirement;

public abstract class Use {

	public enum Type {
		P_USE, C_USE;
	}

	public final Type type;

	public Use(final Type type) {
		this.type = type;
	}

	public abstract int id();

	public PUse puse() throws ClassCastException {
		return (PUse) this;
	}

	public CUse cuse() throws ClassCastException {
		return (CUse) this;
	}

}
