package ru.hogwarts.school2.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school2.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final Map<Long, Student> list = new HashMap<>();
    private long counter = 0;

    public Student addStudent(Student student) {
        student.setId(counter++);
        list.put(counter, student);
        return student;
    }

    public Student findStudent(long id) {
        return list.get(id);
    }

    public Student editStudent(long id, Student student) {
        if (!list.containsKey(id)) {
            return null;
        }
        list.put(id, student);
        return student;
    }

    public Student deleteStudent(long id) {
        return list.remove(id);
    }

    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : list.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
