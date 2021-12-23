package com.arboleda.arboledapayments.db;

import com.arboleda.arboledapayments.model.*;
import com.arboleda.arboledapayments.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(
            CompanyRepository companyRepository,
            ServiceRepository serviceRepository,
            UserRepository userRepository,
            AccountRepository accountRepository,
            PendingPaymentRepository pendingPaymentRepository) {
        return args -> {
            var uni = new Company(1L, "Universidad Nacional de Ingenieria", "Educacion");

            companyRepository.save(uni);
            companyRepository.save(new Company(2L, "Rico pollo", "Retail"));

            var autoseguro = new Service(3L, "PEN", uni, "Autoseguro");

            serviceRepository.save(autoseguro);
            serviceRepository.save(new Service(4L, "PEN", uni, "Constancia de egresado"));
            serviceRepository.save(new Service(5L, "PEN", uni, "Verano 21-3"));

            var user1 = new User(6L, "Juan Perez", "Password");
            userRepository.save(user1);

            accountRepository.save(new Account(7L, "PEN", user1, 1000.0));

            pendingPaymentRepository.save(new PendingPayment(8L, autoseguro, "20000001A", 50.0, new Date(), null));
        };

    }
}
