package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JosephusProblem {

	public static void main(String[] args) {
		Integer[] input = {1,2,3,4,5,6,7,8,9,10,
							11,12,13,14,15,16,17,18,19,20,
							21,22,23,24,25,26,27,28,29,30,
							31,32,33,34,35,36,37,38,39,40};
		
		List<Integer> peopleStandings = new ArrayList<Integer>(Arrays.asList(input)); 
		int turns = 7;
		int startingPersonPositon = 0;
		findTheLastManStanding( turns-1, peopleStandings, startingPersonPositon);
	}

	private static void findTheLastManStanding( int turns, List<Integer> peopleStandings, int startingPersonPositon) {
		if(peopleStandings.size()==1) {
			System.out.println(peopleStandings.get(0)); 
			return;
		}
		
		int personToDie = (startingPersonPositon+turns)%peopleStandings.size();
		
		peopleStandings.remove(personToDie);
		
		findTheLastManStanding( turns, peopleStandings, personToDie);
		
	}
}
