package my.starter.school;

import my.starter.school.bean.Klass;
import my.starter.school.bean.School;
import my.starter.school.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SchoolProperties.class)
public class SchoolConfig {

    @Autowired
    private SchoolProperties schoolProperties;

    @Bean
    public School getSchoolInfo(){
        Klass clz = new Klass();
        clz.setStudents(schoolProperties.getStudents());

        Student student = new Student();
        student.setId(schoolProperties.getId());
        student.setName(schoolProperties.getName());

        School school = new School();
        school.setKlass(clz);
        school.setStudent1(student);

        return school;
    }
}
