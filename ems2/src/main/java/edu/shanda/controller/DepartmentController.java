package edu.shanda.controller;

import edu.shanda.entity.Department;
import edu.shanda.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("DepartmentController")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("modifySaveDepartment")
    public String modifySaveDepartment(Department department){
        departmentService.modifySaveDepartment(department);
        return "forward:/DepartmentController/queryAllDepartments";
    }

    @RequestMapping("queryAllDepartments")
    public String queryAllDepartments(HttpServletRequest request){
        List<Department> departments = departmentService.queryAllDepartments();
        request.setAttribute("list",departments);
        return "departments";
    }

    @RequestMapping("modifyUpdateDepartment")
    public String modifyUpdateDepartment(Department department){
        departmentService.modifyUpdateDepartment(department);
        return "forward:/DepartmentController/queryAllDepartments";
    }

    @RequestMapping("queryDepartmentForUpdate")
    public String queryDepartmentForUpdate(Integer department_id,HttpServletRequest request){
        Department department = departmentService.queryDepartmentForUpdate(department_id);
        request.setAttribute("department",department);
        return "updateDepartment";
    }

    @RequestMapping("queryAllDepartmentsForAddEmp")
    public @ResponseBody List<Department> queryAllDepartmentsForAddEmp(){
        List<Department> departments = departmentService.queryAllDepartments();
        return departments;
    }
}
