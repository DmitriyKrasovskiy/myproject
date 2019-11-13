package by.pvt.repo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.pvt.pojo.Device;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceListRepositoryImpl {

    static List<Device> catalog = new ArrayList<>();

    public List <Device> find (int i){
        return catalog.stream()
                .limit(i)
                .collect(Collectors.toList());
    }

    public void save (Device item){
        catalog.add(item);
    }

    public Device load (long id){
        return catalog.stream()
                .filter(deviceItem->deviceItem.getId()==id)
                .findFirst()
                .get();
    }

    public void update (Device item){
        catalog.removeIf(deviceItem->deviceItem
                .getId()
                .equals(item.getId()));
        catalog.add(item);

    }
}
