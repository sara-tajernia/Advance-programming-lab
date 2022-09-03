import ir.huri.jcal.JalaliCalendar;

public class Vote {

    private Person person;
    private String date;

    public Vote(Person person_voter, String  date_vote){
        person = person_voter;
        date = date_vote;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPerson() {
        return person;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
}
