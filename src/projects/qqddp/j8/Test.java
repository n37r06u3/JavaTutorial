package projects.qqddp.j8;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

import projects.qqddp.win32.Rect;
import projects.qqddp.win32.User32;


public class Test {
    public static void main(String[] args) {
        //编码设定 否则中文窗口名称获取不到
        System.setProperty("jna.encoding", "gbk");
        User32 user32 = User32.INSTANCE;
        // 类名没有获取，我们填null
        String windowName = "对对碰角色版";
        int hwnd;
        hwnd = user32.FindWindowA(null, windowName);
        System.out.println(hwnd);
        //hwnd = user32.FindWindowA("Notepad++", null);
        Rect r = new Rect();
        user32.GetWindowRect(hwnd, r);

        Rectangle rg = new Rectangle(r.left, r.top, r.right-r.left, r.bottom-r.top);
        try {
            BufferedImage image = new Robot().createScreenCapture(rg);
            MemoryImage memoryImage = new MemoryImage(image);
            memoryImage.write("C:\\Users\\siy\\Desktop\\1.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
