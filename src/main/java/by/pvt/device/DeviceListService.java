package by.pvt.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.pvt.pojo.Device;

import javax.transaction.Transactional;
import java.util.List;

import static by.pvt.device.DeviceRepository.catalog;

@Service
@Transactional
public class DeviceListService {

    @Autowired
    DeviceRepository deviceRepository;

    @Transactional
    public List<Device> searchDeviceByipAddress(String searchStr){
        return deviceRepository
                .findDeviceByIPAddress(searchStr);
    }

    @Transactional
    public Device getDeviceById (Long id){
        return catalog.stream()
                .filter(device -> device.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @Transactional
    public List<Device> searchDeviceByLocation(String searchStr){
        return deviceRepository.findDeviceByLocation(searchStr);
    }


    @Transactional
    public void saveNewDevice(Device device){
        deviceRepository.save(device);
    }
}
