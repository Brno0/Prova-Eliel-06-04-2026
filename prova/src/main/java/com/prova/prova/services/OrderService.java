package com.prova.prova.services;
import com.prova.prova.models.Order;
import com.prova.prova.repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public List<Order> findAll() {
        return repository.findAll();
    }
    public Order findById(Long id) {
        return repository.findById(id).get();
    }
    public Order insert(Order order) {
        return repository.save(order);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
