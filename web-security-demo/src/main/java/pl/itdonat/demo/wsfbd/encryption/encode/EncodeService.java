package pl.itdonat.demo.wsfbd.encryption.encode;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Service
public class EncodeService {

    private final ApplicationContext applicationContext;
    private Map<Algorithm, Encode> algorithmEncodeMap;

    @Autowired
    public EncodeService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public List<EncodeData> prepareEncodedValueByAlgorithmMap(String plainText){
        return Arrays.stream(Algorithm.values())
            .map(algorithm -> algorithmEncodeMap.get(algorithm).encodeData(algorithm, plainText))
            .sorted(Comparator.comparingDouble(EncodeData::getDuration))
            .collect(Collectors.toList());
    }

    @PostConstruct
    private void prepareEncodeByAlgorithmMap(){
        Collection<Encode> values = applicationContext.getBeansOfType(Encode.class).values();
        algorithmEncodeMap = Arrays.stream(Algorithm.values())
            .collect(Collectors.toMap(
                algorithm -> algorithm,
                algorithm -> getEncode(values, algorithm)
            ));
    }

    private Encode getEncode(Collection<Encode> values, Algorithm algorithm) {
        return values.stream().filter(encode -> encode.isCorrectAlgorithm(algorithm)).findAny().orElseThrow(() -> new IllegalArgumentException("Unaccepted algorithm: "+algorithm));
    }

    public String bruteForce(String hash, Algorithm algorithm) {

        Encode encode = algorithmEncodeMap.get(algorithm);
        return IntStream.range(0, 10000000).boxed()
                //.parallel()
                .map(integer -> Strings.padStart(integer.toString(), 7, '0'))
                .filter(s -> hash.equals(encode.encode(s)))
                .findAny()
                .orElse("");
    }
}
