package com.JBDL.LoadBalancerTry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalancerController {

    @Autowired
    private BalancerService balancerService;

    private Server server=null;

    @RequestMapping("/getInstance")
    public ResponseEntity<Object> getServerInstance()
    {
        try {
           server = balancerService.getServer();
        }
        catch(Exception e)
        {
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(server,new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value="/registerInstance")
    public ResponseEntity<Object> registerServerInstance(@RequestBody Server s)
    {
        boolean flag = balancerService.registerServer(s.getIpAddress(),s.getPort());

        if(!flag)
        {
            return new ResponseEntity<Object>(new String("Failed"),new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>(new String ("Success"),new HttpHeaders(), HttpStatus.OK);

    }
}
