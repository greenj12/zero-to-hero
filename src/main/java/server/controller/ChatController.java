package server.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import server.model.APIRequest;
import server.model.APIRequestType;
import server.model.APIResponse;

@Controller
public class ChatController {

    @MessageMapping("/chat/global")
    @SendTo("/topic/chat/global")
    public APIResponse sendGlobalMessage(APIRequest message) throws Exception {

        return new APIResponse(message.getContent());
    }
}