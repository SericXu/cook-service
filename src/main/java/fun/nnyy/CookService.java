package fun.nnyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("fun.nnyy.mapper")
@EnableOpenApi
public class CookService {
    public static void main(String[] args) {
        SpringApplication.run(CookService.class, args);
    }
}
