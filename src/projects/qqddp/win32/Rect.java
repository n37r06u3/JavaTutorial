package projects.qqddp.win32;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class Rect extends Structure{

	public int left;
	public int top;
	public int right;
	public int bottom;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"left", "top", "right", "bottom"});
    }
}
