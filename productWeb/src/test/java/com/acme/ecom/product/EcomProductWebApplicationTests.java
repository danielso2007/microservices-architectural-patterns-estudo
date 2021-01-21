package com.acme.ecom.product;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class EcomProductWebApplicationTests {

	@Test
	void test_main() {
	    EcomProductWebApplication.main(null);
		assertNotNull(new EcomProductWebApplication());
	}
	
}
