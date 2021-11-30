package com.backend.rest.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProductRequest {
    Long id;
    String name;
    Long quantity;
    Date created;
    Long storeId;
}
