package com.dealdash.orderservice.dto;


import com.dealdash.orderservice.model.OrderLineItems;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    //private String orderNumber;
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
