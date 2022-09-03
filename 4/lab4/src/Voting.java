import ir.huri.jcal.JalaliCalendar;

import java.util.*;

public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters = new ArrayList<Person>();
    private HashMap<String, HashSet<Vote>> choices = new HashMap<String, HashSet<Vote>>();

    //choice      vote
    public Voting(int type_vote, String question_vote) {
        type = type_vote;
        question = question_vote;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setChoices(HashMap<String, HashSet<Vote>> choices) {
        this.choices = choices;
    }

    public void setVoters(ArrayList<Person> voters) {
        this.voters = voters;
    }

    public ArrayList<Person> getVoters() {
        return voters;
    }

    public HashMap<String, HashSet<Vote>> getChoices() {
        return choices;
    }

    public void createChoice(String choice) {
        choices.put(choice, new HashSet<>());
    }

    public void vote(Person voter, ArrayList<String> choice) {
        voters.add(voter);

        HashSet<String> Choice = new HashSet<>();
        Choice.addAll(choice);

        JalaliCalendar time = new JalaliCalendar();
        Vote vote = new Vote(voter, time.toString());
        if (getType() == 0 && Choice.size() == 1)  {
            voters.add(voter);
            for (String i : Choice) {
                HashSet<Vote> create = choices.get(i);
                if(create == null){
                    create = new HashSet<>();
                }
                create.add(vote);
                choices.put(i, create);
            }
        } else if (getType() == 1) {
            voters.add(voter);
            for (String j : Choice) {
                HashSet<Vote> create = choices.get(j);
                if(create == null){
                    create = new HashSet<>();
                }
                create.add(vote);
                choices.put(j, create);
            }
        } else
            System.out.println("you only can have one vote");
    }

    public void printResult() {

        HashMap<String, Integer> print = new HashMap<>();
        for (Map.Entry<String, HashSet<Vote>> winning : choices.entrySet()) {
            print.put(winning.getKey(), winning.getValue().size());
        }


        int max = Collections.max(print.values());

        for (Map.Entry<String, Integer> win : print.entrySet()) {
            if (win.getValue() == max) {
                System.out.println(win.getKey() + " won the voting");
            }
        }
    }
}