package imageProcessing;

import java.awt.image.BufferedImage;

public class Utils {

    public static int derivative(int fxh, int fx, int h) {
        return (fxh - fx) / h;
    }

    public static BufferedImage toImageFrom2DIntArray(int[][] rgb) {
        BufferedImage theImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                int value = rgb[y][x] << 16 | rgb[y][x] << 8 | rgb[y][x];
                theImage.setRGB(x, y, value);
            }
        }
        return theImage;
    }
}
