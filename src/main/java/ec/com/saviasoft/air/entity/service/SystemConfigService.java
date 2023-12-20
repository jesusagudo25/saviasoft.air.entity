package ec.com.saviasoft.air.entity.service;

import ec.com.saviasoft.air.entity.data.SystemConfigRepository;
import ec.com.saviasoft.air.entity.model.pojo.SystemConfig;
import ec.com.saviasoft.air.entity.model.request.SystemConfigRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemConfigService {

    private final SystemConfigRepository repository;

    public SystemConfig createSystemConfig(SystemConfigRequest systemConfig) {
        return repository.save(SystemConfig.builder()
                .maxMetano(systemConfig.getMaxMetano())
                .maxCO2(systemConfig.getMaxCO2())
                .maxPPM(systemConfig.getMaxPPM())
                .build());
    }

    public SystemConfig updateSystemConfig(Integer id, SystemConfigRequest systemConfig) {
        SystemConfig systemConfigToUpdate = repository.findById(id).orElse(null);
        assert systemConfigToUpdate != null;
        systemConfigToUpdate.setMaxMetano(systemConfig.getMaxMetano());
        systemConfigToUpdate.setMaxCO2(systemConfig.getMaxCO2());
        systemConfigToUpdate.setMaxPPM(systemConfig.getMaxPPM());
        return repository.save(systemConfigToUpdate);
    }

    public SystemConfig findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
