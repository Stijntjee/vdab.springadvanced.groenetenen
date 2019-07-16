package be.vdab.groenetenen.services;

import be.vdab.groenetenen.domain.Offerte;
import be.vdab.groenetenen.repositories.OfferteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
public class DefaultOfferteService implements OfferteService {
    OfferteRepository offerteRepository;

    //CONSTRUCTORS
    DefaultOfferteService(OfferteRepository offerteRepository)
    {
        this.offerteRepository = offerteRepository;
    }
    @Override
    public void create(Offerte offerte) {
        offerteRepository.save(offerte);
    }
}
