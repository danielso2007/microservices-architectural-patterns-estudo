package com.acme.ecom.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acme.ecom.product.model.Product;
import com.acme.ecom.product.model.ProductCategory;
import com.acme.ecom.product.repository.ProductCategoryRepository;
import com.acme.ecom.product.repository.ProductRepository;

@SpringBootApplication
public class EcomProductMicroserviceApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(EcomProductMicroserviceApplication.class);
		application.setBannerMode(Banner.Mode.CONSOLE);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Start");

		logger.info("Deletando todas as categorias");
		productCategoryRepository.deleteAll();
		logger.info("Deletando todos os produtos");
		productRepository.deleteAll();

		ProductCategory productCategory = new ProductCategory();
		productCategory.setName("Mobile");
		productCategory.setDescription("Mobile phones");
		productCategory.setTitle("Mobiles and Tablet");
		productCategory.setImgUrl("mobile.jpg");
		productCategoryRepository.save(productCategory);

		Product product = new Product();
		product.setName("Kamsung D3");
		product.setCode("KAMSUNG-TRIOS");
		product.setTitle("Kamsung Trios 12 inch , black , 12 px");
		product.setDescription("Kamsung Trios 12 inch with Touch");
		product.setImgUrl("kamsung.jpg");
		product.setPrice(12000.00);
		product.setProductCategoryName(productCategory.getName());
		productRepository.save(product);

		product = new Product();
		product.setName("Lokia Pomia");
		product.setCode("LOKIA-POMIA");
		product.setTitle("Lokia 12 inch , white , 14px");
		product.setDescription("Lokia Pomia 10 inch with NFC");
		product.setImgUrl("lokia.jpg");
		product.setPrice(9000.00);
		product.setProductCategoryName(productCategory.getName());
		productRepository.save(product);

		logger.info("End");
	}

}
