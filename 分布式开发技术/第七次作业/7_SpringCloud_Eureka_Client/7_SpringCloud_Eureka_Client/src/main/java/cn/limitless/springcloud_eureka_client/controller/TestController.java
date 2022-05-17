package cn.limitless.springcloud_eureka_client.controller;

import cn.limitless.springcloud_eureka_client.entity.Goods;
import cn.limitless.springcloud_eureka_client.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * <p>项目： distributed_technology-20212 </p>
 *
 * @author GnaixEuy
 * @date 2022/5/17
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = {"/test"})
public class TestController {

    private RestTemplate restTemplate;

    @SuppressWarnings(value = {"unchecked"})
    @GetMapping(value = {"/search"})
    public ResponseResult<Goods> search() {
        return this.restTemplate.getForObject("http://goods/goods", ResponseResult.class);
    }


    @GetMapping(value = {"/delete"})
    public void delete() {
        this.restTemplate.delete("http://goods/goods/23");
    }

    @SuppressWarnings(value = {"unchecked"})
    @GetMapping(value = {"/add"})
    public ResponseResult<String> add() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("gname", "加加加");
        params.add("type", "好东西");
        params.add("price", "2333.0");
        params.add("date", new Date().toString());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        this.restTemplate.postForEntity("http://goods/goods", requestEntity, ResponseResult.class);
        return ResponseResult.success("成功");
    }

    @GetMapping(value = {"/update"})
    public ResponseResult<String> update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("gid", "1");
        params.add("gname", "我改完了");
        params.add("type", "好东西");
        params.add("price", "2333.0");
        params.add("date", new Date().toString());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        this.restTemplate.put("http://goods/goods", requestEntity);
        return ResponseResult.success("成功");
    }


    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
