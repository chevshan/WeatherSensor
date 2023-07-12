package by.malisheuski.spring.WeatherSensor.repositories;

import by.malisheuski.spring.WeatherSensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
