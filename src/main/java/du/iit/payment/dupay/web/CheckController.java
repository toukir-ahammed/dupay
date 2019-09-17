package du.iit.payment.dupay.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/status")
public class CheckController {
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity isOk() {
    log.info("Working fine");
    return ResponseEntity.ok("Connection was successful");
  }
}

