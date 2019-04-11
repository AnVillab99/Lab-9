package edu.eci.arsw.collabpaint;


import java.util.concurrent.atomic.AtomicReferenceArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.collabpaint.model.Point;
import edu.eci.arsw.collabpaint.model.polygon;

@Controller
public class interceptor {
    AtomicReferenceArray <polygon> polygons = new AtomicReferenceArray<>(100);

    @Autowired
    SimpMessagingTemplate msg;

    @MessageMapping("/newpoint.{sala}")
    public void handlePointEvent(Point pt, @DestinationVariable String sala) throws Exception {
        System.out.println(sala);
        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        // no se porque no lo intercepta
        msg.convertAndSend("/topic/newpoint."+sala,pt);

    }
}