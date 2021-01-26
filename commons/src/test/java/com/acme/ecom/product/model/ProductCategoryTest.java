package com.acme.ecom.product.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.acme.ecom.model.Product;
import com.acme.ecom.model.ProductCategory;

class ProductCategoryTest {

	private static final String CATEGORIA_TITLE = "Categoria Title";
	private static final String CATEGORIA = "Categoria";
	private static final String ID = "asdkjh78asdasdhisad";
	private static final String DESCRIPTION = "description";
	private static final String TESTUPDATER = "testupdater";
	private static final String TEST_CREATOR = "testCreator";
	private static final String IMG_URL = "http://image/img.jpg";

	private ProductCategory productCategory;

	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);

		productCategory = new ProductCategory();
		productCategory.setDescription(DESCRIPTION);
		productCategory.setCreator(TEST_CREATOR);
		productCategory.setId(ID);
		productCategory.setImgUrl(IMG_URL);
		productCategory.setName(CATEGORIA);
		productCategory.setTitle(CATEGORIA_TITLE);
		productCategory.setUpdater(TESTUPDATER);
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
		productCategory.setCreationAt(now);
		assertAll("creationAt", () -> assertEquals(now, productCategory.getCreationAt()));
	}

	@Test
	void test_creator() {
		assertEquals(TEST_CREATOR, productCategory.getCreator());
	}

	@Test
	void test_updateAt() {
		Date now = new Date();
		productCategory.setUpdateAt(now);
		assertEquals(now, productCategory.getUpdateAt());
	}

	@Test
	void test_updater() {
		assertEquals(TESTUPDATER, productCategory.getUpdater());
	}

	@Test
	void test_description() {
		assertEquals(DESCRIPTION, productCategory.getDescription());
	}

	@Test
	void test_id() {
		assertEquals(ID, productCategory.getId());
	}

	@Test
	void test_imgUrl() {
		assertEquals(IMG_URL, productCategory.getImgUrl());
	}

	@Test
	void test_name() {
		assertEquals(CATEGORIA, productCategory.getName());
	}

	@Test
	void test_title() {
		assertEquals(CATEGORIA_TITLE, productCategory.getTitle());
	}

	@Test
	void test_hashCode() {
		assertEquals(-1118477196, productCategory.hashCode());
		ProductCategory noId = new ProductCategory();
		noId.setId(null);
		assertEquals(29791, noId.hashCode());
	}

	@Test
	void test_equals() {
		assertAll("equals", () -> assertEquals(false, productCategory.equals(new Product())),
				() -> assertEquals(true, productCategory.equals(productCategory)),
				() -> assertEquals(false, productCategory.equals(new ProductCategory())),
				() -> assertEquals(false, productCategory.equals(null)));
		ProductCategory productCategoryTest = new ProductCategory();
		productCategoryTest.setCreator(TEST_CREATOR);
		productCategoryTest.setDescription(DESCRIPTION);
		productCategoryTest.setImgUrl(IMG_URL);
		productCategoryTest.setName(CATEGORIA);
		productCategoryTest.setTitle(CATEGORIA_TITLE);
		productCategoryTest.setUpdater(TESTUPDATER);
		assertEquals(false, productCategoryTest.equals(productCategory));

		productCategoryTest.setId("kajsdhkas878as7d");
		assertEquals(false, productCategoryTest.equals(productCategory));

		productCategoryTest.setId(ID);
		productCategoryTest.setName(null);
		assertEquals(false, productCategoryTest.equals(productCategory));

		productCategoryTest.setName(CATEGORIA);
		assertEquals(true, productCategoryTest.equals(productCategory));
	}

	@Test
	void test_toString() {
		assertEquals("ProductCategory [id=asdkjh78asdasdhisad, name=Categoria, title=Categoria Title]",
				productCategory.toString());
	}
}
