package org.example.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * sentinel熔断规则异常处理
 * @author anchao
 * @date 2020/11/6 14:07
 **/
@Component
public class ExceptionHandlerPage implements UrlBlockHandler {
    //BlockException 异常接口,包含Sentinel的五个异常
    // FlowException 限流异常
    // DegradeException 降级异常
    // ParamFlowException 参数限流异常
    // AuthorityException 授权异常
    // SystemBlockException 系统负载异常

    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
        ResultData resultData =null;
        response.setContentType("application/json;charset=utf-8");
        if (ex instanceof FlowException) {
            resultData = new ResultData(-1,"接口被限流");
        }else if(ex instanceof DegradeException){
            resultData = new ResultData(-2,"接口被降级");
        }
        response.getWriter().write(JSON.toJSONString(resultData));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ResultData{
        private int code;
        private String message;
    }
}
