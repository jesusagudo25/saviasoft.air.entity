package ec.com.saviasoft.air.entity.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRequest {

    private Integer userId;

    private String userName;

    private String name;

    private String serialNumber;

    private String location;

    private String uid;

    private Boolean status = true;

}
