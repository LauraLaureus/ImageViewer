package imageProcessing;

import java.awt.image.BufferedImage;

public class ImageProcesser {

    public static BufferedImage toBorderImage(BufferedImage in) {
        int[][] rgbMatrix = Utils.to2DIntArrayFromImage(in);
        return computeImageBorders(rgbMatrix);
    }

    private static BufferedImage computeImageBorders(int[][] rgbMatrix) {
        int[][] derivativeX = processInHorizontal(rgbMatrix);
        int[][] derivativeY = processInVertical(rgbMatrix);
        return buildBorderImage(derivativeX, derivativeY);
    }

    private static int[][] processInHorizontal(int[][] rgbMatrix) {
        int[][] xRGB = new int[rgbMatrix.length][rgbMatrix[0].length];
        for (int i = 0; i < rgbMatrix.length; i++) {
            for (int j = 0; j < rgbMatrix[0].length - 1; j++) {
                xRGB[i][j] = Utils.derivative(rgbMatrix[i][j + 1], rgbMatrix[i][j], 1);
            }
        }
        return xRGB;
    }

    private static int[][] processInVertical(int[][] rgbMatrix) {
        int[][] yRGB = new int[rgbMatrix.length][rgbMatrix[0].length];
        for (int i = 0; i < rgbMatrix[0].length; i++) {
            for (int j = 0; j < rgbMatrix.length - 1; j++) {
                yRGB[j][i] = Utils.derivative(rgbMatrix[j + 1][i], rgbMatrix[j][i], 1);
            }
        }
        return yRGB;
    }

    private static int[][] sumDerivatives(int[][] derivativeX, int[][] derivativeY) {
        int[][] finalRGB = new int[derivativeX.length][derivativeY[0].length];
        for (int i = 0; i < finalRGB.length; i++) {
            for (int j = 0; j < finalRGB[0].length; j++) {
                finalRGB[i][j] = (derivativeX[i][j] + derivativeY[i][j]) % 256;
            }
        }
        return finalRGB;
    }

    private static BufferedImage buildBorderImage(int[][] derivativeX, int[][] derivativeY) {
        int[][] finalRGB = sumDerivatives(derivativeX, derivativeY);
        finalRGB = filterNonWB(finalRGB);
        return Utils.toImageFrom2DIntArray(finalRGB);
    }

    private static int[][] filterNonWB(int[][] finalRGB) {
        int[][] result = new int[finalRGB.length][finalRGB[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (finalRGB[i][j] > 0 && finalRGB[i][j] < 16777215  ) {
                    result[i][j] = 16777215;
                }
            }
        }
        return result;
    }

}
