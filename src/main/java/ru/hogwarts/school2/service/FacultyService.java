package ru.hogwarts.school2.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school2.model.Faculty;
import ru.hogwarts.school2.model.Student;

import java.util.*;

@Service
public class FacultyService {

    private final Map<Long, Faculty> list = new HashMap<>();
    private long counter = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(counter++);
        list.put(counter, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return list.get(id);
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        if (!list.containsKey(id)) {
            return null;
        }
        list.put(id, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return list.remove(id);
    }

    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : list.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}
