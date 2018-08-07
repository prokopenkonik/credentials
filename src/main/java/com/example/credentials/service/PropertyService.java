package com.example.credentials.service;

import com.example.credentials.entity.Property;

import java.util.List;

public interface PropertyService {
    List<Property> getAllProperties();

    Property getPropertyById(int id);

    void save(Property property);

    void delete(int id);

    List<Property> getPropertiesByQuery(String query);
}
