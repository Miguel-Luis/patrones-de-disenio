package handlers;

import model.Request;

public class LevelTwoSupport extends Handler {

    @Override
    public void handleRequest(Request request) {

        if (request.getPriority().equalsIgnoreCase("media")) {

            System.out.println(
                    "Soporte Nivel 2 resolvió la solicitud.");

        } else if (nextHandler != null) {

            nextHandler.handleRequest(request);
        }
    }
}