package edu.shanda.service;

import edu.shanda.entity.Department;

import java.util.List;

public interface DepartmentService {
    public void modifySaveDepartment(Department department);
    public List<Department> queryAllDepartments();
    public void modifyUpdateDepartment(Department department);
    public Department queryDepartmentForUpdate(Integer id);
}
