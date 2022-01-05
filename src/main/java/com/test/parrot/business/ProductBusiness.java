/*
 * Parrot.
 */

package com.test.parrot.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.test.parrot.constant.MessageConstant;
import com.test.parrot.domain.Product;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.model.ProductRequest;
import com.test.parrot.model.ProductResponse;
import com.test.parrot.model.mapper.ProductMapper;
import com.test.parrot.repository.ProductRepository;
import com.test.parrot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

/**
 * Product business class, this class contains product functionalities like getAll products, create
 * new product, find product by id and update stock product.
 * 
 * @author parrot.
 *
 */
@Slf4j
@Service
public class ProductBusiness implements ProductService {

  /**
   * ProductRepository variable.
   */
  private final ProductRepository productRepository;

  /**
   * ProductMapper variable.
   */
  private final ProductMapper productMapper;

  /**
   * Constructor method. Initialize productRepository and productMapper objects.
   * 
   * @param productRepository ProductRepository instance.
   * @param productMapper ProductMapper instance.
   */
  public ProductBusiness(final ProductRepository productRepository,
      final ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ProductResponse findAllProducts(Optional<Integer> page, Optional<Integer> size) {

    if (page.isEmpty() || size.isEmpty()) {
      throw new BadRequestException(MessageConstant.PAGE_SIZE_NOT_NULL,
          List.of(MessageConstant.PAGE, MessageConstant.SIZE));
    }

    Pageable pageable = PageRequest.of(page.get(), size.get());
    Page<Product> list = this.productRepository.findAll(pageable);

    if (list.getContent().isEmpty()) {
      throw new NotDataFoundException(MessageConstant.PRODUCT_NOT_FOUND);
    }

    log.debug(MessageConstant.LOG_PRODUCTS, list.getContent());

    ProductResponse productResponse = new ProductResponse();
    productResponse.setCurrentPage(page.get());
    productResponse.setTotalItems(list.getTotalElements());
    productResponse.setTotalPages(list.getTotalPages());
    productResponse.setProducts(
        list.getContent().stream().map(product -> this.productMapper.productToProductDto(product))
            .collect(Collectors.toList()));

    return productResponse;
  }

  /**
   * {@inheritDoc}
   */
  @Transactional
  @Override
  public void createProduct(@Valid ProductRequest productRequest) {
    Product product = new Product();

    product.setName(productRequest.getName());
    product.setPrice(productRequest.getPrice());
    product.setStock(productRequest.getStock());

    log.debug(MessageConstant.LOG_SAVE_PRODUCT, productRequest);
    this.productRepository.save(product);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Product findByProductId(Long id) {
    return this.productRepository.findById(id).orElseThrow(() -> new NotDataFoundException(
        String.format(MessageConstant.LOG_NOT_FOUND_PRODUCT, id)));
  }

  /**
   * {@inheritDoc}
   */
  @Transactional
  @Override
  public void updateProductStok(Integer newStok, Product product) {
    product.setStock(newStok);
    this.productRepository.save(product);
  }
}
