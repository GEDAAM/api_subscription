package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.enums.GroupStatus;
import br.edu.gedaam.repository.GroupRepository;
import br.edu.gedaam.util.DateTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    protected Map<String, Group> groups = new HashMap<>();
    protected Semester semester;


    protected Group newGroup(String key, String desc, String local,
                           boolean monday, boolean tuesday, boolean wednesday, boolean thrusday, boolean friday,
                           String timeBegin, String timeEnd, List<Person> coordinators, Integer maxOfStudents) {

        Group group = new Group(desc, local, monday,tuesday,wednesday,thrusday,friday,
                DateTimeConverter.formatTime(timeBegin+":00"),
                DateTimeConverter.formatTime(timeEnd+":00"), maxOfStudents);
        group.setCoordinators(coordinators);
        group.setSemester(semester);
        group.setDateBegin(Date.valueOf("2019-03-01"));
        group.setDateEnd(Date.valueOf("2019-12-01"));
        group.setStatus(GroupStatus.A_INICIAR);
        groupRepository.save(group);
        groups.put(key, group);
        return (group);
    }

}
