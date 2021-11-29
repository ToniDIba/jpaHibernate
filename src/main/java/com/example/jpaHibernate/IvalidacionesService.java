package com.example.jpaHibernate;

import java.util.Date;
import java.util.Optional;

public interface IvalidacionesService
{

    public Persona validarColumnas(Optional<String> usuario,
                                   Optional<String> password,
                                   Optional<String> name,
                                   Optional<String> surname,
                                   Optional<String> company_email,
                                   Optional<String> personal_email,
                                   Optional<String> city,
                                   Optional<Boolean> active,
                                   Optional<Date> created_date,
                                   Optional<String> imagen_url,
                                   Optional<Date> termination_date);


}







