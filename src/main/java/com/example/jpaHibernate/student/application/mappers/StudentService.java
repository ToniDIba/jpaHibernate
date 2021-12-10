package com.example.jpaHibernate.student.application.mappers;

import com.example.jpaHibernate.profesor.application.mappers.DtoStudentProfesor;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {


    @Override
    public DtoStudentProfesor convertirDtoSp(Profesor pf, Student st) {

        DtoStudentProfesor salidaDtoSp = new DtoStudentProfesor();

        salidaDtoSp.setPf_id_persona(pf.getId_persona());
        salidaDtoSp.setPf_id_profesor(pf.getId_profesor());
        salidaDtoSp.setSt_id_persona(st.getId_persona());
        salidaDtoSp.setSt_id_student(st.getId_student());
        salidaDtoSp.setPf_asignatura(pf.getAsignatura());
        salidaDtoSp.setPf_comments(pf.getComments());
        salidaDtoSp.setSt_id_profesor(st.getId_profesor());
        salidaDtoSp.setSt_num_hours_week(st.getNum_hours_week());
        salidaDtoSp.setSt_comments(st.getComments());
        salidaDtoSp.setSt_branch(st.getBranch());


        return salidaDtoSp;
    }


}
