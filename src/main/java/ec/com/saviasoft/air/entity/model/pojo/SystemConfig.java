package ec.com.saviasoft.air.entity.model.pojo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_system_config")
public class SystemConfig {

    @Id
    @GeneratedValue

    private Integer id;

    private Integer userId;

    private Integer min;

    private Integer max;

    private Boolean notification = true;
}
