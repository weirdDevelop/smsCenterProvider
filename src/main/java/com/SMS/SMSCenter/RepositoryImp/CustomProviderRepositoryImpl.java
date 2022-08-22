package com.SMS.SMSCenter.RepositoryImp;

import com.SMS.SMSCenter.Dto.ProviderDto;
import com.SMS.SMSCenter.Model.Provider;
import com.SMS.SMSCenter.Repository.CustomProviderRepository;
import com.SMS.SMSCenter.util.MapUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomProviderRepositoryImpl implements CustomProviderRepository {
    @Override
    public Provider matchDto(ProviderDto providerDto) {

        Provider provider=new Provider();
        provider.setUserName(providerDto.getUserName());
        provider.setPassword(providerDto.getPassword());
        provider.setProperties(MapUtil.mapToString(providerDto.getStringObjectMap()));
        return provider;
    }

    @Override
    public ProviderDto matchModel(Provider provider) {
        ProviderDto providerDto=new ProviderDto();
        providerDto.setUserName(provider.getUserName());
        providerDto.setPassword(provider.getPassword());
        providerDto.setStringObjectMap(MapUtil.stringToMap(provider.getProperties()));
        return providerDto;
    }
}
