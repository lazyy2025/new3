package ru.x.core.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.x.core.service.WhoamiService;
import ru.x.generated.swagger.model.v1.ResponseUser;
import ru.x.generated.swagger.rest.api.v1.WhoamiApi;


@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
@Slf4j
public class Whoami implements WhoamiApi {

    private final HttpServletRequest request;

    private final WhoamiService whoamiService;

    @Override
    public ResponseEntity<ResponseUser> getUserNameUsingGET() {
        log.info("GET " + request.getRequestURI());
        return ResponseEntity.ok(whoamiService.whoamI("test"));
    }
}
