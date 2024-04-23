package com.enviro.assessment.grad001.LucianoCharles.demo.repository;
import com.enviro.assessment.grad001.LucianoCharles.demo.model.WasteCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository<WasteCategories, Long> {
}