package com.example.credentials.service.impl;

import com.example.credentials.service.PropertyService;
import com.example.credentials.entity.Property;
import com.example.credentials.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository repository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Property> getAllProperties() {
        return repository.findAll();
    }

    @Override
    public Property getPropertyById(int id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void save(Property property) {
        repository.save(property);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Property> getPropertiesByQuery(String query) {
        return repository.findByKeyContainingIgnoreCase(query);
    }
}
