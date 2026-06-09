package handlers;

import model.Request;

public class Manager extends Handler {

    @Override
    public void handleRequest(Request request) {

        if (request.getPriority().equalsIgnoreCase("alta")) {

            System.out.println(
                    "El gerente resolvió la solicitud.");

        } else {

            System.out.println(
                    "No se pudo procesar la solicitud.");
        }
    }
}