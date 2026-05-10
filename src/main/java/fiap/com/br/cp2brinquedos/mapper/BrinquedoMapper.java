package fiap.com.br.cp2brinquedos.mapper;

import fiap.com.br.cp2brinquedos.dto.BrinquedoDto;
import fiap.com.br.cp2brinquedos.dto.BrinquedoResponse;
import fiap.com.br.cp2brinquedos.model.Brinquedo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BrinquedoMapper {

    Brinquedo toEntity(BrinquedoDto dto);

    BrinquedoResponse toResponse(Brinquedo brinquedo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(BrinquedoDto dto, @MappingTarget Brinquedo brinquedo);
}
