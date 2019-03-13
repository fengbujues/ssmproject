import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.entity.Linkman;
import org.study.service.LinkmanService;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        LinkmanService linkmanService = (LinkmanService)context.getBean("linkmanService");
        Linkman linkman = linkmanService.queryLinkmanById(2);
        System.out.println("linkman = " + linkman);
    }
}
