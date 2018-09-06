package com.ecommerce.microcommerce.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecommerce.microcommerce.model.Product;


/*
 * replaces the sql script
 * i will also be providing a script doing exactly that
 * feel free to use that instead BUT
 * BEWARE : you will have to delete of comment this entire class beforehand
 */
@Component
public class DbSeeder implements CommandLineRunner {

	private ProductDao productDao;

	@Autowired
	public void setProductDao(final ProductDao productDao) {

		this.productDao = productDao;
	}

	@Override
	public void run(final String... args) throws Exception {

		this.productDao.save(new Product(new Long(1), new String("Ordinateur Portable"), new Float(350), new Float(120)));
		this.productDao.save(new Product(new Long(2), new String("Aspirateur Robot"), new Float(500), new Float(200)));
		this.productDao.save(new Product(new Long(3), new String("Table De Ping Pong"), new Float(750), new Float(400)));
	}

}
