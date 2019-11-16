package by.pvt.device;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import by.pvt.pojo.Device;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceListService deviceListService;

    @GetMapping("device/{id}")
    public String showDeviceItem(@PathVariable Long id, Model model){

        Device device =deviceListService.getDevice(id);

        model.addAttribute("device", device);
        return "deviceDetailsPage";
    }
}