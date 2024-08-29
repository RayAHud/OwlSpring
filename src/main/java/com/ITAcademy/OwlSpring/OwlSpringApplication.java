package com.ITAcademy.OwlSpring;

import com.ITAcademy.OwlSpring.entity.CarEntity;
import com.ITAcademy.OwlSpring.entity.CatalogModelEntity;
import com.ITAcademy.OwlSpring.entity.CountryEntity;
import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
//import com.ITAcademy.OwlSpring.entity.UserEntity;
import com.ITAcademy.OwlSpring.repository.CarRepository;
import com.ITAcademy.OwlSpring.repository.CatalogModelRepository;
import com.ITAcademy.OwlSpring.repository.CountryRepository;
import com.ITAcademy.OwlSpring.repository.ManufacturerRepository;
//import com.ITAcademy.OwlSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
//import org.springframework.security.crypto.password.PasswordEncoder;


/*	H2 console address = "http://localhost:8080/h2-ui"	*/
@SpringBootApplication
public class OwlSpringApplication implements CommandLineRunner {


	public static void main(String[] args) throws Exception{
		SpringApplication.run(OwlSpringApplication.class, args);
	}

	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Autowired
	private CatalogModelRepository catalogModelRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CountryRepository countryRepository;
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private PasswordEncoder encoder;
	@Override
	public void run(String... args) throws Exception {
		/*	Populate Database with 5 Manufacturers	*/
		manufacturerRepository.save(new ManufacturerEntity("Ford"));
		manufacturerRepository.save(new ManufacturerEntity("Pro-Line"));
		manufacturerRepository.save(new ManufacturerEntity("Dodge"));
		manufacturerRepository.save(new ManufacturerEntity("John Deere"));
		manufacturerRepository.save(new ManufacturerEntity("Chevrolet"));

		/*	Populate Database with Countries	*/
		CountryEntity uS = new CountryEntity("US", "United States");
		CountryEntity jP = new CountryEntity("JP", "Japan");
		CountryEntity cN = new CountryEntity("CN", "China");

//		countryRepository.save(new CountryEntity("US", "United States"));
//		countryRepository.save(new CountryEntity("JP", "Japan"));
//		countryRepository.save(new CountryEntity("CN","China"));

		ArrayList<CountryEntity> countriesList = new ArrayList<>();
		countriesList.add(uS);
		countriesList.add(jP);
		countriesList.add(cN);

		countriesList.stream().forEach(countryEntity -> countryRepository.save(countryEntity));

		/*	Populate H2 Database with 10 CatalogModels	*/
		catalogModelRepository.save(new CatalogModelEntity("Sonic", 5L, "A cute little hatchback", "Car", 3L));
		catalogModelRepository.save(new CatalogModelEntity("Corvette", 5L, "Classic Sports car", "Car", 3L));
		catalogModelRepository.save(new CatalogModelEntity("Camaro", 5L, "Sports car", "Car", 3L));
		catalogModelRepository.save(new CatalogModelEntity("Challenger", 3L, "Boxy fast car", "Car", 2L));
		catalogModelRepository.save(new CatalogModelEntity("Charger", 3L, "Affordable and stylish", "Car", 2L));
		catalogModelRepository.save(new CatalogModelEntity("Hornet", 3L, "Watch out. It stings", "Car", 2L));
		catalogModelRepository.save(new CatalogModelEntity("Mustang", 1L, "An American Classic", "Car",1L));
		catalogModelRepository.save(new CatalogModelEntity("Escort", 1L, "Boring commuter vehicle", "Car",1L));
		catalogModelRepository.save(new CatalogModelEntity("Taurus", 1L, "Boring Sedan sized vehicle", "Car",1L));
		catalogModelRepository.save(new CatalogModelEntity("Focus", 1L, "Cheap and affordable commuter", "Car",1L));

		/*	Populate H2 Database with 50 Vehicles 	*/
		carRepository.save(new CarEntity(1000L, "Black", 5L, 1L, 4L, 3L));
		carRepository.save(new CarEntity(1001L, "Blue", 5L,1L, 4L,3L));
		carRepository.save(new CarEntity(1002L, "Red", 5L, 1L, 4L,3L));
		carRepository.save(new CarEntity(1003L, "Black", 5L, 1L, 4L,3L));
		carRepository.save(new CarEntity(1004L, "Blue", 5L, 1L, 4L,3L));
		carRepository.save(new CarEntity(1005L, "Red", 5L, 1L, 4L,3L));

		carRepository.save(new CarEntity(1006L, "Black", 5L, 2L, 4L,3L));
		carRepository.save(new CarEntity(1007L, "Red", 5L, 3L, 4L,3L));
		carRepository.save(new CarEntity(1008L, "Blue", 3L, 4L, 4L,2L));
		carRepository.save(new CarEntity(1009L, "White", 3L, 5L, 4L,2L));
		carRepository.save(new CarEntity(1010L, "Blue", 3L, 6L, 4L,2L));
		carRepository.save(new CarEntity(1011L, "Black", 1L, 7L, 4L,1L));
		carRepository.save(new CarEntity(1012L, "Blue", 1L, 8L, 4L,1L));
		carRepository.save(new CarEntity(1013L, "Red", 1L, 9L, 4L,1L));
		carRepository.save(new CarEntity(1014L, "Red", 1L, 10L, 4L,1L));


		//make loops to create Randomized Vehicles
		for (int i = 16; i <= 30; i++){
			carRepository.save(new CarEntity(1000L+i, colorRandomizer(1000L+i), 3L, dodgeRandomizer(1000L+i), 4L,2L));
		}
		for (int i = 31; i <= 40; i++){
			carRepository.save(new CarEntity(1000L+i, colorRandomizer(1000L+i), 1L, fordRandomizer(1000L+i), 4L,1L));
		}
		for (int i = 41; i <= 51; i++){
			carRepository.save(new CarEntity(1000L+i, colorRandomizer(1000L+i), 5L, chevyRandomizer(1000L+i), 4L,3L));
		}




		/* Populate H2 Database with Users */
//		userRepository.save(new UserEntity("user",encoder.encode("password"),"ROLE_USER"));
//		userRepository.save(new UserEntity("admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));

	}

	// color randomizer
	String colorRandomizer(Long serialNumber){
		Long lastNumberLong = getLastNumber(serialNumber);
		if (lastNumberLong >= 1L && lastNumberLong <= 2L) {
			System.out.println("It's between 1 and 2");
			return "Red";
		} if (lastNumberLong >= 3L && lastNumberLong <= 5L) {
			System.out.println("It's between 3 and 5");
			return "White";
		} else {
			System.out.println("It's between 6 and 10");
			return "Blue";
		}
	}

	CountryEntity fetchCountry (Long id){
		CountryEntity countryEntity = new CountryEntity();

		return countryEntity;
	}

	Long dodgeRandomizer(Long serialNumber){
		Long lastNumberLong = getLastNumber(serialNumber);
		if (lastNumberLong >= 1L && lastNumberLong <= 3L) {
			return 4L;
		} if (lastNumberLong >= 4L && lastNumberLong <= 7L) {
			return 5L;
		} else {
			return 6L;
		}
	}

	Long fordRandomizer(Long serialNumber){
		Long lastNumberLong = getLastNumber(serialNumber);
		if (lastNumberLong >= 1L && lastNumberLong <= 3L) {
			return 7L;
		} if (lastNumberLong >= 4L && lastNumberLong <= 6L) {
			return 8L;
		} if (lastNumberLong >= 7L && lastNumberLong <= 8L) {
			return 9L;
		} else {
			return 10L;
		}
	}

	Long chevyRandomizer(Long serialNumber){
		Long lastNumberLong = getLastNumber(serialNumber);
		if (lastNumberLong >= 1L && lastNumberLong <= 5L) {
			return 2L;
		} else {
			return 3L;
		}
	}

	Long getLastNumber(Long serialNumber){
		String[] longToString = serialNumber.toString().split("");
		String lastNumberString = longToString[(longToString.length) - 1];
		return Long.parseLong(lastNumberString);
	}










}
