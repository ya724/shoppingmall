package com.it.controller;

import com.it.utils.ImageCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @BelongsProject: Tmall
 * @BelongsPackage: com.it.controller
 * @CreateTime: 2020-11-04 15:18
 * @Description: TODO
 */
@Controller
@Slf4j
public class CodeController {

    @GetMapping(value = "/code")
    public void Captcha(HttpServletResponse response, HttpSession session) throws IOException {
        /*通知浏览器不要缓存*/
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        ImageCodeUtils vCode = new ImageCodeUtils(116, 36, 5, 10);
        String code = vCode.getCode();
        //存储session
        session.setAttribute("code", code);
        log.info("系统的验证码是："+code);
        vCode.write(response.getOutputStream());
    }

}
