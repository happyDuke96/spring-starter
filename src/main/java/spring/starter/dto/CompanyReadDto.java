package spring.starter.dto;

import lombok.Data;

@Data
public class CompanyReadDto {
    private  Integer id;

    public CompanyReadDto() {
    }

    public CompanyReadDto(Integer id) {
        this.id = id;
    }

}
