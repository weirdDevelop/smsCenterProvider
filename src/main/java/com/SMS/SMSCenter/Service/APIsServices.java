package com.SMS.SMSCenter.Service;


import com.SMS.SMSCenter.Dto.ProviderDto;
import com.SMS.SMSCenter.Model.Message;
import com.SMS.SMSCenter.Repository.MessageRepository;
import com.SMS.SMSCenter.Repository.ProviderRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service("ApisServices")
public class APIsServices {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ProviderRepository providerRepository;


    public boolean postMessage(@RequestBody Message message){

        messageRepository.save(message);
        ProviderDto providerDto = providerRepository.matchModel(message.getUser().getProvider());

        return true;


    }

    public ProviderDto providerDto(Message message)
    {

        ProviderDto providerDto = providerRepository.matchModel(message.getUser().getProvider());
        providerDto.setUserName("irisa1");
        providerDto.setPassword("244767@alp");
        providerDto.getStringObjectMap().put("SmsText",message.getMessage());
        providerDto.getStringObjectMap().put("Receivers",message.getReceiverNumber());
        providerDto.getStringObjectMap().put("IsFlash",String.valueOf(message.isFlash()));
        providerDto.getStringObjectMap().put("IsUnicode",String.valueOf(message.isUnicode()));

        return providerDto;
    }

//    public CompletionStage<WSResponse> SendAsemanSMS(ProviderDto providerDto) {
//
//
//        WSClient wsClient =null;
//
//        String fooResourceUrl = "http://api.asiasms.ir:8080/Messages/Send";
//        JsonNode json = Json.newObject()
//                .put("SmsText", providerDto.getStringObjectMap().get("SmsText"))
//                .put("Receivers", providerDto.getStringObjectMap().get("Receivers"))
//                .put("IsFlash", providerDto.getStringObjectMap().get("IsFlash"))
//                .put("IsUnicode", providerDto.getStringObjectMap().get("IsUnicode"));
//
//
//
//        wsClient.url(fooResourceUrl + "SendSMS").addHeader("Content-Type", "application/json")
//                .post(json);
//
//        //.thenApply(response ->
//        //ok("result: " + response.getBody())//.asJson().findValues("full_name")
//        //);
//    }
}
