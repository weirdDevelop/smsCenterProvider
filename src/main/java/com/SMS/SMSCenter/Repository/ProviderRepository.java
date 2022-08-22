package com.SMS.SMSCenter.Repository;

import com.SMS.SMSCenter.Model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider,Integer>,CustomProviderRepository {


}
