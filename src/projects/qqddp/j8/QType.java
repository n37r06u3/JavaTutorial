package projects.qqddp.j8;

import java.util.ArrayList;
import java.util.List;

public class QType {

	private List<MemoryImage> list = new ArrayList<MemoryImage>();

	public int getId(MemoryImage mImg) {
		for (int i = 0; i < list.size(); i++) {
			MemoryImage curr = list.get(i);
			if (curr.equals(mImg)) {
				return i;
			}
		}
		list.add(mImg);
		return list.size() - 1;
	}


}
