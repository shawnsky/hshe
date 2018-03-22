package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Submission;

import java.util.List;
import java.util.Map;

public interface MasterService {
    Map<String, List<Student>> achievement(List<Problem> problems, List<Student> studentList);
    List<List<Submission>> group(Problem problem);
}
