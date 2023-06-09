package main.pe.com.betweenAll.servicesimpl;

import main.pe.com.betweenAll.entities.UserCategory;
import main.pe.com.betweenAll.repositories.CategoryRepository;
import main.pe.com.betweenAll.repositories.UserCategoryRepository;
import main.pe.com.betweenAll.repositories.UserRepository;
import main.pe.com.betweenAll.services.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {
    @Autowired
    UserCategoryRepository userCategoryRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserCategory save(UserCategory userCategory){
        UserCategory newUserCategory=userCategoryRepository.save(new UserCategory(userCategory.getUser(),userCategory.getCategory()));
        return newUserCategory;
    }
    @Transactional
    public void delete(Long id, boolean forced){
        UserCategory userCategory=userCategoryRepository.findById(id).get();
        userCategoryRepository.delete(userCategory);
    }
    @Transactional
    public List<UserCategory> listAll() {
        List<UserCategory> userCategoryList = userCategoryRepository.findAll();
        return userCategoryList;
    }


}