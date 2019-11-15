package by.pvt.service;


import by.pvt.controller.CreateDeviceCmd;
import by.pvt.controller.UpdateDeviceCmd;
import by.pvt.dto.DeviceDto;
import by.pvt.pojo.Device;
import by.pvt.repo.DeviceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DeviceListService {

    private static Logger log =Logger.getLogger("b.p.s.DeviceListService");

    @Autowired
    DeviceListRepository deviceListRepository;

    public List<DeviceDto> getDevice(int i){
        final List<DeviceDto> deviceDtos = new ArrayList<>();
        deviceListRepository.findAll().forEach(
                deviceItem->{
                    DeviceDto dto = new DeviceDto();
                    dto.id=deviceItem.getId();
                    dto.name=deviceItem.getName();
                    dto.ipAddress=deviceItem.getIpAddress();
                    dto.location=deviceItem.getLocation();
                    dto.value=deviceItem.getValue();
                    dto.date=deviceItem.getDate();
                }
        );
        return deviceDtos;
    }

    public void create(CreateDeviceCmd cmd){
        Device item = new Device();
        item.setId((long)Math.random()*100);
        item.setName("SpeedCam");
        item.setIpAddress("000.000.000.001");
        item.setLocation("M1-365km");
        item.setValue(cmd.getValue());
        item.setDate(new Date());

        deviceListRepository.save(item);
    }

    public void update(long id, UpdateDeviceCmd updateDeviceCmd){
        Device item = deviceListRepository.findById(id).get();
        item.setLocation(updateDeviceCmd.getLocation());

        deviceListRepository.save(item);
    }

    public DeviceDto get (long id){
        Device item = deviceListRepository.findById(id).get();
        DeviceDto dto = new DeviceDto();
        dto.id = item.getId();
        dto.name=item.getName();
        dto.ipAddress=item.getIpAddress();
        dto.location=item.getLocation();
        dto.value=item.getValue();
        dto.date=item.getDate();
        return dto;
    }

}
