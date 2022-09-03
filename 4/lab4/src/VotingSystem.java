import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class VotingSystem {

    private ArrayList<Voting> votingList = new ArrayList<Voting>();

    public void setVotingList(ArrayList<Voting> votingList) {
        this.votingList = votingList;
    }

    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    public void createVoting(Voting voting){
        votingList.add(voting);
    }

    public void printListOfVotings(){
        Iterator<Voting> it = votingList.iterator();
        int i=1;
        while (it.hasNext()){
            System.out.println(i +") " +it.next().getQuestion());
            i++;
        }
    }
    public void printVoting(int num){

        System.out.println(votingList.get(num).getQuestion());
        for (Map.Entry<String, HashSet<Vote>> voting : votingList.get(num).getChoices().entrySet()){
            System.out.println(voting.getKey().toString());
        }
    }

    public void vote(int num, Person voter, ArrayList<String> choices){
        votingList.get(num);
        Voting voting = new Voting(votingList.get(num).getType(), votingList.get(num).getQuestion());
        voting.vote(voter, choices);
    }

    public void printResult(int num){
        votingList.get(num);
        Voting voting = new Voting(votingList.get(num).getType(), votingList.get(num).getQuestion());
        voting.printResult();
    }


}
