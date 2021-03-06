package by.pvt.device;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.pvt.pojo.Device;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    DeviceListService deviceListService;

    @GetMapping
    public String search (@RequestParam String searchStr, Model model){
        List<Device> devices =deviceListService.searchDeviceByipAddress(searchStr);
        model.addAttribute("devices", devices);
        return "searchResultPage";

    }
}

