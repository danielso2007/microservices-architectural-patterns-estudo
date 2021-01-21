package com.acme.ecom.product.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ProductTest {

	private static final String TESTUPDATER = "testupdater";
	private static final String TEST_CREATOR = "testCreator";
	private static final String PRODUCT_TITLE = "Product title";
	private static final String PRODUCT_CATEGORY_NAME = "product category name";
	private static final double PRICE = 123.23;
	private static final String PRODUCT_NAME = "product name";
	private static final String IMG_URL = "http://image/img.jpg";
	private static final String ID = "dkjashaiueqw123uu9";
	private static final String DESCRIPTION = "description";
	private static final String CODE = "31232";

	private Product product;

	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);

		product = new Product();
		product.setCode(CODE);
		product.setCreator(TEST_CREATOR);
		product.setDescription(DESCRIPTION);
		product.setId(ID);
		product.setImgUrl(IMG_URL);
		product.setName(PRODUCT_NAME);
		product.setPrice(PRICE);
		product.setProductCategoryName(PRODUCT_CATEGORY_NAME);
		product.setTitle(PRODUCT_TITLE);
		product.setUpdater(TESTUPDATER);
	}

	@AfterEach
	void tearDown() {
	}

	@AfterAll
	static void tearDownAll() {
	}

	@Test
	void test_creationAt() {
		Date now = new Date();
		product.setCreationAt(now);
		assertAll("creationAt", () -> assertEquals(now, product.getCreationAt()));
	}

	@Test
	void test_creator() {
		assertEquals(TEST_CREATOR, product.getCreator());
	}

	@Test
	void test_updateAt() {
		Date now = new Date();
		product.setUpdateAt(now);
		assertEquals(now, product.getUpdateAt());
	}

	@Test
	void test_updater() {
		assertEquals(TESTUPDATER, product.getUpdater());
	}

	@Test
	void test_code() {
		assertEquals(CODE, product.getCode());
	}

	@Test
	void test_description() {
		assertEquals(DESCRIPTION, product.getDescription());
	}

	@Test
	void test_id() {
		assertEquals(ID, product.getId());
	}

	@Test
	void test_imgUrl() {
		assertEquals(IMG_URL, product.getImgUrl());
	}

	@Test
	void test_name() {
		assertEquals(PRODUCT_NAME, product.getName());
	}

	@Test
	void test_price() {
		assertEquals(PRICE, product.getPrice());
	}

	@Test
	void test_category() {
		assertEquals(PRODUCT_CATEGORY_NAME, product.getProductCategoryName());
	}

	@Test
	void test_title() {
		assertEquals(PRODUCT_TITLE, product.getTitle());
	}

	@Test
	void test_hashCode() {
		assertEquals(966456674, product.hashCode());
		Product noId = new Product();
		noId.setId(null);
		assertEquals(29791, noId.hashCode());
	}

	@Test
	void test_equals() {
		assertAll("equals", () -> assertEquals(false, product.equals(new Product())),
				() -> assertEquals(true, product.equals(product)),
				() -> assertEquals(false, product.equals(new ProductCategory())),
				() -> assertEquals(false, product.equals(null)));
		Product productTest = new Product();
		productTest.setCode(CODE);
		productTest.setCreator(TEST_CREATOR);
		productTest.setDescription(DESCRIPTION);
		productTest.setImgUrl(IMG_URL);
		productTest.setName(PRODUCT_NAME);
		productTest.setPrice(PRICE);
		productTest.setProductCategoryName(PRODUCT_CATEGORY_NAME);
		productTest.setTitle(PRODUCT_TITLE);
		productTest.setUpdater(TESTUPDATER);
		assertEquals(false, productTest.equals(product));

		productTest.setId("kajsdhkas878as7d");
		assertEquals(false, productTest.equals(product));

		productTest.setId(ID);
		productTest.setName(null);
		assertEquals(false, productTest.equals(product));

		productTest.setName(PRODUCT_NAME);
		assertEquals(true, productTest.equals(product));
	}

	@Test
	void test_toString() {
		assertEquals("Product [id=dkjashaiueqw123uu9, name=product name, title=Product title]", product.toString());
	}
}
