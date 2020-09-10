import java.util.Comparator;

public class NameSort implements Comparator<Process>{

	@Override
	public int compare(Process o1, Process o2) {
		// TODO Auto-generated method stub
		return o2.getId().compareTo(o2.getId());
	}

}
