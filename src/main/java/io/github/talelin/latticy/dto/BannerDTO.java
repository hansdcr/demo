package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class BannerDTO {
    @NotBlank
    @Length(min = 2, max = 20)
    private String name;
    @Length(min = 2, max = 20)
    private String title;
    @Length(min = 2, max = 20)
    private String img;
}
