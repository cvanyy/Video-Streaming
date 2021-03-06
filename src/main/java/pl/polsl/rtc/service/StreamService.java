package pl.polsl.rtc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.rtc.dao.StreamRepository;
import pl.polsl.rtc.entity.Stream;
import pl.polsl.rtc.service.dto.StreamDTO;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class StreamService {

    @Autowired
    private StreamRepository streamRepository;

    public List<Stream> getAllStreams(){
        List<Stream> streamList = new ArrayList<>();
        streamRepository.findAll().forEach(streamList::add);

        return streamList;
    }

    public Stream getOneStream(long id) {
        Optional<Stream> stream = streamRepository.findById(id);

        return stream.orElseThrow(NullPointerException::new);
    }

    public boolean addStream(Stream stream) {
        Stream newStream = new Stream();
      /*  if(stream == null) {
            return false;
        }*/

        streamRepository.save(stream);
        return true;
    }

    public void deleteStream(long id) {
        streamRepository.deleteStreamById(id);
    }

    public Stream updateStream(Stream stream) {
        if(stream == null){
            throw new RuntimeException("Cam not set empty fields");
        }
        Stream newStream = new Stream();
        newStream.setId(stream.getId());
        newStream.setUrl(stream.getUrl());
        newStream.setName(stream.getName());
        newStream.setDescription(stream.getDescription());

        streamRepository.save(newStream);
        return newStream;
    }
}
