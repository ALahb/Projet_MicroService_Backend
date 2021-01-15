package com.tutom.msuh2c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import java.util.Date;

@SpringBootApplication
public class MsUh2cApplication implements CommandLineRunner {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private FormationRepository formationRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsUh2cApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Formation .class,Etudiant .class);
        repositoryRestConfiguration.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");


        Formation f1=formationRepository.save(new Formation(null,"PHP",30,null));
        Formation f2=formationRepository.save(new Formation(null,"React",30,null));
        Formation f3=formationRepository.save(new Formation(null,"Angular",30,null));
        Formation f4=formationRepository.save(new Formation(null,"python",30,null));
        Formation f5=formationRepository.save(new Formation(null,"Springboot",30,null));


        etudiantRepository.save(new Etudiant(null,"Ala","Hadj Brahim",new Date(),f1));
        etudiantRepository.save(new Etudiant(null,"ichrak","Ben Abdallah",new Date(),f2));
        etudiantRepository.save(new Etudiant(null,"mariem","makkadem",new Date(),f4));
        etudiantRepository.save(new Etudiant(null,"koussai","mestiri",new Date(),f4));
        etudiantRepository.save(new Etudiant(null,"Yara","Sbai",new Date(),f5));



    }
}
