package org.Ged.ws;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
@Configuration
@EnableElasticsearchRepositories(basePackages = "org.Ged.*")
public class ElasticSearchConfiguration extends ElasticsearchConfigurationSupport {

	@Value("${elasticsearch.host}")
	private String elasticsearchHome;
	
	@Value("${elasticsearch.port}")
	private int elasticsearchPort;

	@Value("${elasticsearch.clustername}")
	private String clusterName;
	
	@Bean
	public Client elasticsearchClient() throws Exception {
		Settings elasticsearchSettings = Settings.builder().put("client.transport.sniff", true)
				.put("cluster.name", clusterName)
				.build();
		TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
		
		client.addTransportAddress(new TransportAddress(InetAddress.getByName(elasticsearchHome), elasticsearchPort));
		return client;
	}
 
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(elasticsearchClient());
    }
}
