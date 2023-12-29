package ec.com.saviasoft.air.entity;

import ec.com.saviasoft.air.entity.model.pojo.SystemConfig;
import ec.com.saviasoft.air.entity.model.request.DeviceRequest;
import ec.com.saviasoft.air.entity.model.request.SystemConfigRequest;
import ec.com.saviasoft.air.entity.service.DeviceService;
import ec.com.saviasoft.air.entity.service.SystemConfigService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			DeviceService service,
			SystemConfigService systemConfigService
	) {
		return args -> {
			var device = service.createDevice(DeviceRequest.builder()
					.userId(1)
					.name("Device 1")
					.userName("Admin admin")
					.serialNumber("123456789")
					.location("Quito")
					.uid("03d5d65a-5e6f-4395-ab30-100f6ea8a8f8\t\n")
					.build());

			var systemConfig = systemConfigService.createSystemConfig(SystemConfigRequest.builder()
					.maxMetano(123.03)
					.maxCO2(100.03)
					.maxPPM(100.03)
					.build());
			System.out.println("Device: " + device);
			System.out.println("SystemConfig: " + systemConfig);
		};
	}
}
