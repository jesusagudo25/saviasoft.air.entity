package ec.com.saviasoft.air.entity.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemConfigRequest {

        private Double maxMetano;

        private Double maxCO2;

        private Double maxPPM;
}
