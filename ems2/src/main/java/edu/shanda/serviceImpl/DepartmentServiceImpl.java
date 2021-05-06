package edu.shanda.serviceImpl;

import edu.shanda.dao.DepartmentDAO;
import edu.shanda.entity.Department;
import edu.shanda.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDAO departmentDAO;
    @Override
    public void modifySaveDepartment(Department department) {
        departmentDAO.modifySaveDepartment(department);
    }

    @Override
    public List<Department> queryAllDepartments() {
        List<Department> departments = departmentDAO.queryAllDepartments();
        return departments;
    }

    @Override
    public void modifyUpdateDepartment(Department department) {
        departmentDAO.modifyUpdateDepartment(department);
    }

    @Override
    public Department queryDepartmentForUpdate(Integer id) {
        Department department = departmentDAO.queryDepartmentForUpdate(id);
        return department;
    }
}
