package com.JBDL.LoadBalancerTry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BalancerService {

    @Autowired
    private ServerRepository serverrepository;

    public Server getServer()
    {
        Iterator<Server> it = serverrepository.findAll().iterator();
        List<Server> arr = new ArrayList<>();
        while(it.hasNext())
        {
            arr.add(it.next());
        }
        Random random = new Random();
        return arr.get(random.nextInt(arr.size()-1));
    }

    public boolean registerServer(String s,int p)
    {
        System.out.println(s+":"+p);
        long cnt = serverrepository.count();

        if(cnt==10)
            return false;
        try {
            serverrepository.save(new Server(s, p));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
