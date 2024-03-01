package tn.cpg.internshipservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InternshipServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternshipServiceApplication.class, args);
    }

/*  @Bean
    CommandLineRunner commandLineRunner(InternRepository internRepository) {
        return args -> {
            List<Intern> internList = List.of(

                    Intern.builder()
                            .cin(12365478)
                            .password("1234")
                            .firstname("maryem")
                            .lastname("ghobber")
                            .mail("maryem@gmail.com")
                            .phoneNumber(14256398)
                            .birthdate(LocalDate.of(1992, 1, 23))
                            .level(Level.ENGINEERING)
                            .classLevel(ClassLevel.THIRD_LEVEL)
                            .build(),
                    Intern.builder()
                            .cin(25639874)
                            .password("1234")
                            .firstname("aicha")
                            .lastname("ghobber")
                            .mail("aicha@gmail.com")
                            .phoneNumber(36527489)
                            .birthdate(LocalDate.of(1994, 9, 4))
                            .level(Level.ENGINEERING)
                            .classLevel(ClassLevel.THIRD_LEVEL)
                            .build()
            );

            internRepository.saveAll(internList);
        };
    }*/
}
