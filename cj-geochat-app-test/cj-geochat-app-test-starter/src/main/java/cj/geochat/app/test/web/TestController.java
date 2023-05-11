package cj.geochat.app.test.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth2.app.DefaultAppAuthentication;
import cj.geochat.app.test.remote.TestMiddleResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(description = "测试方法权限")
public class TestController {
    @Autowired
    TestMiddleResource testMiddleResource;

    //    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/test")
    @ApiResult
    @ApiOperation("是否有权")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "2001", description = "fuck")})
    public String test() {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
//        throw new RuntimeException("来吧，你说呢:"+authentication.getPrincipal());
        return "来吧，你说呢:" + authentication.getPrincipal();
//        return "aaaa";
    }

    @GetMapping("/test2")
    @ApiResult
    @ApiOperation("测试feign访问middle服务")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "2001", description = "fuck")})
    public String test2(@RequestParam String str1, @RequestParam String str2) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return String.format("%s-------%s::::%s", testMiddleResource.test1(str1), testMiddleResource.test2(str2), authentication.getPrincipal());
    }
}
