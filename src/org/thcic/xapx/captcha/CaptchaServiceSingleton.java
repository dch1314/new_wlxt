package org.thcic.xapx.captcha;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaServiceSingleton {
    private static ImageCaptchaService instance = null;
    
    public static ImageCaptchaService getInstance(){
        return instance;
    }

    static {
    	DefaultManageableImageCaptchaService s = new DefaultManageableImageCaptchaService();
    	CaptchaEngine engine = new GmailCaptchaEngine();
    	s.setCaptchaEngine(engine);
    	instance = s;
    }
}

/*
验证：
String captcha = request.getParameter("i_captcha");
String captId = request.getSession().getId();
return CaptchaServiceSingleton.getInstance().validateResponseForID(captId, captcha);
*/