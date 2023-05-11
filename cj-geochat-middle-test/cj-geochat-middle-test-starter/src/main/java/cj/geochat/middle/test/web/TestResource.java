package cj.geochat.middle.test.web;

import cj.geochat.ability.api.annotation.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(description = "测试")
public class TestResource implements ITestResource {
    @GetMapping("/test1")
    @ApiResult
    @ApiOperation("测试1")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "2001", description = "fuck")})
    @Override
    public String test1(@ApiParam String str) {
        return "test1::" + str;
    }

    @GetMapping("/test2")
    @ApiResult
    @ApiOperation("测试2")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "2001", description = "fuck")})
    @Override
    public String test2(@RequestParam String str) {
        return "test2::" + str;
    }
}
