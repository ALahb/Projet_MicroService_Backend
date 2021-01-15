package com.tutom.msuh2c;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String prenom ;
    private Date dateNaissance;
    @ManyToOne
    private Formation formation;
}

