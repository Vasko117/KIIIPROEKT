package mk.ukim.finki.vb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class VbApplication {

    public static void main(String[] args) {
        SpringApplication.run(VbApplication.class, args);
    }

}
