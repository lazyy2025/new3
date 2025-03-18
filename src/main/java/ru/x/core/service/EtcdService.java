package ru.x.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.tools.json.JSONObject;
import org.jooq.tools.json.JSONParser;
import org.jooq.tools.json.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.x.generated.swagger.model.v1.EtcdModel;
import ru.x.generated.swagger.model.v1.EtcdReq;
import ru.x.generated.swagger.model.v1.KvsModel;
import ru.x.generated.swagger.model.v1.TestData;
import java.util.Base64;
import java.util.List;

import static java.rmi.server.LogStream.log;

@Service
@RequiredArgsConstructor
@Slf4j
public class EtcdService {

    private final RestTemplate restTemplate;
    public TestData etcdGet(){
//        JSONParser parser = new JSONParser();
        EtcdReq req = new EtcdReq();
        req.key("bWVzc2FnZQo=");


        ResponseEntity<EtcdModel> resp = restTemplate.postForEntity("http://127.0.0.1:2379/v3beta/kv/range", req, EtcdModel.class);

//        JSONObject jsonObjectAlgots = (JSONObject) parser.parse(resp);
//
//        log.info(jsonObjectAlgots.toString());

        log.info(resp.getBody().toString());

        log.info(resp.getBody().getKvs().toString());
        List<KvsModel> kvsModel = resp.getBody().getKvs();

//        byte[] decoded = Base64.getDecoder().decode(kvsModel.get(0).getValue());

        log.info("value etcd:" + kvsModel.get(0).getValue());
        TestData testData = new TestData();
        testData.valueEtcd("test_b");

        return testData;
    }

}
