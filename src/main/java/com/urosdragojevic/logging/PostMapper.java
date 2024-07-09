package com.urosdragojevic.logging;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface PostMapper {
    PostDto toDto(Post post);
}
