package com.rodrigoramos.sistemabancarioapi.dto;

import com.rodrigoramos.sistemabancarioapi.service.validation.CustomerInsert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@CustomerInsert
public class CustomerNewDTO implements Serializable {
    private static final long serialVersionUID = 4471777119419172870L;

    @NotEmpty(message = "Name may not be empty")
    @Length(min=5, max=120, message="The length must be between 5 and 120 characters")
    private String name;

    @NotEmpty(message = "cpfOuCnpj may not be empty")
    private String cpfOuCnpj;

    private Integer customerType;

}
