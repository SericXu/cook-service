package fun.nnyy.controller;

import com.alibaba.fastjson.JSON;
import fun.nnyy.entity.WebResult;
import fun.nnyy.utils.HttpRestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class LoginController {

    //?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    public static final String APPID = "wxccb807eb8d968958";
    public static final String SECRET = "1acae9c92c33b30c6f9281d65386438e";
    String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID
            + "&secret=" + SECRET
            + "&grant_type=authorization_code";


    @PostMapping("/login")
    public WebResult login(@RequestBody HashMap<String, String> map) {
        String code = map.get("code");
        RestTemplate client = new RestTemplate();
        String body = client.getForEntity(url + "&js_code=" + code, String.class).getBody();
        return WebResult.success().data(JSON.parse(body));
    }

}
