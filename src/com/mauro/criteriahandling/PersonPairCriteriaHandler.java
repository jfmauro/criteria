package com.mauro.criteriahandling;

import com.mauro.entity.Person;
import com.mauro.pairing.IPair;

import java.lang.reflect.Field;

/**
 * Created by root on 19/11/16.
 */
public class PersonPairCriteriaHandler implements ICriteriaHandler<Long,Person,IPair<Long,Person>> {

    private Criteria criteria;

    public PersonPairCriteriaHandler(Criteria c) {
        setCriteria(c);
    }

    @Override
    public boolean isMatchingCriteria(IPair<Long, Person> elem) throws IllegalAccessException {
        Class<? extends Person> pClass = elem.getValue().getClass();
        for (Field f : pClass.getDeclaredFields()){
            if(f.getName().equalsIgnoreCase(criteria.getName())) {
                f.setAccessible(true);
                if (f.get(elem.getValue()).equals(criteria.getValue()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void setCriteria(Criteria c) {
        this.criteria=c;
    }
}
