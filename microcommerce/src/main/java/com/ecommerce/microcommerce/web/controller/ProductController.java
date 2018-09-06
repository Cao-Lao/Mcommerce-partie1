package com.ecommerce.microcommerce.web.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.beans.ProductBean;
import com.ecommerce.microcommerce.web.exceptions.FreeProductException;
import com.ecommerce.microcommerce.web.exceptions.NotFoundProductException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/*
 * the parameter is deprecated but unfortunatly
 * i did not manage to find a replacement
 * and so i am just going to hope it works for you all as well
 */
@Api(description = "API de gestion de produits.")
@RestController
public class ProductController {

	private ProductDao productDao;


	@Autowired
	public void setProductDao(final ProductDao productDao) {

		this.productDao = productDao;
	}

	@ApiOperation(value = "Recupere tout les produits")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@GetMapping(value = "/product")
	public List<Product> getAllProducts() {

		final List<Product> foundProducts = this.productDao.findAll();

		return foundProducts;
	}

//	@GetMapping(value = "/product/margin")
	@ApiOperation(value = "Recupere tout les produits avec leur marges")
	@GetMapping(value = "/AdminProduits")
	public List<ProductBean> calculerMargeProduit() {

		final List<Product> products = this.productDao.findAll();
		final List<ProductBean> productBeans = new ArrayList<>();

		for (final Product product : products) {
			productBeans.add(new ProductBean(product.getName(), product.getPrice(), product.getBoughtAtPrice()));
		}

		return productBeans;
	}

	@ApiOperation(value = "Recupere les produits par ordre alphabetique")
	@GetMapping(value = "/product/name/order")
	public List<Product> trierProduitsParOrdreAlphabetique() {

		final List<Product> foundProducts = this.productDao.findByOrderByName();

		return foundProducts;
	}

	@ApiOperation(value = "Recupere les produits au prix superieur au prixLimit")
	@GetMapping(value = "/test/product/price/greater/{limitPrice}")
	public List<Product> getProductsByLimitPrice(@PathVariable final Float limitPrice) {

		final List<Product> foundProducts = this.productDao.findByPriceGreaterThan(limitPrice);

		return foundProducts;
	}

	@ApiOperation(value = "Recupere un produit par son ID si il existe")
	@GetMapping(value = "/product/{id}")
	public Product getProductById(@PathVariable final Long id) throws NotFoundProductException {

		final Optional<Product> foundProduct = this.productDao.findById(id);

		if (!foundProduct.isPresent()) {
			throw new NotFoundProductException(new String("Nothing found"));
		}

		return foundProduct.get();
	}

	/*
	 * for the sake of laziness and my sanity i did not see the appeal
	 * in the defining of a ResponseEntity
	 * and so i used the @ResponseStatus annotation instead
	 * which in this case has the same effect
	 */
	@ApiOperation(value = "Cree un produit")
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/product")
	public void ajouterProduit(@Valid @RequestBody final Product product) throws FreeProductException {

		if (product.getPrice() <= 0.0) {
			throw new FreeProductException(new String("Price value cannot be less or equel to 0"));
		} else if (product.getBoughtAtPrice() <= 0.0) {
			throw new FreeProductException(new String("BoughtAtPrice value cannot be less or equel to 0"));
		} else {
			this.productDao.save(product);
		}
	}

	@ApiOperation(value = "Remplace un produit par son ID si il existe")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping(value = "/product")
	public void putProductById(@Valid @RequestBody final Product product) {

		this.productDao.save(product);
	}

	@ApiOperation(value = "Supprime un produit")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@DeleteMapping(value = "/product/{id}")
	public void removeProductById(@PathVariable final Long id) {

		this.productDao.deleteById(id);
	}
}
