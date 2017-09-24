package test;

public class MainDomain {
	volatile Domain domain = new Domain(342);

	public MainDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MainDomain(Domain domain) {
		super();
		this.domain = domain;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "MainDomain [domain=" + domain + "]";
	}

}
