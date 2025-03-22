package com.project.demo.controller;

import com.project.demo.entity.ExperimentalCourses;
import com.project.demo.service.ExperimentalCoursesService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 实验课程：(ExperimentalCourses)表控制层
 *
 */
@RestController
@RequestMapping("/experimental_courses")
public class ExperimentalCoursesController extends BaseController<ExperimentalCourses, ExperimentalCoursesService> {

    /**
     * 实验课程对象
     */
    @Autowired
    public ExperimentalCoursesController(ExperimentalCoursesService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> maplaboratory_number = new HashMap<>();
        maplaboratory_number.put("laboratory_number",String.valueOf(paramMap.get("laboratory_number")));
        List listlaboratory_number = service.selectBaseList(service.select(maplaboratory_number, new HashMap<>()));
        if (listlaboratory_number.size()>0){
            return error(30000, "字段实验室编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
