package com.backend.rest.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProductRequest {
    @NotNull
    String name;
    @NotNull
    Long quantity;
    Date created;
    @NotNull
    Long storeId;
}
