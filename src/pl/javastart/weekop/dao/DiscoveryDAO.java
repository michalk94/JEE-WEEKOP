package pl.javastart.weekop.dao;

import pl.javastart.weekop.model.Discovery;

import java.util.List;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long> {
    List<Discovery> getAll();
}
