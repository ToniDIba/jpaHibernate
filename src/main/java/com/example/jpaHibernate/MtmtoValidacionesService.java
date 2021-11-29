package com.example.jpaHibernate;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MtmtoValidacionesService implements IvalidacionesService {


    @Override
    public Persona validarColumnas(Optional<String> usuario, Optional<String> password, Optional<String> name,
                                   Optional<String> surname, Optional<String> company_email, Optional<String> personal_email,
                                   Optional<String> city, Optional<Boolean> active, Optional<Date> created_date,
                                   Optional<String> imagen_url, Optional<Date> termination_date)
    {

        return new Persona();

    }


}
