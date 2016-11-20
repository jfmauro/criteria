package com.mauro.map;

import com.mauro.criteriahandling.Criterias;
import com.mauro.criteriahandling.ICriteriaHandler;
import com.mauro.pairing.IPair;
import com.mauro.pairing.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 19/11/16.
 */
public class InstrumentedMap <K,V>{
    private Map<K,IPair<K,V>> map;

    public InstrumentedMap() {
        this.map = new HashMap<>();
    }

    public V put (K key, V value){
        map.put(key, new Pair(key, value));
        return value;
    }

    public List<IPair<K,V>> selectByCriteria(ICriteriaHandler<K,V,IPair<K,V>> criteriaHandler) throws IllegalAccessException {
        List<IPair<K,V>> l = new ArrayList<>(map.values());
        Criterias.filter(l, criteriaHandler);
        return l;
    }




}
