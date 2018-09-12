package com.code.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.QRCode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author conshu
 * @date 2018/8/24.
 */

//生成二维码
public class CreateCode {

    public BitMatrix CreateCodeMthed(String code,String qrcode) {

        int width=300;
        int heigh=300;
        if (code!=null){width=505;heigh=50;}


        //定义二维码参数
        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);//容错等级
        hints.put(EncodeHintType.MARGIN,2);//边框

        BitMatrix bitMatrix=null;
        try {

            if (qrcode!=null){
                bitMatrix= new MultiFormatWriter().encode(qrcode,BarcodeFormat.QR_CODE,width,heigh,hints);
            }
            if (code!=null && code!=""){
                bitMatrix= new MultiFormatWriter().encode(code,BarcodeFormat.CODE_128,width,heigh,null);
            }

            /*
            String format="png";
            Path file=new File("D:/img.png").toPath();

            try {
                MatrixToImageWriter.writeToPath(bitMatrix,format,file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            */

        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitMatrix;

    }

}
