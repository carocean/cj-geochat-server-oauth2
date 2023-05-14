package cj.geochat.server.authorization.workbin;

import cj.geochat.ability.util.GeochatException;
import cj.geochat.ability.util.GeochatRuntimeException;
import cj.geochat.middle.uc.AppDetails;
import cj.geochat.server.authorization.remote.AppDetailsRemote;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class GeochatClientDetailsService implements ClientDetailsService {
    @Autowired
    AppDetailsRemote appDetailsRemote;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ClientDetails loadClientByClientId(String client_id) throws ClientRegistrationException {
        AppDetails details = null;
        try {
            details = appDetailsRemote.loadAppByAppKey(client_id);
        } catch (GeochatException e) {
            log.error(String.format("%s %s", e.getCode(), e.getMessage()));
            throw new GeochatRuntimeException(e.getCode(), e.getMessage());
        }
        if (details == null) {
            throw new NoSuchClientException(client_id);
        }
        try {
            return createClientDetails(details);
        } catch (JsonProcessingException e) {
            throw new GeochatRuntimeException("5000", e.getMessage());
        }
    }

    private ClientDetails createClientDetails(AppDetails details) throws JsonProcessingException {
        BaseClientDetails base = new BaseClientDetails();
        base.setClientId(details.getAppKey());
        base.setClientSecret(passwordEncoder.encode(details.getAppSecret()));
        base.setAuthorizedGrantTypes(details.getGrantTypes());
        base.setScope(details.getScopes());
        base.setRegisteredRedirectUri(details.getRedirectUris().stream().collect(Collectors.toSet()));
        base.setResourceIds(details.getResourceIds());
        base.setAuthorities(details.getAuthorities().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
        base.setAutoApproveScopes(Arrays.asList(String.valueOf(details.isAutoapprove())));
        if (!StringUtils.hasText(details.getAdditionalInformation() + "")) {
            String json = details.getAdditionalInformation() + "";
            Map<String, ObjectMapper> obj = new ObjectMapper().readValue(json, HashMap.class);
            base.setAdditionalInformation(obj);
        }
        if (details.getAccessTokenValidity() > 0) {
            base.setAccessTokenValiditySeconds((int) details.getAccessTokenValidity());
        }
        if (details.getRefreshTokenValidity() > 0) {
            base.setAccessTokenValiditySeconds((int) details.getRefreshTokenValidity());
        }

        return base;
    }
}
