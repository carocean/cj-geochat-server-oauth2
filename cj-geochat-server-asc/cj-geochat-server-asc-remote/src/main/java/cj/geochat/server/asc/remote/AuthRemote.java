package cj.geochat.server.asc.remote;

import cj.geochat.ability.oauth2.asc.IAuthRemote;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@FeignClient(contextId = "authRemote", value = "cj-geochat-server-authorization", url = "${app.test.feign.adapter.docker.uc.url:}")
public interface AuthRemote extends IAuthRemote {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Override
    Response login(@RequestParam String username, @RequestParam String password);

    @RequestMapping(value = "/oauth/authorize", method = RequestMethod.POST)
    @Override
    Response authorize(
            @RequestParam String response_type,
            @RequestParam String client_id,
            @RequestParam(required = false) String scope,
            @RequestParam(required = false) String redirect_uri,
            @RequestParam(required = false) String state) throws IOException;

    @RequestMapping(value = "/oauth/authorize", method = RequestMethod.POST)
    @Override
    Response confirmAccess(@RequestParam boolean user_oauth_approval, @RequestParam(name = "scope.all", value = "scope.all") boolean scope_all) throws IOException;

    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
    @Override
    Response tokenAuthorizationCode(
            @RequestParam String grant_type,
            @RequestParam String code,
            @RequestParam String client_id,
            @RequestParam String client_secret,
            @RequestParam String redirect_uri
    ) throws IOException;

    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
    @Override
    Response tokenClientCredentials(@RequestParam String grant_type, @RequestParam String scopes) throws IOException;

    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
    @Override
    Response tokenPassword(
            @RequestParam String grant_type,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String client_id,
            @RequestParam String client_secret,
            @RequestParam String scopes
    ) throws IOException;

    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
    @Override
    Response tokenSmsCode(
            @RequestParam String grant_type,
            @RequestParam String phone_num,
            @RequestParam String sms_code,
            @RequestParam String client_id,
            @RequestParam String client_secret,
            @RequestParam String scopes
    ) throws IOException;

    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
    @Override
    Response tokenTenantCode(
            @RequestParam String grant_type,
            @RequestParam String tenantid,
            @RequestParam String access_token,
            @RequestParam String client_id,
            @RequestParam String client_secret,
            @RequestParam(required = false) String scopes
    ) throws IOException;

    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
    @Override
    Response refreshToken(
            @RequestParam String grant_type,
            @RequestParam String client_id,
            @RequestParam String client_secret,
            @RequestParam String refresh_token) throws IOException;

    @RequestMapping(value = "/oauth/check_token", method = RequestMethod.GET)
    @Override
    Response checkToken(@RequestParam String token) throws IOException;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @Override
    Response logout(@RequestParam String access_token) throws IOException;

    @RequestMapping(value = "/oauth/auth_page_address", method = RequestMethod.GET)
    @Override
    Response getAuthPageAddress() throws IOException;

    @RequestMapping(value = "/oauth/supports_grant_types", method = RequestMethod.GET)
    @Override
    Response getSupportsGrantTypes() throws IOException;
}
