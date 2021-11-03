package expert.ai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import ai.expert.nlapi.security.Authentication;
import ai.expert.nlapi.security.Authenticator;
import ai.expert.nlapi.security.BasicAuthenticator;
import ai.expert.nlapi.security.DefaultCredentialsProvider;
import ai.expert.nlapi.v2.API;
import ai.expert.nlapi.v2.cloud.Analyzer;
import ai.expert.nlapi.v2.cloud.AnalyzerConfig;
import ai.expert.nlapi.v2.cloud.Categorizer;
import ai.expert.nlapi.v2.cloud.CategorizerConfig;

@Configuration
@Import(DataConfig.class)
public class DiscoveryConfig {

	@Bean
	@DependsOn("createAuthentication")
	public Categorizer createCategorizer() {
		return new Categorizer(CategorizerConfig.builder()
                .withVersion(API.Versions.V2)
                .withTaxonomy(API.Taxonomies.IPTC.name())
                .withLanguage(API.Languages.en)
                .withAuthentication(createAuthentication())
                .build());
	}
	
	@Bean
	@DependsOn("createAuthentication")
    public Analyzer createAnalyzer() throws Exception {
        return new Analyzer(AnalyzerConfig.builder()
                .withVersion(API.Versions.V2)
                .withContext(API.Contexts.STANDARD.name())
                .withLanguage(API.Languages.en)
                .withAuthentication(createAuthentication())
                .build());
    }
	
	@Bean
    public Authentication createAuthentication()  {
    	DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();
        Authenticator authenticator = new BasicAuthenticator(credentialsProvider);
        return new Authentication(authenticator);
        
	}
}
