package shipping.mini.parcel.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mini.parcel.domain.ParcelDomain;

import shipping.mini.parcel.infrastructure.entity.ParcelEntity;

@Mapper(componentModel = "spring")
public interface ParcelEntityMapper {

	ParcelDomain toDomain(ParcelEntity parcelEntity);
	ParcelEntity toEntity(ParcelDomain parcelDomain);
}
