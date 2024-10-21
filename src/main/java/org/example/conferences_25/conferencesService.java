package org.example.conferences_25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class conferencesService {

    @Autowired
    private conferencesRepository repo;

    public List<Conferences> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public Conferences get(Long id) {
        return repo.findById(id).get();
    }

    public void save(Conferences conference) {
        repo.save(conference);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Conferences> getAllConferencesSorted(Sort sort) {
        return repo.findAll(sort);
    }
}
