package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	@Mappings({
			@Mapping(source= "idCategoria", target = "categoryId"),
			@Mapping(source= "descripcion", target = "category"),
			@Mapping(source= "estado", target = "active"),
	})
	Category toCategory(Categoria categoria);

	//al ponerle esto ya no hace falta ponerle los maping porque se da cuenta de que es lo contrario del otro
	@InheritInverseConfiguration
	@Mapping(target = "productos", ignore = true) //ya que no le ponemos la lista de productos tenemos que decirle con el mapping que lo ignore
	Categoria toCategoria(Category category);
}
