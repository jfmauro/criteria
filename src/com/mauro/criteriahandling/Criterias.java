package com.mauro.criteriahandling;

import com.mauro.pairing.IPair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 19/11/16.
 */
public class Criterias {
    public static <K,V,T extends IPair<K,V>> void filter(List<T> l, ICriteriaHandler<K,V,T> iCriteriaHandler) throws IllegalAccessException {
        List<T> retVal=new ArrayList<>();
        for (T elem : l){
            if(iCriteriaHandler.isMatchingCriteria(elem))
                retVal.add(elem);
        }
        l.clear();
        for (T e : retVal)
            l.add(e);
    }
}
