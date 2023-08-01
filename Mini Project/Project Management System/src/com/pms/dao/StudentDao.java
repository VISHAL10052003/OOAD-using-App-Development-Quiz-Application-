package com.pms.dao;

import java.util.List;
import com.pms.model.Student;

public interface StudentDao {
    void create(Student s);
    List<Student> read(int total);
    void update(int regno);
    void delete(int regno);
	
	
}

