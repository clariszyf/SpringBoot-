package edu.shanda.controller;

import com.google.code.kaptcha.Producer;
import edu.shanda.entity.Admin;
import edu.shanda.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("AdminController")
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private Producer kaptchaProducer;

    @RequestMapping("modifySaveAdmin")
    public String modifySaveAdmin(Admin admin){
        adminService.modifySaveAdmin(admin);
        return "login";
    }

    @RequestMapping("queryAdminByNameAndPassword")
    public String queryAdminByNameAndPassword(String username,String password,String kaptcha,HttpSession session){
        Admin admin = (Admin)adminService.queryAdminByNameAndPassword(username,password);
        String kaptcha1 = (String)session.getAttribute("kaptcha");
        if(admin != null){
            if(kaptcha.equals(kaptcha1)){
                return "forward:/DepartmentController/queryAllDepartments";
            }else {
                return "login";
            }
        }else {
            return "login";
        }
    }


    @RequestMapping("/kaptcha")
    public void getKaptcha(HttpServletResponse response, HttpSession session) {
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);

        // 将验证码存入session
        session.setAttribute("kaptcha", text);

        // 将图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            //logger.error("响应验证码失败:" + e.getMessage());
            System.out.println("验证码失败");
        }
    }

}
