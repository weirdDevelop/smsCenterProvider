package com.SMS.SMSCenter.controller;

import com.SMS.SMSCenter.Dto.ProviderDto;
import com.SMS.SMSCenter.Model.Provider;
import com.SMS.SMSCenter.Repository.ProviderRepository;
import com.SMS.SMSCenter.Repository.UsersRepository;
import com.SMS.SMSCenter.Model.Message;
import com.SMS.SMSCenter.Model.User;
import com.SMS.SMSCenter.Request;
import com.SMS.SMSCenter.Service.APIsServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class Controller {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    APIsServices apIsServices;


    @PostMapping("/requestMessage/{id}")
    public ResponseEntity<?> sendMessage(@PathVariable int id, @RequestBody Message message) throws Exception{

        Optional<User> user =usersRepository.findById(id);
        if(user.isPresent())
        {
            User user1=user.get();
            if(usersRepository.checkValidation(user1))
            {
                message.setUser(user1);
                ProviderDto providerDto=apIsServices.providerDto(message);
//                try {
//
//                    providerDto.setRequest(new ObjectMapper().writeValueAsString(providerDto.getStringObjectMap()));
//
//                }catch (Exception ex)
//                {
//                    ex.printStackTrace();
//                }

//                Request request=new Request(providerDto.getRequest());
//
//                HttpResponse<String> response = Unirest.post("http://rest.payamak-panel.com/api/SendSMS/SendSMS")
//                        .header("cache-control", "no-cache")
//                        .header("postman-token", "f34b35f4-26be-2bc1-a8d4-5538b482173b")
//                        .header("content-type", "application/x-www-form-urlencoded")
//                        .body(request.getRequest()).asString();
//
//                System.out.println(response);

//                String fooResourceUrl = "http://api.asiasms.ir:8080/Messages/Send";
//
//                HttpHeaders headers=new HttpHeaders();
//                headers.set("Content-Type", "application/json");
//                headers.set("Username",providerDto.getUserName());
//                headers.set("password",providerDto.getPassword());
//
//
//                try {
//
//                    providerDto.setRequest(new ObjectMapper().writeValueAsString(providerDto.getStringObjectMap()));
//
//                }catch (Exception ex)
//                {
//                    ex.printStackTrace();
//                }
//
//                Request request=new Request(providerDto.getRequest());
//                HttpEntity request2 = new HttpEntity(request.getRequest(),headers);
//
//                RestTemplate restTemplate = new RestTemplate();
//
//                String s=restTemplate.postForObject(fooResourceUrl,request2,String.class);



//                OkHttpClient client = new OkHttpClient();
//
//                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//                RequestBody body = RequestBody.create(mediaType, "username=YourUserName&password=YourPassWord&to=936...&from=1000...&text=TestSMS&isflash=false");
//                Request request = new Request.Builder()
//                        .url("http://rest.payamak-panel.com/api/SendSMS/SendSMS")
//                        .post(body)
//                        .addHeader("cache-control", "no-cache")
//                        .addHeader("postman-token", "c26ca3b0-9f44-3cdf-9da3-60c86a9f75b3")
//                        .addHeader("content-type", "application/x-www-form-urlencoded")
//                        .build();
//
//                Response response = client.newCall(request).execute();

            }

        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @PostMapping("/add/{providerId}")
    public ResponseEntity<User> addUser(@PathVariable int providerId,@RequestBody User user)
    {
        User savedUser=null;
        Optional<Provider> provider=providerRepository.findById(providerId);
        if(provider.isPresent())
        {
            user.setProvider(provider.get());
        }

        try {
            savedUser= usersRepository.save(user);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/add/provider")
    public ResponseEntity<User> addProvider(@RequestBody ProviderDto providerDto)
    {
        Provider savedProvider=null;
        try {
            savedProvider=providerRepository.save(providerRepository.matchDto(providerDto));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProvider.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("http://api.asiasms.ir:8080/Messages/Send")
    public void PostMessage(@RequestBody Message message)
    {
        System.out.println("true");



    }

}
