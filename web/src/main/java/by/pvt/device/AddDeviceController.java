package by.pvt.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.pvt.pojo.Device;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/addDevice")
public class AddDeviceController {

    private static Logger log = Logger.getLogger("AddDeviceController");

    @Autowired
    DeviceListService deviceListService;

    @Autowired
    DeviceValidator validator;

    @GetMapping
    public String showAddDevicePage(){

        return "addDevicePage";
    }

    @PostMapping("/device")
    public String addNewDevice(
            @ModelAttribute("device") Device device,
            BindingResult result,
            Model model) throws IOException{

        log.info("New device: "+device);

        validator.validate(device,result);
        if (result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "addDevicePage";
        }

        return "error";
    }
}