package by.malisheuski.spring.WeatherSensor.util;

import by.malisheuski.spring.WeatherSensor.models.Measurement;
import by.malisheuski.spring.WeatherSensor.services.SensorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Measurement.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Measurement measurement = (Measurement) o;

        if (measurement.getSensor() == null) {
            return;
        }

        if (sensorService.findByName(measurement.getSensor().getName()) == null) {
            errors.rejectValue("sensor", "There is no registered sensor with that name!");
        }
    }
}
