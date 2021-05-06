package edu.shanda.dao;

import edu.shanda.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    public void modifySaveDepartment(Department department);
    public List<Department> queryAllDepartments();
    public void modifyUpdateDepartment(Department department);
    public Department queryDepartmentForUpdate(Integer id);
}
