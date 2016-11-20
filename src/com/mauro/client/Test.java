package com.mauro.client;

import com.mauro.criteriahandling.Criteria;
import com.mauro.criteriahandling.ICriteriaHandler;
import com.mauro.criteriahandling.PersonPairCriteriaHandler;
import com.mauro.entity.Person;
import com.mauro.map.InstrumentedMap;
import com.mauro.pairing.IPair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 19/11/16.
 */
public class Test {
    public static void main(String... args) throws IllegalAccessException {
        InstrumentedMap<Long,Person> map=new InstrumentedMap<>();
        List<Person> persons=getPersons();
        for(Person p : persons)
            map.put(p.getId(), p);

        Criteria c=new Criteria("lastname", "voe");
        ICriteriaHandler<Long,Person,IPair<Long,Person>> pairICriteriaHandler=new PersonPairCriteriaHandler(c);
        List<IPair<Long,Person>> selectByCriteriaResult = map.selectByCriteria(pairICriteriaHandler);
        for (IPair<Long,Person> pair : selectByCriteriaResult)
            System.out.println(pair.getValue().getLastname() + ", " + pair.getValue().getFirstname());

    }


    public static List<Person> getPersons() {
        List<Person> persons=new ArrayList<>();
        persons.add(new Person(1l,"moe","john"));
        persons.add(new Person(2l,"voe","john"));
        persons.add(new Person(3l,"soe","john"));
        persons.add(new Person(4l,"voe","cliff"));
        return persons;
    }
}
