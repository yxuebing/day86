import com.dao.CustomerDao;
import com.dao.LinkManDao;
import com.dao.SysRoleDao;
import com.dao.SysUserDao;
import com.pojo.Customer;
import com.pojo.LinkMan;
import com.pojo.SysRole;
import com.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class app2 {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Test
    @Transactional
    @Rollback(false)
    public void test1(){
        SysUser u = new SysUser();
         u.setPassword("7777");
         u.setUsername("小火龙");

        SysRole r = new SysRole();
          r.setRoleName("火恐龙");
         u.getRoles().add(r);
              r.getUsers().add(u);
         sysUserDao.save(u);
         sysRoleDao.save(r);


    }
    @Test
            @Transactional
            @Rollback(false)
            public  void delete(){
         sysUserDao.delete(2);
    };

    @Test
    @Transactional
    @Rollback(false)
    public  void find(){
        //通过用户导航查询角色
        SysUser u = sysUserDao.findOne(3);
        Set<SysRole> roles = u.getRoles();
        for (SysRole role : roles) {

            System.out.println(role);
        }

    };
    @Test
    @Transactional
    @Rollback(false)
    public  void findUser(){
        //通过角色导航查询用户
        SysRole role = sysRoleDao.findOne(3);
        Set<SysUser> users = role.getUsers();
        for (SysUser user : users) {
            System.out.println(user);
        }

    };



}
