package ToyProject.JpaAws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class JpaAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAwsApplication.class, args);
	}

}
