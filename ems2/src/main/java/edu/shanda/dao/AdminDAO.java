package edu.shanda.dao;

import edu.shanda.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

public interface AdminDAO {
    public void modifySaveAdmin(Admin admin);
    public Admin queryAdminByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
