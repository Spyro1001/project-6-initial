package com.example.aggregator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.aggregator.model.Entry;
import com.example.aggregator.service.AggregatorService;

@RestController
public class AggregatorController {

  private AggregatorService service;

  public AggregatorController(AggregatorService service) {
    this.service = service;
  }

  @GetMapping("/getDefinitionFor/{word}")
  public Entry getDefinitionFor(@PathVariable String word) {
    return service.getDefinitionFor(word);
  }


}

