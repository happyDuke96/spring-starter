package spring.starter.dto;

public class CompanyReadDto {
    private  Integer id;

    public CompanyReadDto() {
    }

    public CompanyReadDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
