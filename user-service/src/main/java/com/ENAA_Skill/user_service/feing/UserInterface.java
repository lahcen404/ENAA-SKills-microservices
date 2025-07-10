package com.ENAA_Skill.user_service.feing;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("brief-service")
public interface UserInterface {

}
