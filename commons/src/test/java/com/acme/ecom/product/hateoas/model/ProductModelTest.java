package com.acme.ecom.product.hateoas.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.acme.ecom.hateoas.model.ProductModel;
import com.acme.ecom.model.Product;

class ProductModelTest {

    private static final String CATEGORIA_TITLE = "Categoria Title";
    private static final String CATEGORIA = "Categoria";
    private static final String ID = "asdkjh78asdasdhisad";
    private static final String DESCRIPTION = "description";
    private static final String TESTUPDATER = "testupdater";
    private static final String TEST_CREATOR = "testCreator";
    private static final String IMG_URL = "http://image/img.jpg";

    private ProductModel model;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);

        model = new ProductModel();
        model.setDescription(DESCRIPTION);
        model.setCreator(TEST_CREATOR);
        model.setId(ID);
        model.setImgUrl(IMG_URL);
        model.setName(CATEGORIA);
        model.setTitle(CATEGORIA_TITLE);
        model.setUpdater(TESTUPDATER);
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
        model.setCreationAt(now);
        assertAll("creationAt", () -> assertEquals(now, model.getCreationAt()));
    }

    @Test
    void test_creator() {
        assertEquals(TEST_CREATOR, model.getCreator());
    }

    @Test
    void test_updateAt() {
        Date now = new Date();
        model.setUpdateAt(now);
        assertEquals(now, model.getUpdateAt());
    }

    @Test
    void test_updater() {
        assertEquals(TESTUPDATER, model.getUpdater());
    }

    @Test
    void test_description() {
        assertEquals(DESCRIPTION, model.getDescription());
    }

    @Test
    void test_id() {
        assertEquals(ID, model.getId());
    }

    @Test
    void test_imgUrl() {
        assertEquals(IMG_URL, model.getImgUrl());
    }

    @Test
    void test_name() {
        assertEquals(CATEGORIA, model.getName());
    }

    @Test
    void test_title() {
        assertEquals(CATEGORIA_TITLE, model.getTitle());
    }

    @Test
    void test_hashCode() {
        assertEquals(-625277083, model.hashCode());
        ProductModel noId = new ProductModel();
        noId.setId(null);
        assertEquals(-293403007, noId.hashCode());
    }

    @Test
    void test_equals() {
        assertAll("equals", () -> assertEquals(false, model.equals(new Product())),
                () -> assertEquals(true, model.equals(model)),
                () -> assertEquals(false, model.equals(new ProductModel())),
                () -> assertEquals(false, model.equals(null)));
        ProductModel modelTest = new ProductModel();
        modelTest.setCreator(TEST_CREATOR);
        modelTest.setDescription(DESCRIPTION);
        modelTest.setImgUrl(IMG_URL);
        modelTest.setName(CATEGORIA);
        modelTest.setTitle(CATEGORIA_TITLE);
        modelTest.setUpdater(TESTUPDATER);
        assertEquals(false, modelTest.equals(model));

        modelTest.setId("kajsdhkas878as7d");
        assertEquals(false, modelTest.equals(model));

        modelTest.setId(ID);
        modelTest.setName(null);
        assertEquals(false, modelTest.equals(model));

        modelTest.setName(CATEGORIA);
        assertEquals(true, modelTest.equals(model));
    }

    @Test
    void test_toString() {
        assertEquals("ProductModel [id=asdkjh78asdasdhisad, name=Categoria, code=null, title=Categoria Title, description=description, imgUrl=http://image/img.jpg, price=null, productCategoryName=null, creationAt=null, creator=testCreator, updateAt=null, updater=testupdater]",
                model.toString());
    }

}
