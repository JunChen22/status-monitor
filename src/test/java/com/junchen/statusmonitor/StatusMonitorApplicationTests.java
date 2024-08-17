package com.junchen.statusmonitor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
@TestPropertySource(properties = {
		"spring.jpa.defer-datasource-initialization=true",
		"spring.sql.init.mode=always",
		"spring.sql.init.data-locations=classpath:/data.sql"
})
class StatusMonitorApplicationTests extends TestContainerConfig {

	@Test
	void contextLoads() {
	}



}
