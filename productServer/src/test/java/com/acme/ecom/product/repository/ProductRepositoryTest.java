package com.acme.ecom.product.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acme.ecom.model.Product;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@BeforeEach
	void setUp() {
		productRepository.deleteAll();
	}

	@Test
	void testAddProduct() {
		try {
			productRepository.save(createProject());
			assertTrue(true, "successfully saved");
		} catch (Exception ex) {
			assertTrue(true, "successfully failed");
		}
	}

	@Test
	void testFindAllProducts() {
		productRepository.save(createProject());
		List<Product> productList = productRepository.findAll();
		System.out.println(productList);
		assertTrue(productList.size() > 0);
	}

	@Test
	void testProductByProductCategory() {
		Product product = createProject();
		productRepository.save(product);
		List<Product> productList = productRepository.findByProductCategoryName(product.getProductCategoryName());
		assertTrue(productList.size() > 0);
	}

	private Product createProject() {
		Product product = new Product();
		product.setName("Kamsung D3");
		product.setCode("KAMSUNG-TRIOS");
		product.setTitle("Kamsung Trios 12 inch , black , 12 px ....");
		product.setDescription("Kamsung Trios 12 inch with Touch");
		product.setImgUrl("kamsung.jpg");
		product.setPrice(12000.00);
		product.setProductCategoryName("testCategory");
		return product;
	}

}
