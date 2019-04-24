package io.github.baijifeilong.blog.foundation.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.github.baijifeilong.blog.foundation.constant.ExceptionConstants;
import io.github.baijifeilong.blog.foundation.exception.RpcException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 18:29
 */
@Component
@Slf4j
public class ArticleErrorDecoder implements ErrorDecoder, ExceptionConstants {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response) {
        try {
            String text = new Scanner(response.body().asInputStream()).useDelimiter("\\A").next();
            JsonNode jsonNode = objectMapper.readValue(text, JsonNode.class);
            log.info("[RPC异常] {}", jsonNode);
            int code = jsonNode.get("code").asInt();
            String message = jsonNode.get("message").asText();
            return new RpcException(code, message);
        } catch (IOException e) {
            log.error("[RCP错误] {}", e.getMessage(), e);
            return new RpcException(RPC_EXCEPTION_DEFAULT_CODE,
                    Optional.ofNullable(e.getMessage()).orElse(e.toString()));
        }
    }
}
