package com.code.qr;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;

/**
 * @author conshu
 * @date 2018/8/25.
 */
public class EncoderHandler {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    // Empty constructor
    private EncoderHandler() {

    }


    // Methods

    /**
     * 获取BufferedImage
     * @param matrix:BitMatrix
     * @return BufferedImage
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }


    /**
     * 将二维码输出到流
     * @param matrix:BitMatrix
     * @param format:图片格式
     * @param stream:OutputStream
     * @throws IOException
     */
    public static void writeToStream(BitMatrix matrix, String format,
                                     OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format "
                    + format);
        }
    }

}
