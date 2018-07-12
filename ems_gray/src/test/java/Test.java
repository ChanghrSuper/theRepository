import com.chr.entity.User;
import com.chr.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class Test {

    @Autowired
    private UserService userService;

    @org.junit.Test
    public void findAll(){
        User user = userService.findByUsernameAndPassword(new User(null,"huxz",null,"123456",null,null));
        System.out.println(user);
    }
}
