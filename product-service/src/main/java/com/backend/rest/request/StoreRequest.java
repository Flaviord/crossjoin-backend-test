package com.backend.rest.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class StoreRequest {
    Long id;
    String name;
    Date created;
}
