package pl.polsl.rtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.polsl.rtc.entity.Stream;
import pl.polsl.rtc.service.StreamService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StreamController {

    @Autowired
    private StreamService streamService;

    @GetMapping("/streams")
    public ResponseEntity<List<Stream>> getAllStreams() {
        List<Stream> streams = streamService.getAllStreams();

        return new ResponseEntity<List<Stream>>(streams, HttpStatus.OK);
    }

    @GetMapping("/streams/{id}")
    public ResponseEntity<Stream> getStream(@RequestParam long id) {
        Stream stream = streamService.getOneStream(id);

        return new ResponseEntity<Stream>(stream, HttpStatus.OK);
    }

    @PostMapping("/streams")
    public ResponseEntity<Void> addStream(@Valid @RequestBody Stream stream) {
        streamService.addStream(stream);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("streams/{id}")
    public ResponseEntity<Void> deleteStream(@Valid @RequestParam long id) {
        streamService.deleteStream(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/")
//    public ModelAndView getStreamList(Map<String, Object> model) {
//        List<Stream> streams = streamService.getAllStreams();
//
//        model.put("streams", streams);
//        return new ModelAndView("model", model);
//    }
}
