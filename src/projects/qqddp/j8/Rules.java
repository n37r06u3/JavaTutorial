package projects.qqddp.j8;

import java.util.ArrayList;
import java.util.List;

public class Rules {

	// Ϊ�˼򵥣�3����꣬�ֱ���� int[] �� 0~5 Ԫ����
	// ��Ȼ��Ҳ����Ū������࣬Ȼ���3���������룬�����㡣

	//ֱ��public ʡ��get����
	public static final List<Integer[]> list = new ArrayList<Integer[]>();

	static {

		list.add(new Integer[] { 0, 1, 0, -1, 0, -2 });// 1
		list.add(new Integer[] { 0, -1, 0, 1, 0, 2 });// 2
		list.add(new Integer[] { -1, 0, 0, -1, 0, -2 });// 3
		list.add(new Integer[] { -1, 0, 0, 1, 0, 2 });// 4
		list.add(new Integer[] { 1, 0, 0, -1, 0, -2 });// 5
		list.add(new Integer[] { 1, 0, 0, 1, 0, 2 });// 6
		list.add(new Integer[] { 1, 0, 0, -1, 0, 1 });// 7
		list.add(new Integer[] { -1, 0, 0, -1, 0, 1 });// 8
		list.add(new Integer[] { 1, 0, -1, 0, -2, 0 });//9
		list.add(new Integer[] { -1, 0, 1, 0, 2, 0 });//10
		list.add(new Integer[] { 0, 1, -1, 0, -2, 0 });//11
		list.add(new Integer[] { 0, 1, 1, 0, 2, 0 });//12
		list.add(new Integer[] { 0, -1, -1, 0, -2, 0 });//13
		list.add(new Integer[] { 0, -1, 1, 0, 2, 0 });//14
		list.add(new Integer[] { 0, -1, -1, 0, 1, 0 });//15
		list.add(new Integer[] { 0, 1, -1, 0, 1, 0 });//16
		
	}

}














