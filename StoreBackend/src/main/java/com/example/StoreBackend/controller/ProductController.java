package com.example.StoreBackend.controller;

import com.example.StoreBackend.model.Product;
import com.example.StoreBackend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {


    private ProductService productService;

    @GetMapping("/products")
    @Operation(summary = "Gets All Products")
    public List<Product> getProducts() {
        log.info("GET: All Products");
        return productService.getAllProducts();
    }

    @GetMapping(value = "/product/{id}")
    @Operation(summary = "Gets Product by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found")})
    public Product getProduct(@Parameter(description = "Id of product to be searched") @PathVariable("id") long id) {
        log.info("GET: Product {}", id);
        System.out.println(productService.getProductById(id));
        return productService.getProductById(id);
    }


    @PutMapping("/product/{id}")
    @Operation(summary = "Updates a given Product")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@Parameter(description = "Id of product to be updated") @PathVariable("id") final String id, @RequestBody final Product product) {
        log.info("UPDATE: Product {}", id);
        productService.saveProduct(product);
        return product;
    }

    @PatchMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Patches a given Product")
    public Product patchProduct(@Parameter(description = "Id of product to be patched") @PathVariable("id") final String id, @RequestBody final Product product) {
        log.info("PATCH: Product {}", id);
        return product;
    }

    @PostMapping("/product/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a given Product")
    public Product postProduct(@NotNull @Valid @RequestBody final Product product) {
        log.info("POST: Product {}", product);
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/product/{id}")
    @Operation(summary = "Deletes a given Product")
    @ResponseStatus(HttpStatus.OK)
    public long deleteProduct(@Parameter(description = "Id of product to be deleted") @PathVariable final long id) {
        log.info("DELETE: Product {}", id);
        productService.deleteProduct(id);
        return id;
    }
}
