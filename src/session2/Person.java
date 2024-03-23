package session2;

public class Person {
    private final Integer id=1;//
    private String name;
    private Integer bornYear;
    private String phone;

    public Person() {

    }
    public Person(String name, Integer bornYear, String phone) {
        this.name = name;
        this.bornYear = bornYear;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBornYear() {
        return bornYear;
    }

    public void setBornYear(Integer bornYear) {
        this.bornYear = bornYear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", bornYear=" + bornYear +
                ", phone='" + phone + '\'' +
                '}';
    }

}
