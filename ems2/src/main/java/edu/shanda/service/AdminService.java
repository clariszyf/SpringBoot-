package edu.shanda.service;

import edu.shanda.entity.Admin;


public interface AdminService {
    public void modifySaveAdmin(Admin admin);
    public Admin queryAdminByNameAndPassword(String username, String password);
}
