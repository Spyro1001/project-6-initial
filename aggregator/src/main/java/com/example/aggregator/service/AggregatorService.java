package com.example.aggregator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.aggregator.client.AggregatorRestClient;
import com.example.aggregator.model.Entry;

@Service
public class AggregatorService {

    private AggregatorRestClient aggregatorRestClient;

    public AggregatorService(AggregatorRestClient aggregatorRestClient) {
        this.aggregatorRestClient = aggregatorRestClient;
    }

    public Entry getDefinitionFor(String word) {
        return aggregatorRestClient.getDefinitionFor(word);
    }

}
