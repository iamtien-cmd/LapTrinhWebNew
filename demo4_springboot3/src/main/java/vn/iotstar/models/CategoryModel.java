package vn.iotstar.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @NotEmpty(message = "Không được bỏ trống")
    private String name;

    private String images;

    private int status;

    private Boolean isEdit=false;
}
