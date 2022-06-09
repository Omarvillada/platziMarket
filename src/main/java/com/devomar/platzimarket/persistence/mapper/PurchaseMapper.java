package com.devomar.platzimarket.persistence.mapper;

import com.devomar.platzimarket.domain.Purchase;
import com.devomar.platzimarket.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    //Inverso
    @InheritInverseConfiguration
    //Siempre en la clase de destino debe teener todos los mapeos, si no tiene todos los mapeos debe ignorarlo explicitamente

    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
