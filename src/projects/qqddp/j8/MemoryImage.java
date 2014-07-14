package projects.qqddp.j8;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * @author �ٶ�java�� - ��.
 * @class ͼ�������
 * @version 2013.9.7
 */
public class MemoryImage {

	private BufferedImage buffImg;

	/**
	 * ͨ���� ����ͼ��
	 * 
	 * @param width
	 * @param height
	 */
	public MemoryImage(int width, int height) {
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}

	/**
	 * ͨ��BufferedImage���� ����ͼ��
	 * 
	 * @param buffImg
	 */
	public MemoryImage(BufferedImage buffImg) {
		this.buffImg = buffImg;
	}

	/**
	 * ͨ���ļ� ����ͼ��
	 * 
	 * @param fileName
	 */
	public MemoryImage(String fileName) {
		read(fileName);
	}

	/**
	 * ����ͼ��
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean read(String fileName) {
		try {
			buffImg = ImageIO.read(new File(fileName));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ��ͼ��ĳ����ɫֵ
	 * 
	 * @param x
	 * @param y
	 * @param rgb
	 */
	public void setRGB(int x, int y, int rgb) {
		buffImg.setRGB(x, y, rgb);
	}

	/**
	 * ȡͼ��ĳ����ɫֵ
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getRGB(int x, int y) {
		return buffImg.getRGB(x, y);
	}

	/**
	 * ȡͼ����
	 * 
	 * @return
	 */
	public int getWidth() {
		return buffImg.getWidth();
	}

	/**
	 * ȡͼ��߶�
	 * 
	 * @return
	 */
	public int getHeight() {
		return buffImg.getHeight();
	}

	/**
	 * д���ļ�
	 * 
	 * @param fileName
	 *            �ļ���
	 * @return
	 */
	public boolean write(String fileName) {
		try {
			return ImageIO.write(buffImg,
					fileName.substring(fileName.lastIndexOf('.') + 1),
					new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ����ͼ��
	 * 
	 * @return
	 */
	public MemoryImage copy() {
		return new MemoryImage(buffImg);
	}

	/**
	 * ����ͼ���������ͼ����
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return ��ͼ��
	 */
	public MemoryImage copy(int x, int y, int width, int height) {
		MemoryImage mImg = new MemoryImage(width, height);
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				mImg.setRGB(i, j, buffImg.getRGB(x + i, y + j));
			}
		}
		return mImg;
	}

	/**
	 * ����ͼ���������һ��ͼ���ָ��λ��
	 * 
	 * @param dest
	 *            Ŀ��ͼ��
	 * @param dx
	 *            Ŀ��x
	 * @param dy
	 *            Ŀ��y
	 * @param sx
	 *            Դx
	 * @param sy
	 *            Դy
	 * @param width
	 *            �����Ŀ��
	 * @param height
	 *            �����ĸ߶�
	 * @return
	 */
	public boolean copy(MemoryImage dest, int dx, int dy, int sx, int sy,
			int width, int height) {
		try {
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					dest.setRGB(dx + i, dy + j, buffImg.getRGB(sx + i, sy + j));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ����ͼ�������,��д���ļ�
	 * 
	 * @param fileName
	 *            �ļ���
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public boolean copyToFile(String fileName, int x, int y, int width,
			int height) {
		MemoryImage mImg = new MemoryImage(width, height);
		try {
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					mImg.setRGB(i, j, buffImg.getRGB(x + i, y + j));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return mImg.write(fileName);
	}

	/**
	 * �Ƚ���ͼ�Ƿ���ͬ
	 * 
	 * @param dest
	 *            Ŀ��ͼ��
	 * @return
	 */
	public boolean equals(MemoryImage dest) {
		if (dest.getWidth() != buffImg.getWidth()
				|| dest.getHeight() != buffImg.getHeight()) {
			return false;
		}
		int width = dest.getWidth();
		int height = dest.getHeight();
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (dest.getRGB(i, j) != buffImg.getRGB(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * �Ƚ���ͼ��ĳ���������Ƿ���ͬ
	 * 
	 * @param dest
	 *            Ŀ��ͼ��
	 * @param dx
	 *            Ŀ��x
	 * @param dy
	 *            Ŀ��y
	 * @param sx
	 *            Դx
	 * @param sy
	 *            Դy
	 * @param width
	 *            �ȽϵĿ��
	 * @param height
	 *            �Ƚϵĸ߶�
	 * @return
	 */
	public boolean equals(MemoryImage dest, int dx, int dy, int sx, int sy,
			int width, int height) {
		try {
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					if (dest.getRGB(i + dx, j + dy) != buffImg.getRGB(i + sx, j
							+ sy)) {
						return false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ��ͼ��Сͼ
	 * 
	 * @param subImg
	 *            Сͼ
	 * @return �ҵ����ض������,ʧ�ܷ���NULL
	 */
	public Point find(MemoryImage subImg) {
		int subWidth = subImg.getWidth();
		int subHeight = subImg.getHeight();
		int width = buffImg.getWidth();
		int height = buffImg.getHeight();
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (equals(subImg, 0, 0, i, j, subWidth, subHeight)) {
					return new Point(i, j);
				}
			}
		}
		return null;
	}

	/**
	 * ȡ��BufferedImage����
	 * 
	 * @return
	 */
	public BufferedImage getBufferedImage() {
		return buffImg;
	}
}
