package cz.jalasoft.jdbc;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/29/15.
 */
public class Person {

    private Integer id;
    private String name;
    private String surname;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringBuilder("Person[")
                .append(getName())
                .append(" ")
                .append(getSurname())
                .append(", ")
                .append(getEmail())
                .append("]")
                .toString();
    }
}
