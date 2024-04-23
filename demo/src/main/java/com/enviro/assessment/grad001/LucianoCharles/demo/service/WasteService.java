package com.enviro.assessment.grad001.LucianoCharles.demo.service;

import com.enviro.assessment.grad001.LucianoCharles.demo.model.WasteCategories;
import com.enviro.assessment.grad001.LucianoCharles.demo.repository.WasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String getDisposalTip(Long id) {
        Optional<WasteCategories> wasteOptional = wasteRepository.findById(id);
        if (wasteOptional.isPresent()) {
            WasteCategories waste = wasteOptional.get();
            return waste.getDisposalTip();
            ///Prevents a crash if the selected ID does not exist
        } else {
            throw new IllegalArgumentException("Waste category not found with id: " + id);
        }
    }

    public String getRecyclingTip(Long id) {
        Optional<WasteCategories> wasteOptional = wasteRepository.findById(id);
        if (wasteOptional.isPresent()) {
            WasteCategories waste = wasteOptional.get();
            return waste.getRecyclingTip();
        } else {
            throw new IllegalArgumentException("Waste category not found with id: " + id);
        }
    }
}

