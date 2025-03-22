package com.project.demo.controller;

import com.project.demo.entity.EquipmentBorrowing;
import com.project.demo.service.EquipmentBorrowingService;
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
 * 设备借用：(EquipmentBorrowing)表控制层
 *
 */
@RestController
@RequestMapping("/equipment_borrowing")
public class EquipmentBorrowingController extends BaseController<EquipmentBorrowing, EquipmentBorrowingService> {

    /**
     * 设备借用对象
     */
    @Autowired
    public EquipmentBorrowingController(EquipmentBorrowingService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(equipment_borrowing_id) AS max FROM "+"equipment_borrowing";
        Integer max = service.selectBaseCount(sql);
        sql = "UPDATE `device_management` INNER JOIN `equipment_borrowing` ON device_management.equipment_number=equipment_borrowing.equipment_number SET device_management.inventory_quantity= device_management.inventory_quantity - equipment_borrowing.borrowed_quantity WHERE equipment_borrowing.equipment_borrowing_id="+max;
        service.updateBaseSql(sql);
        return success(1);
    }

}
