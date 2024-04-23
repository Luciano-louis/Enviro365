package com.enviro.assessment.grad001.LucianoCharles.demo.service;

import com.enviro.assessment.grad001.LucianoCharles.demo.model.WasteCategories;
import com.enviro.assessment.grad001.LucianoCharles.demo.repository.WasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteService {
    @Autowired
    private WasteRepository wasteRepository;

    public List<WasteCategories> getAllCategories() {
        return wasteRepository.findAll();
    }

    public WasteCategories createWaste(WasteCategories waste) {
        return wasteRepository.save(waste);
    }

    public void deleteWaste(Long id) {
        wasteRepository.deleteById(id);
    }
}
