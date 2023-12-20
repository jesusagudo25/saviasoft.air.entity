package ec.com.saviasoft.air.entity.controller;

import ec.com.saviasoft.air.entity.model.pojo.Device;
import ec.com.saviasoft.air.entity.model.pojo.SystemConfig;
import ec.com.saviasoft.air.entity.model.request.SystemConfigRequest;
import ec.com.saviasoft.air.entity.service.SystemConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system-config")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class SystemConfigController {

    private final SystemConfigService service;

    @GetMapping("/{id}")
    public ResponseEntity<SystemConfig> getSystemConfig(@PathVariable Integer id) {
        SystemConfig systemConfig = service.findById(id);

        if (systemConfig != null) {
            return ResponseEntity.ok(systemConfig);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemConfig> updateSystemConfig(@PathVariable Integer id, @RequestBody SystemConfigRequest systemConfig) {
        return ResponseEntity.ok(service.updateSystemConfig(id, systemConfig));
    }
}
