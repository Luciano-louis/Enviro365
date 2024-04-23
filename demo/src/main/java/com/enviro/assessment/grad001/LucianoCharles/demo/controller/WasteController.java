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
    ///returns all Categories currently available
    public ResponseEntity<List<WasteCategories>> getAllCategories() {
        List<WasteCategories> categories = wasteService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    ///Creates a new category provided by user
    public ResponseEntity<WasteCategories> createCategory(@RequestBody WasteCategories category) {
        WasteCategories createdCategory = wasteService.createWaste(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ///Deletes the current selected category
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteService.deleteWaste(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ///Returns disposal-tip with selected ID
    @GetMapping("/{id}/disposal-tip")
    public ResponseEntity<String> getDisposalTip(@PathVariable Long id) {
        String disposalTip = wasteService.getDisposalTip(id);
        return new ResponseEntity<>(disposalTip, HttpStatus.OK);
    }

    ///returns recycling tip based on ID
    @GetMapping("/{id}/recycling-tip")
    public ResponseEntity<String> getRecyclingTip(@PathVariable Long id) {
        String recyclingTip = wasteService.getRecyclingTip(id);
        return new ResponseEntity<>(recyclingTip, HttpStatus.OK);
    }
}