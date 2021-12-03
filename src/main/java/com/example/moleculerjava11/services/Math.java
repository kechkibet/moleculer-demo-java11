package com.example.moleculerjava11.services;

import org.springframework.stereotype.Controller;
import services.moleculer.eventbus.Listener;
import services.moleculer.eventbus.Subscribe;
import services.moleculer.service.Action;
import services.moleculer.service.Name;
import services.moleculer.service.Service;

@Controller
public class Math extends Service {
    @Subscribe("email.sent")
    Listener orderCreated = ctx -> {
        logger.info(String.format("Payload: %s", ctx.params));
        logger.info(String.format("Sender: %s", ctx.nodeID));
        logger.info(String.format("Metadata: %s", ctx.params.getMeta()));
        logger.info(String.format("The called event name: %s", ctx.name));

        // Example of parsing the "params" block:
    };

    @Name("add")
    Action add = ctx -> {
        int a = ctx.params.get("a", 0);
        int b = ctx.params.get("b", 0);
        int c = a + b;
        return ctx.params.put("c", c);
    };
}
