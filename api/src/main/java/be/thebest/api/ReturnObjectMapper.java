package be.thebest.api;

import be.thebest.api.ReturnObjectDto;
import be.thebest.service.ReturnObject;

public class ReturnObjectMapper {
    public ReturnObjectDto toDto(ReturnObject returnObject) {
        return ReturnObjectDto.returnObjectDto()
                .withReturnCode(returnObject.getReturnCode())
                .withMessage(returnObject.getMessage());
    }

    public ReturnObject toDomain(ReturnObjectDto returnObjectDto) {
        return ReturnObject.returnObject(returnObjectDto.getReturnCode(), returnObjectDto.getMessage());
    }
}
