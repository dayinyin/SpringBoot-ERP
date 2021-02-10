package com.SpringBoot.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
public class KaptchaController {
    /**
     * 验证码工具
     */
    @Autowired
    DefaultKaptcha defaultKaptcha;

    
    /*
     * 生成验证码方法
     * session域放入相同参数会覆盖，打到更新验证码效果
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        byte[] captcha = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            // 调用实现类创建验证码，然后把验证码放入session
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("rightCode", createText);
            
            //调用实现类创建图片
            BufferedImage bi = defaultKaptcha.createImage(createText);
            //write​(RenderedImage im, String formatName, OutputStream output)
            //使用支持给定格式的任意 ImageWriter将图像写入 OutputStream 。 
            ImageIO.write(bi, "jpg", out);
            
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //创建一个新分配的字节数组。 它的大小是此输出流的当前大小，缓冲区的有效内容已复制到其中。 
        captcha = out.toByteArray();
        
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //间接转换到ServletOutputStream，输出图片
        ServletOutputStream sout = response.getOutputStream();
        sout.write(captcha);
        sout.flush();
        sout.close();
    }


}
