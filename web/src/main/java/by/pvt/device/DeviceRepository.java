package by.pvt.device;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.pvt.pojo.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class DeviceRepository {

    private Logger log = Logger.getLogger("DeviceRepository");

    @Autowired
    SessionFactory sessionFactory;

    static List<Device> catalog =new ArrayList<>();

    public List<Device> findDeviceByIPAddress(String searchStr){
        return sessionFactory.getCurrentSession()
                .createQuery("from Device d where d.ipAddress like :param1", Device.class)
                .setParameter("param1", "%"+searchStr+"%")
                .setMaxResults(15)
                .list();
    }

    public Device findDeviceById(Long id){
        return sessionFactory.getCurrentSession()
                .get(Device.class,id);
    }

    public List <Device> findDeviceByLocation(String searchStr){
        return sessionFactory.getCurrentSession()
                .createQuery("from Device d where d.location like :param1", Device.class)
                .setParameter("param1","%"+searchStr+"%")
                .setMaxResults(15)
                .list();
    }


    public void save(Device device){
        sessionFactory.getCurrentSession()
                .persist(device);
    }
}