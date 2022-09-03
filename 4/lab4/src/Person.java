public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName_voter, String lastName_voter){
        firstName = firstName_voter;
        lastName = lastName_voter;
    }
    public void setFirstName(){
        this.firstName = firstName;
    }
    public String getFirstName(String firstName){
        return firstName;
    }
    public void setLastName(){
        this.lastName = lastName;
    }
    public String getLastName(String lastName){
        return lastName;
    }
}
