package edu.shanda.controller;

import edu.shanda.entity.Employee;
import edu.shanda.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("EmployeeController")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("modifySaveEmployee")
    public String modifySaveEmployee(Employee employee, MultipartFile upload, HttpSession session) throws IOException {
        //获取目标文件夹upload的绝对路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        //绝对路径 + 文件名字 = 上传文件的路径
        File file = new File(realPath + "/" +upload.getOriginalFilename());
        //上传文件
        upload.transferTo(file);
        employee.setImages(upload.getOriginalFilename());
        employeeService.modifySaveEmployee(employee);
        return "departments";
    }
}
