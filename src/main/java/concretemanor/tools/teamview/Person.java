package concretemanor.tools.teamview;

public class Person implements Comparable<Person> {

	public Person(String name) {
		this.name = name;
	}

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private Status[] status;
	public Status[] getStatus() {
		return status;
	}
	public void setStatus(Status[] status) {
		this.status = status;
	}

	public int compareTo(Person o) {
		int result = id - o.id;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		boolean result;
		if (! (o instanceof Person)) {
			result = false;
		}
		else {
			Person other = (Person)o;
			result = other.id == id;
		}

		return result;
	}
	
	@Override
	public String toString() {
		String result = String.valueOf("id="+id);
		return result;
	}
}
