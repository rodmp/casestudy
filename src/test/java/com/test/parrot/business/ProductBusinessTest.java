/*
 * Parrot.
 */

package com.test.parrot.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.parrot.domain.Product;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.model.ProductDto;
import com.test.parrot.model.ProductRequest;
import com.test.parrot.model.ProductResponse;
import com.test.parrot.model.mapper.ProductMapper;
import com.test.parrot.repository.ProductRepository;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class ProductBusinessTest {

  /**
   * 
   */
  @InjectMocks
  private ProductBusiness productBusiness;

  /**
   * ProductRepository variable.
   */
  @Mock
  private ProductRepository productRepository;

  /**
   * ProductMapper variable.
   */
  @Mock
  private ProductMapper productMapper;

  /**
   * 
   * @throws Exception
   */
  @Test
  public void findAllProductsTest() throws Exception {
    List<Product> products = this.generateListProducts();
    Pageable pageable = PageRequest.of(2, 2);
    Page<Product> list = new PageImpl<>(products, pageable, 6);

    ProductDto productDto = new ProductDto();
    productDto.setId(1l);
    productDto.setName("goma");
    productDto.setPrice(BigDecimal.valueOf(34));
    productDto.setStock(2);

    when(this.productRepository.findAll(Mockito.any(Pageable.class))).thenReturn(list);

    when(this.productMapper.productToProductDto(Mockito.any())).thenReturn(productDto);

    ProductResponse productResponse = this.generateProductResponse();

    assertEquals(productResponse.getProducts().size(),
        this.productBusiness.findAllProducts(Optional.of(2), Optional.of(2)).getProducts().size());

  }

  /**
   * 
   * @throws Exception
   */
  @Test
  public void findAllProductsTestPageEmpty() throws Exception {

    assertThrows(BadRequestException.class,
        () -> this.productBusiness.findAllProducts(Optional.empty(), Optional.of(2)));

  }

  /**
   * 
   * @throws Exception
   */
  @Test
  public void findAllProductsTestPageNull() throws Exception {
    List<Product> products = List.of();
    Pageable pageable = PageRequest.of(2, 2);
    Page<Product> list = new PageImpl<>(products, pageable, 6);

    ProductDto productDto = new ProductDto();
    productDto.setId(1l);
    productDto.setName("goma");
    productDto.setPrice(BigDecimal.valueOf(34));
    productDto.setStock(2);

    when(this.productRepository.findAll(Mockito.any(Pageable.class))).thenReturn(list);

    assertThrows(NotDataFoundException.class,
        () -> this.productBusiness.findAllProducts(Optional.of(2), Optional.of(2)));

  }

  /**
   * 
   */
  @Test
  public void createProductTest() {

    Product product = new Product();

    product.setName("goma");
    product.setPrice(BigDecimal.valueOf(24));
    product.setStock(43);

    when(this.productRepository.save(Mockito.any())).thenReturn(product);

    this.productBusiness.createProduct(mock(ProductRequest.class));
    assertNotNull(product);
  }

  @Test
  public void findByProductIdTest() {
    Product product = new Product();

    product.setName("goma");
    product.setPrice(BigDecimal.valueOf(24));
    product.setStock(43);

    when(this.productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

    assertEquals(product, this.productBusiness.findByProductId(2l));
  }

  /**
   * 
   */
  @Test
  public void findByProductIdTestNotFound() {

    when(this.productRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

    assertThrows(NotDataFoundException.class, () -> this.productBusiness.findByProductId(2l));
  }

  /**
   * 
   */
  @Test
  public void updateProductTest() {

    Product product = new Product();

    product.setName("goma");
    product.setPrice(BigDecimal.valueOf(24));
    product.setStock(43);

    when(this.productRepository.save(Mockito.any())).thenReturn(product);

    this.productBusiness.updateProductStok(34, product);
    assertNotNull(product);
  }
  
  /**
   * 
   */
  private List<Product> generateListProducts()
      throws JsonMappingException, JsonProcessingException {

    String json =
        "[{\"id\":5,\"name\":\"sacapuntas\",\"price\":5.00,\"stock\":245},{\"id\":6,\"name\":\"Pegamento\",\"price\":10.50,\"stock\":50}]";
    return new ObjectMapper().readValue(json, new TypeReference<List<Product>>() {});
  }

  /**
   * 
   */
  private ProductResponse generateProductResponse()
      throws JsonMappingException, JsonProcessingException {

    String json =
        "{\"products\":[{\"id\":5,\"name\":\"sacapuntas\",\"price\":5.00,\"stock\":245},{\"id\":6,\"name\":\"Pegamento\",\"price\":10.50,\"stock\":50}],\"totalPages\":3,\"currentPage\":2,\"totalItems\":6}";
    return new ObjectMapper().readValue(json, ProductResponse.class);
  }
}
