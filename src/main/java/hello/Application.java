package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Application {
    public static void main(String[] asdf) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello World";
            }
        };
    }
}
