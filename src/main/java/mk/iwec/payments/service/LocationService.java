package mk.iwec.payments.service;

import lombok.extern.slf4j.Slf4j;
import mk.iwec.payments.exception.ResourceNotFoundException;
import mk.iwec.payments.model.Location;
import mk.iwec.payments.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location findById(UUID id) {
        log.debug("Execute findById with id {}", id);

        return locationRepository.findById(id).orElseThrow(() -> {
            log.error("Error: Location with id {} is not found", id);
            return new ResourceNotFoundException("Location not found");
        });
    }

    public List<Location> findAll() {
        log.debug("Execute findAll");

        return locationRepository.findAll();
    }

    public Location insert(Location location) {
        log.debug("Execute insert with parameter {}", location);

        return locationRepository.save(location);
    }

    public void deleteById(UUID id) {
        log.debug("Execute deleteById with id {}", id);

        locationRepository.deleteById(id);
    }

    public Location update(Location location) {
        log.debug("Execute update with parameter {}", location);

        return locationRepository.save(location);
    }
}
