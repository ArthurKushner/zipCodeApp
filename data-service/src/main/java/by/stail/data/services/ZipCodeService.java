package by.stail.data.services;

import by.stail.data.entities.ZipCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * @autor Arthur Kushner
 * @since 4/26/17
 */
@Service
public interface ZipCodeService {

    List<ZipCode> getAllZipCodes();

    Stream<ZipCode> getAllZipCodesAsStream();
}
