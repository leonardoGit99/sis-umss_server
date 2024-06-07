package org.umss.sis_umss.repositories;

import org.springframework.stereotype.Component;
import org.umss.sis_umss.dtos.UniversityDTO;
import org.umss.sis_umss.models.University;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class UniversityRepository {
    private static List<University> universityList = new ArrayList<>();
    private static int idCounter;

    static {
        idCounter = 4;
        universityList.add(new University(1, UUID.randomUUID().toString(), "Universidad Mayor de San Simon", "UMSS", new Date()));
        universityList.add(new University(2, UUID.randomUUID().toString(), "Universidad Privada del Valle", "Univalle", new Date()));
        universityList.add(new University(3, UUID.randomUUID().toString(), "Universidad Catolica Boliviana", "UCB", new Date()));
    }


    // Simulating methods of JPA. Access a DB

    public List<University> findAll() {
        return universityList;
    }

    public University save(University newUniversity) {
        newUniversity.setId(idCounter);
        newUniversity.setUuid(UUID.randomUUID().toString());
        universityList.add(newUniversity);
        idCounter++;
        return newUniversity;
    }

    public University findOneByUuid(String uuid) {
        return universityList
                .stream() //When list converts to stream, we can use some Javascript methods for lists
                .filter(university -> university.getUuid().equals(uuid))
                .findAny()
                .orElse(null);
    }

    //Stream method with for
    /*public University findOneByUuid(String uuid) {
        for (University university : universityList) {
            if (university.getUuid().equals(uuid)) {
                return university;
            }
        }
        return null;
    }*/
}
