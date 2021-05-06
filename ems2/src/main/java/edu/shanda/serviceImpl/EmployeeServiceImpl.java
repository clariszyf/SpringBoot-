package edu.shanda.serviceImpl;

import edu.shanda.dao.EmployeeDAO;
import edu.shanda.entity.Employee;
import edu.shanda.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDAO employeeDAO;
    @Override
    public void modifySaveEmployee(Employee employee) {
        employeeDAO.modifySaveEmployee(employee);
    }
}
