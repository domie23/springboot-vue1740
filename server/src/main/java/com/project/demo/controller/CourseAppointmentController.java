package com.project.demo.controller;

import com.project.demo.entity.CourseAppointment;
import com.project.demo.service.CourseAppointmentService;
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
 * 课程预约：(CourseAppointment)表控制层
 *
 */
@RestController
@RequestMapping("/course_appointment")
public class CourseAppointmentController extends BaseController<CourseAppointment, CourseAppointmentService> {

    /**
     * 课程预约对象
     */
    @Autowired
    public CourseAppointmentController(CourseAppointmentService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(course_appointment_id) AS max FROM "+"course_appointment";
        Integer max = service.selectBaseCount(sql);
        sql = ("SELECT count(*) count FROM `experimental_courses` INNER JOIN `course_appointment` ON experimental_courses.laboratory_number=course_appointment.laboratory_number WHERE experimental_courses.capacity < course_appointment.number_of_appointments AND course_appointment.course_appointment_id="+max).replaceAll("&#60;","<");
        Integer count = service.selectBaseCount(sql);
        if(count>0){
            sql = "delete from "+"course_appointment"+" WHERE "+"course_appointment_id"+" ="+max;
            service.deleteBaseSql(sql);
            return error(30000,"人数已满！");
        }
        sql = "UPDATE `experimental_courses` INNER JOIN `course_appointment` ON experimental_courses.laboratory_number=course_appointment.laboratory_number SET experimental_courses.capacity= experimental_courses.capacity - course_appointment.number_of_appointments WHERE course_appointment.course_appointment_id="+max;
        service.updateBaseSql(sql);
        return success(1);
    }

}
