package com.arquimentor.platform.test.cucumber;

import com.arquimentor.platform.ArquimentorPlatformApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ArquimentorPlatformApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ArquimentorPlatformApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
}

