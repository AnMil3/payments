package mk.iwec.payments.mapper;

import mk.iwec.payments.dto.LocationDTO;
import mk.iwec.payments.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper extends GeneralMapper<Location, LocationDTO> {
}
