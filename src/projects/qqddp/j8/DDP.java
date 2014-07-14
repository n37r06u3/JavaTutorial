package projects.qqddp.j8;

import projects.qqddp.win32.Mouse;
import projects.qqddp.win32.Rect;
import projects.qqddp.win32.User32;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * Created by siy on 2014/7/13.
 */
public class DDP {

    private static  User32 user32 = User32.INSTANCE;


    private  static final int X = 268;
    private  static final int Y = 95;
    private  static final int W = 384;
    private  static final int H = 384;

    public static boolean killgame(){

        int hwnd = getHwnd("对对碰角色版");

        if(hwnd <= 0) {
            System.err.println("对对碰窗口未打开.");
            return false;
        }

        MemoryImage mImg = getImage(hwnd);
        if(mImg == null) {
            System.err.println("截图失败.");
            return false;
        }
        MemoryImage gameImg = mImg.copy(X,Y,W,H);

        //gameImg.write("C:\\Users\\siy\\Desktop\\1.jpg");

        MemoryImage[][] qp = getQp(mImg);

        int[][] qtype = getType(qp);
        Search search = new Search(qtype);

        Results results = search.find();

        if(results == null) {
            System.err.println("没有找到可以消去的解.");
            return false;
        }


        Mouse.click(hwnd, X + results.x1 * 48, Y + results.y1 * 48);
        Mouse.click(hwnd, X + results.x2 * 48, Y + results.y2 *48);
        return true;

    }
    private static int getHwnd(String windowName){
        return user32.FindWindowA(null, windowName);

    }
    public static void main(String[] args) throws InterruptedException {
        //编码设定 否则中文窗口名称获取不到
        System.setProperty("jna.encoding", "gbk");


        while(true){

            boolean ret = DDP.killgame();

            Thread.sleep(100);
        }
    }

    private  static MemoryImage getImage(int hwnd){
        Rect r = new Rect();
        user32.GetWindowRect(hwnd,r);


        Rectangle rg = new Rectangle(r.left, r.top, r.right-r.left, r.bottom-r.top);
        try {
            BufferedImage image = new Robot().createScreenCapture(rg);
            return new MemoryImage(image);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static MemoryImage[][] getQp(MemoryImage mImg) {
        MemoryImage qpImg = mImg.copy(X, Y, W, H);
        // 棋盘是 8 * 8 的，所以二维数组也是 8 * 8的
        MemoryImage[][] mImgArr = new MemoryImage[8][8];

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                // 这个是得到 48 * 48的，但是刚才说了要取小一点，尽量往中间取，所以
                // 48 * 48 中间取 10 * 10好了，那就是
                mImgArr[y][x] = qpImg.copy(y * 48 + 15, x * 48 + 15, 6, 6);
                //mImgArr[y][x].write("C:\\Users\\siy\\Desktop\\ddp\\"+y+x+".jpg");
            }
        }
        return mImgArr;
    }

    private static int[][] getType(MemoryImage[][] qp) {
        int[][] xx = new int[8][8];// 保存编号

        QType qt = new QType();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                xx[y][x] = qt.getId(qp[x][y]);
                System.out.print(xx[y][x] + "  ");
            }
            System.out.println();
        }
        //System.out.println(Arrays.deepToString(qtype));
        return xx;
    }
}








































