package com.example.crud.services;
import com.example.crud.models.Product;
import com.example.crud.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById(Long id) {
        return repository.findById(id).get();
    }
    public Product insert(Product product) {
        return repository.save(product);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
