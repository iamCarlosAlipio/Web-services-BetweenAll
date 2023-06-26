package main.pe.com.betweenAll.controllers;

import main.pe.com.betweenAll.dtos.DTOUserCategorySummary;
import main.pe.com.betweenAll.entities.UserCategory;
import main.pe.com.betweenAll.services.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserCategoryController {

    @Autowired
    UserCategoryService userCategoryService;

    @PostMapping("/userCategories/{idUser}/{idCategory}")
    public ResponseEntity<UserCategory> createUserCategory(@RequestBody UserCategory userCategory,
                                                           @PathVariable("idUser") Long idUser,
                                                           @PathVariable("idCategory") Long idCategory){
        UserCategory saveUserCategory=userCategoryService.save(userCategory,idUser,idCategory);
        return new ResponseEntity<UserCategory>(saveUserCategory, HttpStatus.CREATED);
    }
    @DeleteMapping("/userCategories/{id}")
    public ResponseEntity<HttpStatus> deleteUserCategory(@PathVariable("id") Long id){
        userCategoryService.delete(id,true);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/userCategories")
    public ResponseEntity<List<UserCategory>> getAllUserCategory(){
        List<UserCategory> userCategoryList = userCategoryService.listAll();
        return new ResponseEntity<List<UserCategory>>(userCategoryList,HttpStatus.OK);
    }
    @GetMapping("/userCategories/summary")
    public ResponseEntity<List<DTOUserCategorySummary>> getAuthorsSummary() {
        List<DTOUserCategorySummary> dtoUserCategorySummaryList = userCategoryService.listUserCategorySummary();
        return new ResponseEntity<List<DTOUserCategorySummary>>(dtoUserCategorySummaryList, HttpStatus.OK);
    }



}
