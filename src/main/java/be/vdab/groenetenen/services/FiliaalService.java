package be.vdab.groenetenen.services;

import be.vdab.groenetenen.domain.Filiaal;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface FiliaalService {
    @PreAuthorize("hasAuthority('manager')")
    List<Filiaal> findByPostcode(int van, int tot);
    void delete(Filiaal filiaal);
    void create(Filiaal filiaal);
    void update(Filiaal filiaal);
    List<Filiaal> findAll();
    void afschrijven(long id);
}
