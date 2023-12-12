package ec.com.saviasoft.air.entity;

import ec.com.saviasoft.air.entity.model.request.DeviceRequest;
import ec.com.saviasoft.air.entity.service.DeviceService;
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
			DeviceService service
	) {
		return args -> {
			var device = service.createDevice(DeviceRequest.builder()
					.userId(1)
					.name("Device 1")
					.serialNumber("123456789")
					.location("Quito")
					.uid("b3ff7c1e-85d2-11ee-b9d1-0242ac120002")
					.status(true)
					.build());
			System.out.println("Device: " + device);
		};
	}
}
