package shipping.mini.parcel.mapper;

import org.mapstruct.Mapper;

import com.mini.parcel.domain.ParcelDomain;

import shipping.mini.parcel.dto.ParcelDTO;

@Mapper(componentModel = "spring")
public interface ParcelDomainMapper {

	ParcelDTO toDTo(ParcelDomain domain);
	ParcelDomain toDomain(ParcelDTO dto);
}
