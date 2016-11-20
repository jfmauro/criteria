package com.mauro.criteriahandling;

import com.mauro.pairing.IPair;

/**
 * Created by root on 19/11/16.
 */
public interface ICriteriaHandler<K,V,T extends IPair<K,V>> {
    public boolean isMatchingCriteria(T elem) throws IllegalAccessException;
    public void setCriteria(Criteria c);
}
