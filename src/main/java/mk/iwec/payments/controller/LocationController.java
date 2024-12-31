package mk.iwec.payments.controller;

import mk.iwec.payments.Endpoints;
import mk.iwec.payments.dto.LocationDTO;
import mk.iwec.payments.mapper.LocationMapper;
import mk.iwec.payments.model.Location;
import mk.iwec.payments.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Endpoints.LOCATION)
public class LocationController {

    private final LocationService locationService;
    private final LocationMapper locationMapper;

    public LocationController(LocationService locationService, LocationMapper locationMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }

    @GetMapping
    public List<LocationDTO> findAll() {
        List<Location> locations = locationService.findAll();
        return locations.stream()
                .map(locationMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LocationDTO findById(@PathVariable UUID id) {
        Location location = locationService.findById(id);
        return locationMapper.entityToDto(location);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public LocationDTO insert(@RequestBody Location location) {
        return locationMapper.entityToDto(locationService.insert(location));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        locationService.deleteById(id);
    }

    @PutMapping("/{id}")
    public LocationDTO update(@PathVariable UUID id, @RequestBody Location location) {
        return locationMapper.entityToDto(locationService.update(location));
    }

}
