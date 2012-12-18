package concretemanor.tools.teamview.domain;

public enum Status {
    IN_OFFICE(1),
    WORKING_REMOTELY(2),
    IN_TRAINING(3),
    VACATION(4);

    private int id;

    Status(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public static Status enumFor(int value) {
        for (Status status : values()) {
            if (status.id == value)
                return status;
        }
        return null;
    }
}
