package edu.shanda.serviceImpl;

import edu.shanda.dao.AdminDAO;
import edu.shanda.entity.Admin;
import edu.shanda.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDAO adminDAO;

    @Override
    public void modifySaveAdmin(Admin admin) {
        adminDAO.modifySaveAdmin(admin);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryAdminByNameAndPassword(String username, String password) {
        Admin admin = adminDAO.queryAdminByNameAndPassword(username, password);
        return admin;
    }
}
