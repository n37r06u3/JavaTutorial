package projects.qqddp.j8;

public class Search {
	
	private int[][] xx;
	private int w;
	private int h;
	
	public Search(int[][] xx) {
		this.xx = xx;
		this.h = xx.length;
		this.w = xx[0].length;
	}

	
	private int cx;
	private int cy;
	private int dx;
	private int dy;
	
	/**
	 *  �ҵ�һ�Է�Ϲ���Ľⷨ
	 * @return
	 */
	public Results find() {
		
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x < w; x++) {
				
				cx = x;
				cy = y;
				
				if(_find()) {
					
					return new Results(cx, cy, dx, dy);
					
				}
				
				
			}
			
		}
		
		return null;
	}
	
	// �����ҷ�
	private boolean _find() {
		
		// ������16�ֹ���
		for(Integer[] i: Rules.list) {
			
			int x0 = i[0] + cx;
			int y0 = i[1] + cy;
			
			int x1 = i[2] + cx;
			int y1 = i[3] + cy;
			
			int x2 = i[4] + cx;
			int y2 = i[5] + cy;
			
			// ����һ��Խ��. ����̸
			if( isOut(x0, y0) ||  isOut(x1, y1) ||  isOut(x2, y2) ) {
				continue; 
			}
			
			//��û��Խ�������£��������ж� ��3��Сͼ�� �Ƿ����
			if( xx[y0][x0] == xx[y1][x1]  &&  xx[y0][x0] == xx[y2][x2] ) {
				
				dx = x0;
				dy = y0;
				
				return true;
				
			}
			
			
		}
		
		
		
		return false;
	}
	
	private boolean isOut(int x, int y) {
		return x < 0 || x >= w || y < 0 || y >= h;
	}
	
	
/*
	public static void main(String[] args) {
		
		// ���ǰ���������Ϸ���̻�ȡ������� (ǰһ�ڿ��л�ȡ)
		
		int[][] xx = { 
			{ 0, 6, 2, 3, 5, 2, 2, 4 }, 
			{ 1, 0, 5, 6, 0, 3, 4, 3 },
			{ 1, 4, 1, 1, 3, 2, 1, 3 }, 
			{ 0, 0, 1, 5, 5, 1, 4, 4 },
			{ 2, 5, 2, 3, 6, 6, 4, 1 }, 
			{ 6, 4, 6, 5, 2, 1, 5, 1 },
			{ 6, 2, 0, 0, 6, 2, 4, 4 }, 
			{ 5, 3, 4, 3, 1, 1, 3, 1 } 
		};
		
		
		Search search = new Search(xx);
		
		Results results = search.find();
		
		if(results != null) {
			System.out.println(results);
		}
		else {
			System.out.println("not found!");
		}
		
	}
	*/
}
