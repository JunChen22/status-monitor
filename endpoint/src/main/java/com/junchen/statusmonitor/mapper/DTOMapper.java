package com.junchen.statusmonitor.mapper;

import com.junchen.statusmonitor.DTO.ApplicationDTO;
import com.junchen.statusmonitor.DTO.EventDTO;
import com.junchen.statusmonitor.entity.Applications;
import com.junchen.statusmonitor.entity.UpdateEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    DTOMapper INSTANCE = Mappers.getMapper(DTOMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateModified", ignore = true)
    Applications applicationDTOToApplication(ApplicationDTO applicationDTO);

    ApplicationDTO applicationToApplicationDTO(Applications applications);

    List<EventDTO>  updateEventToDTO(List<UpdateEvent> updateEvent);

}
