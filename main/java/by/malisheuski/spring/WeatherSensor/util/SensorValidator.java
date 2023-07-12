package by.malisheuski.spring.WeatherSensor.util;

import by.malisheuski.spring.WeatherSensor.models.Sensor;
import by.malisheuski.spring.WeatherSensor.services.SensorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Sensor.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Sensor sensor = (Sensor) o;

        if (sensorService.findByName(sensor.getName()) != null) {
            errors.rejectValue("name", "There is already a sensor with this name");
        }
    }
}
