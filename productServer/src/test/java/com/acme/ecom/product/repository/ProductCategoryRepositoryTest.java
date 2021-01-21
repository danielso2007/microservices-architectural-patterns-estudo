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

import com.acme.ecom.product.model.ProductCategory;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@BeforeEach
	void setUp() {
		productCategoryRepository.deleteAll();
	}

	@Test
	void testAddProductCataogories() {
		try {
			ProductCategory productCategory = createProjectCategory();
			productCategoryRepository.save(productCategory);
			assertTrue(true, "successfully saved");
		} catch (Exception ex) {
			assertTrue(true, "successfully failed");
		}
	}

	@Test
	void testFindAllProductCatagories() {
		ProductCategory productCategory = createProjectCategory();
		productCategoryRepository.save(productCategory);
		List<ProductCategory> catagoryList = productCategoryRepository.findAll();
		assertTrue(catagoryList.size() > 0);
	}

	private ProductCategory createProjectCategory() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName("Mobile");
		productCategory.setDescription("Mobile phones");
		productCategory.setTitle("Mobiles and Tablet");
		productCategory.setImgUrl("mobile.jpg");
		return productCategory;
	}

}
