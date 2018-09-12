package com.code.servlet;

import com.code.qr.CreateCode;
import com.code.qr.EncoderHandler;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author conshu
 * @date 2018/8/25.
 */
public class CodeServlet extends HttpServlet {

    private static final long serialVersionUID=1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code=req.getParameter("code");
        String qrcode=req.getParameter("qrcode");

        String format="gif";
        ServletOutputStream stream =resp.getOutputStream();
        try {
            CreateCode cc = new CreateCode();
            BitMatrix bitMatrix = cc.CreateCodeMthed(code, qrcode);

            EncoderHandler.writeToStream(bitMatrix, format, stream);
            stream.flush();
            stream.close();
            resp.flushBuffer();
        }catch(Exception e){
            e.printStackTrace();
        }
        stream.flush();
        stream.close();
        resp.flushBuffer();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
