import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        VotingSystem votingSystem = new VotingSystem();

        Voting voting1 = new Voting(0, "Who is going to be the next president:");           //create a new voting
        votingSystem.createVoting(voting1);
        ArrayList<String> allChoice1 = new ArrayList<>();
        voting1.createChoice("Hassan Rohani");                          //create a new option for voting
        allChoice1.add("Hassan Rohani");
        voting1.createChoice("Ebrahim Raeisi");
        allChoice1.add("Ebrahim Raeisi");

        votingSystem.printVoting(0);                               //pring question and choices

        Person person1 = new Person("Sara", "Rzaei");                //create a new person
        ArrayList<String> choice1 = new ArrayList<>();
        choice1.add("Hassan Rohani");                                   //add one of the choice to a list of vote
        voting1.vote(person1, choice1);                                 //built a new vote

        Person person2 = new Person("Tara", "Ahmadi");
        ArrayList<String> choice2 = new ArrayList<>();
        choice2.add("Ebrahim Raeisi");
        voting1.vote(person2, choice2);

        Person person3 = new Person("Fateme", "Sadeghi");
        ArrayList<String> choice3 = new ArrayList<>();
        Random rand = new Random();
        int r = rand.nextInt(allChoice1.size());
        choice3.add(allChoice1.get(r));                                  //make a random vote

        voting1.vote(person3, choice3);

        System.out.println();
        voting1.printResult();                                          //print the result of voting
        System.out.println();


        Voting voting2 = new Voting(1, "Entekhabat majles:");
        votingSystem.createVoting(voting2);
        ArrayList<String> allChoice2 = new ArrayList<>();
        voting2.createChoice("Ghalibaf");
        allChoice2.add("Ghalibaf");
        voting2.createChoice("Agha tehrani");
        allChoice2.add("Agha tehrani");
        voting2.createChoice("Mirsalim");
        allChoice2.add("Mirsalim");
        voting2.createChoice("Naderian");
        allChoice2.add("Naderian");

        votingSystem.printVoting(1);

        Person person4 = new Person("Fateme", "Mossavi");
        ArrayList<String> choice4 = new ArrayList<>();
        choice4.add("Ghalibaf");
        choice4.add("Agha tehrani");
        choice4.add("Mirsalim");
        voting2.vote(person4, choice4);;                            //add the vote by index
        votingSystem.vote(1, person4, choice4);

        Person person5 = new Person("Fateme", "Mosavi");
        ArrayList<String> choice5 = new ArrayList<>();
        choice5.add("Ghalibaf");
        choice5.add("Agha tehrani");
        voting2.vote(person5, choice5);

        Person person6 = new Person("Maryam", "Rahmati");
        ArrayList<String> choice6 = new ArrayList<>();
        choice6.add("Ghalibaf");
        voting2.vote(person6, choice6);


        System.out.println();
        voting2.printResult();
        System.out.println();

        votingSystem.printListOfVotings();                  //print all the questions



    }
}
