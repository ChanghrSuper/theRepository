package com.chr.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

public class CaptchaController {

	public String Captcha(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//设置响应类型
		response.setContentType("image/png");
		//获取验证码和图片
		String securityCode = SecurityCode.getSecurityCode();
		BufferedImage image = SecurityImage.createImage(securityCode);
		//使用值栈存入session
		request.getSession().setAttribute("securityCode",securityCode);
	
		ImageIO.write(image, "png", response.getOutputStream());
		
		return null;
	}
}
