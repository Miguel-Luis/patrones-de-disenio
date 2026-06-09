package handlers;

import model.Request;

public class LevelOneSupport extends Handler {

    @Override
    public void handleRequest(Request request) {

        if (request.getPriority().equalsIgnoreCase("baja")) {

            System.out.println(
                    "Soporte Nivel 1 resolvió la solicitud.");

        } else if (nextHandler != null) {

            nextHandler.handleRequest(request);
        }
    }
}