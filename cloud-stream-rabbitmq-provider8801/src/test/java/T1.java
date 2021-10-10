import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class T1 {

    @Test
    public void test01() {
        String serial = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(serial);
    }
    
}
