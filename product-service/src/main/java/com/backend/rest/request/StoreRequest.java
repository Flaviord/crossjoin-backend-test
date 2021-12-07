package com.backend.rest.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StoreRequest {
    @NotNull
    String name;
}
