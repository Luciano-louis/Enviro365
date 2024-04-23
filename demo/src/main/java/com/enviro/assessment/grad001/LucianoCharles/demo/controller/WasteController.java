package com.enviro.assessment.grad001.LucianoCharles.demo.controller;
import com.enviro.assessment.grad001.LucianoCharles.demo.model.WasteCategories;
import com.enviro.assessment.grad001.LucianoCharles.demo.service.WasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waste-categories")
public class WasteController {
    @Autowired
    private WasteService wasteService;

    @GetMapping
    public ResponseEntity<List<WasteCategories>> getAllCategories() {
        List<WasteCategories> categories = wasteService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WasteCategories> createCategory(@RequestBody WasteCategories category) {
        WasteCategories createdCategory = wasteService.createWaste(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteService.deleteWaste(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}