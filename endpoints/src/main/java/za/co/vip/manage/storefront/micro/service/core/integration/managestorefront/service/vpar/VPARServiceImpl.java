package za.co.vip.manage.storefront.micro.service.core.integration.managestorefront.service.vpar;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.vip.manage.storefront.micro.service.core.configuration.dto.StoreFrontPartnerDTO;
import za.co.vip.manage.storefront.micro.service.core.integration.dto.RedirectRequestInbound;
import za.co.vip.manage.storefront.micro.service.core.integration.managestorefront.enums.BusinessEvent;
import za.co.vip.manage.storefront.micro.service.core.integration.managestorefront.service.RedirectService;

@Service
@Slf4j
public class VPARServiceImpl implements RedirectService { 

	@Override
	public String getRedirectUrl(RedirectRequestInbound payload, StoreFrontPartnerDTO configResponse) {
		if(payload == null) {
			throw new NullPointerException("Redirect request payload must not be null for VPAR redirect generation");
		}

        log.info("Event : {},Generate redirect url : {} for Vendor : {} and Tenant Id : {}", BusinessEvent.REDIRECT_SUCCESS, configResponse.getPartnerUrl() + payload.getMembershipId(), payload.getRequestPayload().getVendor(), payload.getTenantId());
		return configResponse.getPartnerUrl() + payload.getMembershipId();
	}
}