package by.pvt.controller;


import java.util.List;

import by.pvt.dto.DeviceDto;
import by.pvt.service.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceListController {

    @Autowired
    DeviceListService deviceListService;

    @GetMapping("/devices")
    public List<DeviceDto> getDevice(){
        return deviceListService.getDevice(15);
    }

    @GetMapping("/device")
    public DeviceDto getDevice(@RequestParam long id){
        return deviceListService.get(id);
    }

    @PostMapping("/device")
    public void createNewDevice(@RequestBody CreateDeviceCmd createDeviceCmd){
        deviceListService.create(createDeviceCmd);
    }

    @PutMapping("/device/{id}")
    public void updateDevice(@PathVariable long id,
                             @RequestBody UpdateDeviceCmd updateDeviceCmd){
        deviceListService.update(id,updateDeviceCmd);
    }
}
