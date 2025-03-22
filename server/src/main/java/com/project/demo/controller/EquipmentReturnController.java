package com.project.demo.controller;

import com.project.demo.entity.EquipmentReturn;
import com.project.demo.service.EquipmentReturnService;
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
 * 设备归还：(EquipmentReturn)表控制层
 *
 */
@RestController
@RequestMapping("/equipment_return")
public class EquipmentReturnController extends BaseController<EquipmentReturn, EquipmentReturnService> {

    /**
     * 设备归还对象
     */
    @Autowired
    public EquipmentReturnController(EquipmentReturnService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(equipment_return_id) AS max FROM "+"equipment_return";
        Integer max = service.selectBaseCount(sql);
        sql = "UPDATE `device_management` INNER JOIN `equipment_return` ON device_management.equipment_number=equipment_return.equipment_number SET device_management.inventory_quantity= device_management.inventory_quantity + equipment_return.return_quantity WHERE equipment_return.equipment_return_id="+max;
        service.updateBaseSql(sql);
        return success(1);
    }

}
