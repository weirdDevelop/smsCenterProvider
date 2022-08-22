package com.SMS.SMSCenter.Repository;

import com.SMS.SMSCenter.Dto.ProviderDto;
import com.SMS.SMSCenter.Model.Provider;

public interface CustomProviderRepository {

    Provider matchDto(ProviderDto providerDto);
    ProviderDto matchModel(Provider provider);

}
