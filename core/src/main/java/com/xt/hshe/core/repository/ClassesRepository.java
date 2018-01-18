package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.Classes;
import com.xt.hshe.core.pojo.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassesRepository extends CrudRepository<Classes, Long> {

}
