package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Category;
import com.t2010a.hellot2010aagain.entity.Student;

import java.util.List;

public interface CategoryModel {
    Category save(Category obj); // lưu thông tin.

    List<Category> findAll();

    Category findById(int id);

    Category update(int id, Category updateObj);

    boolean delete(int id);


}
