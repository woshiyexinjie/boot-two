package com.helloxin.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@Slf4j
public class RequestProxy {

    public Boolean proxy(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String contextPath = request.getServletPath();
        HttpHeaders headers = new HttpHeaders();
        URI uri = getTransferUrl(request);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();

        if (request instanceof StandardMultipartHttpServletRequest) {
            MultipartFile multipartFile = ((StandardMultipartHttpServletRequest) request).getFile("file");
            CommonInputStreamResource resource = new CommonInputStreamResource(multipartFile.getInputStream());
            params.add("file", resource);
        }
        RestTemplate restTemplate = new RestTemplate();

        headers.add(HttpHeaders.CONTENT_TYPE, Optional.ofNullable(request.getContentType()).orElse(MediaType.APPLICATION_JSON_UTF8_VALUE));
        HttpEntity<MultiValueMap<String, Object>> reqEntity = new HttpEntity(params, headers);

        ResponseEntity<byte[]> result = restTemplate.exchange(uri, HttpMethod.valueOf(request.getMethod()), reqEntity, byte[].class);
        response.setStatus(result.getStatusCodeValue());
        response.setContentType(Optional.ofNullable(result.getHeaders().getContentType()).map(MediaType::toString).orElse(""));
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result.getBody());
        outputStream.close();
        return true;
    }

    private URI getTransferUrl(HttpServletRequest request) {
        //去掉匹配的前缀 路由到实际的服务地址
        return UriComponentsBuilder
                .fromUriString("http://localhost:8083"+request.getServletPath()+"?"+request.getQueryString())
                .build()
                .toUri();
    }

    private boolean checkPattern(String contextPath, String detectionProxyPattern) {
        return contextPath.startsWith(detectionProxyPattern);
    }
}

