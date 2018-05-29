package pl.polsl.rtc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.rtc.dao.StreamRepository;
import pl.polsl.rtc.entity.Stream;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    public boolean addStream(Stream stream) {
        if(stream == null) {
            return false;
        }
        streamRepository.save(stream);
        return true;
    }

    public void deleteStream(long id) {
        streamRepository.deleteById(id);

    }
}