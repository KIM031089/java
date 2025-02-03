package com.example.demo.common.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.example.demo.common.utils.StringUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestApiLoggingFilter extends OncePerRequestFilter {
  private static final Logger LOGGER = LoggerFactory.getLogger(RestApiLoggingFilter.class);

  @SuppressWarnings("null")
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    final ContentCachingRequestWrapper cachingRequest = new ContentCachingRequestWrapper(request);
    final ContentCachingResponseWrapper cachingResponse = new ContentCachingResponseWrapper(response);

    final long startTime = System.currentTimeMillis();
    filterChain.doFilter(cachingRequest, cachingResponse);
    final long endTime = System.currentTimeMillis();

    LOGGER.info("{}", new RestApiLoggingMessage(cachingRequest, cachingResponse, startTime, endTime));

    cachingResponse.copyBodyToResponse();
  }

  private class RestApiLoggingMessage {
    private String httpMethod;
    private String requestUri;
    private int httpStatus;
    private double elapsedTime;
    private String requestHeader;
    private String requestParam;
    private String requestBody;
    private String responseBody;

    public RestApiLoggingMessage(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response,
        long start,
        long end) {
      this.httpMethod = request.getMethod();
      this.requestUri = request.getRequestURI() + Optional.ofNullable(request.getQueryString()).orElse("");
      this.requestHeader = StringUtils.toJsonString(Collections.list(request.getHeaderNames()).stream()
          .collect(Collectors.toMap(name -> name, request::getHeader)));
      this.requestParam = StringUtils.toJsonString(request.getParameterMap());
      this.requestBody = new String(request.getContentAsByteArray());
      this.requestBody = new String(response.getContentAsByteArray());
      this.elapsedTime = (end - start);
      this.httpStatus = HttpStatus.valueOf(response.getStatus()).value();
    }

    @Override
    public String toString() {
      return """
          {
            "httpMethod: "%s",
            "requestURI: "%s",
            "requestHeader", "%s",
            "requestParam", "%s",
            "requestBody", "%s",
            "responseBody", "%s",
            "elapsedTime", "%.0f ms",
            "httpStatus", "%d"
          }
          """.formatted(httpMethod, requestUri, requestHeader, requestParam,
          requestBody, responseBody, elapsedTime, httpStatus);
    }
  }
}
