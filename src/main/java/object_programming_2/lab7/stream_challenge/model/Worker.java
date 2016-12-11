package object_programming_2.lab7.stream_challenge.model;

public class Worker {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private GenderType genderType;
    private long salary;

    public Worker(int id, String firstName, String lastName, String email, String userName, GenderType genderType, long salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.genderType = genderType;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", genderType='" + genderType + '\'' +
                ", salary=" + salary +
                '}';
    }
}
