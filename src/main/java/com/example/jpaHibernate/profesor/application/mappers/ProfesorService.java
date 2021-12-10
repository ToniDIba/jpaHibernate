package com.example.jpaHibernate.profesor.application.mappers;

import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.application.mappers.IStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService implements IprofesorService {

    @Override
    public DtoProfesorStudent convertirDtoPs(Profesor pf, Student st) {

        DtoProfesorStudent salidaDtoPs = new DtoProfesorStudent();

        salidaDtoPs.setPf_id_persona(pf.getId_persona());
        salidaDtoPs.setPf_id_profesor(pf.getId_profesor());
        salidaDtoPs.setSt_id_persona(st.getId_persona());
        salidaDtoPs.setSt_id_student(st.getId_student());
        salidaDtoPs.setPf_asignatura(pf.getAsignatura());
        salidaDtoPs.setPf_comments(pf.getComments());
        salidaDtoPs.setSt_id_profesor(st.getId_profesor());
        salidaDtoPs.setSt_num_hours_week(st.getNum_hours_week());
        salidaDtoPs.setSt_comments(st.getComments());
        salidaDtoPs.setSt_branch(st.getBranch());

        return salidaDtoPs;

    }
}
