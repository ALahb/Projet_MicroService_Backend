package com.tutom.msuh2c;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types ={Etudiant.class} )
public interface EtudinatProjection {
    public String getNom();
    public Formation getFormation();
}
