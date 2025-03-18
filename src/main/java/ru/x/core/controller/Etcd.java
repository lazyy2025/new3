package ru.x.core.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.x.core.service.EtcdService;
import ru.x.generated.swagger.model.v1.TestData;
import ru.x.generated.swagger.rest.api.v1.EtcdApi;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
@Slf4j
public class Etcd implements EtcdApi {
    private final HttpServletRequest request;

    public final EtcdService etcdService;


    @Override
    public ResponseEntity<TestData> getTestDataGET(){
        TestData data = etcdService.etcdGet();
        log.info(data.getValueEtcd());
        return ResponseEntity.ok(data);
    }

}
