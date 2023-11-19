package ec.com.saviasoft.air.entity.model.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_device")
public class Device {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;
    
    private String name;

    private String serialNumber;

    private String location;
    
    private String uid;

    private Boolean status = true;

    private Date createdDate = new Date();

    private Date updatedDate = new Date();
}
