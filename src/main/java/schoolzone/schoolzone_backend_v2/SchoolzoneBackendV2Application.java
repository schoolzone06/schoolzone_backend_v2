package schoolzone.schoolzone_backend_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableJpaAuditing
@EnableFeignClients
public class SchoolzoneBackendV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SchoolzoneBackendV2Application.class, args);
    }

}
