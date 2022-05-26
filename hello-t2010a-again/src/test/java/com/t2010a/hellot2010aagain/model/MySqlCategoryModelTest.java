package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {
    MySqlCategoryModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlCategoryModel();
    }
    @Test
    public void create() {
        Category category = new Category();
        category.setName("Lon cap nach");
        model.save(category);
        Category category2 = new Category();
        category2.setName("Lon nai");
        model.save(category2);
        assertEquals(2, model.findAll().size());
    }
    @Test
    public void update(){
        Category cate = model.findById(2);
        assertEquals(null, cate);
    }
}