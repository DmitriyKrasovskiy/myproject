package by.pvt.device;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.pvt.pojo.Device;

@Component
public class DeviceValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Device.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target==null){
            errors.reject("object.null", "Device is null");
            return;
        }

        Device device =(Device)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ipAddress","ipAddress.empty", "The IP address is empty");
    }
}
