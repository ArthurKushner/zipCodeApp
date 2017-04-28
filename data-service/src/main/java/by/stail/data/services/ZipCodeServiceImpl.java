package by.stail.data.services;

import by.stail.data.entities.ZipCode;
import by.stail.data.repository.ZipCodeRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

/**
 * @autor Arthur Kushner
 * @since 4/26/17
 */
@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Inject
    ZipCodeRepository zipCodeRepository;

    @Override
    public List<ZipCode> getAllZipCodes() {
        return zipCodeRepository.findAll();
    }


    @Override
    public Stream<ZipCode> getAllZipCodesAsStream(){
        return zipCodeRepository.findAllAsStream();
    }
}
