package concretemanor.tools.teamview;

public class Person {
    private int id;
    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
    }

    private String name;
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }

    private String[] status;
    public String[] getStatus() {
	return status;
    }
    public void setStatus(String[] status) {
	this.status = status;
    }
}
