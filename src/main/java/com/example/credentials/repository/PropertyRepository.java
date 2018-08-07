package com.example.credentials.repository;

import com.example.credentials.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findByKeyContainingIgnoreCase(String query);
}
