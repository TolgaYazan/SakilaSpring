package com.uniyaz.sakila.rest.category;

import com.uniyaz.sakila.core.category.domain.Category;
import com.uniyaz.sakila.core.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "category")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @PostMapping(path= "save")
    public ResponseEntity save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping(path = "findAll")
    public ResponseEntity findAll(){
        return categoryService.findAll();
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity delete(@RequestParam Long id){
        return categoryService.delete(id);
    }

    @GetMapping("search")
    public ResponseEntity search(@RequestParam String data) {
        return categoryService.search(data);
    }
}
