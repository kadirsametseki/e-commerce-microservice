package kodlama.io.filterservice.configuration.elastic;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "kodlama.io.filterservice.repository")
public class ElasticsearchConfig {
    // There will be client configuration here
}
