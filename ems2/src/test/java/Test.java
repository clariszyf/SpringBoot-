import edu.shanda.App;
import edu.shanda.dao.AdminDAO;
import edu.shanda.dao.DepartmentDAO;
import edu.shanda.dao.EmployeeDAO;
import edu.shanda.entity.Admin;
import edu.shanda.entity.Department;
import edu.shanda.entity.Employee;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = App.class) //声明是springboot的测试类，并且指定入口类
@RunWith(SpringRunner.class)  //在工厂环境下启动测试
public class Test {
    @Resource
    private AdminDAO adminDAO;
    @Resource
    private DepartmentDAO departmentDAO;
    @Resource
    private EmployeeDAO employeeDAO;

    @org.junit.Test
    public void test1() {
        Admin admin = new Admin();
        admin.setPassword("111");
        admin.setGender("男");
        admin.setRealname("suolong");
        admin.setUsername("suolong");
        adminDAO.modifySaveAdmin(admin);
    }

    @org.junit.Test
    public void test2() {
        Admin admin = adminDAO.queryAdminByNameAndPassword("zhangsan", "000000");
        System.out.println(admin);
    }

    @org.junit.Test
    public void test3() {
        Department department = new Department();
        department.setName("销售部").setNumber(333);
        departmentDAO.modifySaveDepartment(department);
    }

    @org.junit.Test
    public void test4() {
        List<Department> departments = departmentDAO.queryAllDepartments();
        for(Department department:departments){
            System.out.println(department);
        }
    }

    @org.junit.Test
    public void test5() {
        Department department = new Department();
        department.setId(1);
        department.setName("教学部");
        departmentDAO.modifyUpdateDepartment(department);
    }

    @org.junit.Test
    public void test6() {
        Department department = departmentDAO.queryDepartmentForUpdate(2);
        System.out.println(department);
    }

    @org.junit.Test
    public void test7() {
        Employee employee = new Employee();
        employee.setAge(12).setDepartment_id(1).setImages(null).setName("gdfg").setSalary(123.0);
        employeeDAO.modifySaveEmployee(employee);
    }
}
