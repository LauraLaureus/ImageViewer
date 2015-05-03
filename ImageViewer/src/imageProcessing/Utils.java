package imageProcessing;

import java.awt.image.BufferedImage;

public class Utils {

    public static int derivative(int fxh, int fx, int h) {
        return (fxh - fx) / h;
    }

    public static BufferedImage toImageFrom2DIntArray(int[][] rgb) {
        BufferedImage theImage = new BufferedImage(rgb.length,rgb[0].length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < rgb[0].length; y++) {
            for (int x = 0; x < rgb.length; x++) {
                theImage.setRGB(x, y, rgb[x][y]);
            }
        }
        return theImage;
    }

    public static int[][] to2DIntArrayFromImage(BufferedImage in) {
        int[][] result = new int[in.getWidth()][in.getHeight()];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = in.getRGB(i, j);
            }
        }
        return result;
    }

    public int from3RGBValuesTo1RGB(int r, int g, int b) {
        return r << 16 | g << 8 | b;
    }
}
