//File: NameSort.java
//Purpose: Comparator class for sorting lists of algorithms by id
//Programmer: Liam Craft - c3339847
//Date: 06/09/2020
import java.util.Comparator;

public class NameSort implements Comparator<Process>{
	//Compares the second character of two process ids.
	//Precondition: None
	//Postcondition: An integer indicating whether the two ids are equal or not is returned.
	@Override
	public int compare(Process o1, Process o2) {
		return Character.compare(o1.getId().charAt(1), o2.getId().charAt(1));
	}

}
