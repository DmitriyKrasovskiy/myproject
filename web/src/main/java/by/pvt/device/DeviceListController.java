package by.pvt.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.pvt.pojo.Device;

import java.util.List;

@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    DeviceListService deviceListService;

    @RequestMapping(method = RequestMethod.GET)
    public String showDeviceList(Model model){
        List<Device> device = deviceListService.searchDeviceByLocation("M1-365km");
        model.addAttribute("device", device);
        return "deviceListPage";
    }
}
