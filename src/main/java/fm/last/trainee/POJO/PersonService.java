package fm.last.trainee.POJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public List getAllPersons() {
        List persons = new ArrayList();
        personRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }
    public Artist getPersonById(long id) {
        return personRepository.findById(id).get();
    }
    public void save(Artist artist){
        personRepository.save(artist);
    }
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
