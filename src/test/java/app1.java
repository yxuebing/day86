import com.dao.CustomerDao;
import com.dao.LinkManDao;
import com.pojo.Customer;
import com.pojo.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class app1 {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;
    @Test
    public void test1(){
        Customer c = new Customer();
               c.setCustName("比克大魔王");
               c.setCustAddress("牙买加");

        LinkMan l = new LinkMan();
        l.setLkmName("克林");
        l.setLkmPhone("1234456");
             // 要使外键有值,必须配置关系,  单向关系 ,  我知道你,你不知道我
        // 比如   下面的联系人就知道客户  l.getCustomer  就得到客户
        // 但 c.getLinkmen   却为空, 客户不知道联系人
           l.setCustomer(c);

            customerDao.save(c);
            linkManDao.save(l);


    }


    @Test
    @Transactional
    @Rollback(false)
    public void test2(){
        Customer c = new Customer();
        c.setCustName("弗利沙");
        c.setCustAddress("宇宙");

        LinkMan l = new LinkMan();
        l.setLkmName("孙宇空");
        l.setLkmPhone("666666");
        // 要使外键有值,必须配置关系,  单向关系 ,  我知道你,你不知道我
        // 比如   下面的联系人就知道客户  l.getCustomer  就得到客户
        // 但 c.getLinkmen   却为空, 客户不知道联系人
       c.getLinkmen().add(l);
      l.setCustomer(c);
        customerDao.save(c);
        linkManDao.save(l);
 // 如果要实现双向关系需要两个步骤:
        //   将 主表的JoinCloumn 注解删掉, 并在OneToMany 中 添加mappedBy注解 ,告诉外键由谁来维护,
        //    mappedBy = "填写对方有JoinColumn注解的实体类属性名字"
        //注意多方是不能放弃外键维护的,因为ManyToOne中没有mapped注解

    }

    @Test
    public void delete (){
                customerDao.delete(1l);

    }
}
