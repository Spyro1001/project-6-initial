package com.example.aggregator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StopWatch;
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
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    Entry result = service.getDefinitionFor(word);
    stopWatch.stop();

    long nanoSeconds = stopWatch.getLastTaskTimeNanos();
    String message = new StringBuilder()
        .append("Retrieved entry for [")
        .append(word)
        .append("] in ")
        .append(nanoSeconds)
        .append(" nanoseconds")
        .toString();
    return result;
  }

  @GetMapping("/getWordsStartingWith/{chars}")
  public List<Entry> getWordsStartingWith(@PathVariable String chars) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    List<Entry> result = service.getWordsStartingWith(chars);
    stopWatch.stop();

    long nanoSeconds = stopWatch.getLastTaskTimeNanos();
    String message = new StringBuilder()
        .append("Retrieved entries for words starting with [")
        .append(chars)
        .append("] containing ")
        .append(result.size())
        .append(" entries in ")
        .append(nanoSeconds)
        .append(" nanoseconds")
        .toString();
    return result;
  }

  @GetMapping("/getWordsEndingWith/{chars}")
  public List<Entry> getWordsEndingWith(@PathVariable String chars) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    List<Entry> result = service.getWordsEndingWith(chars);
    stopWatch.stop();

    long nanoSeconds = stopWatch.getLastTaskTimeNanos();
    String message = new StringBuilder()
        .append("Retrieved entries for words ending with [")
        .append(chars)
        .append("] containing ")
        .append(result.size())
        .append(" entries in ")
        .append(nanoSeconds)
        .append(" nanoseconds")
        .toString();
    return result;
  }

  @GetMapping("/getWordsThatContain/{chars}")
  public List<Entry> getWordsThatContain(@PathVariable String chars) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    List<Entry> result = service.getWordsThatContain(chars);
    stopWatch.stop();

    long nanoSeconds = stopWatch.getLastTaskTimeNanos();
    String message = new StringBuilder()
        .append("Retrieved entries for words containing [")
        .append(chars)
        .append("] containing ")
        .append(result.size())
        .append(" entries in ")
        .append(nanoSeconds)
        .append(" nanoseconds")
        .toString();
    return result;
  }

  @GetMapping("/getWordsThatContainConsecutiveLettersAndStartsWith/{chars}")
  public List<Entry> getWordsThatContainConsecutiveLettersAndStartsWith(@PathVariable String chars) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    List<Entry> result = service.getWordsThatContainConsecutiveLettersAndStartsWith(chars);
    stopWatch.stop();

    long nanoSeconds = stopWatch.getLastTaskTimeNanos();
    String message = new StringBuilder()
        .append("Retrieved entries for words containing consecutive letters and starting with [")
        .append(chars)
        .append("] containing ")
        .append(result.size())
        .append(" entries in ")
        .append(nanoSeconds)
        .append(" nanoseconds")
        .toString();
    return service.getWordsThatContainConsecutiveLettersAndStartsWith(chars);
  }

  @GetMapping("/getAllPalindromes")
  public List<Entry> getAllPalindromes() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    List<Entry> result = service.getAllPalindromes();
    stopWatch.stop();

    long nanoSeconds = stopWatch.getLastTaskTimeNanos();
    String message = new StringBuilder()
        .append("Retrieved all palindromes containing ")
        .append(result.size())
        .append(" entries in ")
        .append(nanoSeconds)
        .append(" nanoseconds")
        .toString();
    return result;
  }

  @GetMapping("/getWordsThatContainSpecificConsecutiveLetters/{chars}")
  public List<Entry> getWordsThatContainSpecificConsecutiveLetters(@PathVariable String chars) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    List<Entry> result = service.getWordsThatContainSpecificConsecutiveLetters(chars);
    stopWatch.stop();

    long nanoSeconds = stopWatch.getLastTaskTimeNanos();
    String message = new StringBuilder()
        .append("Retrieved entries for words containing successive letters [")
        .append(chars)
        .append("] containing ")
        .append(result.size())
        .append(" entries in ")
        .append(nanoSeconds)
        .append(" nanoseconds")
        .toString();
    return result;
  }

  @GetMapping("/")
  public List<Entry> helloWorld() {
    List<Entry> entries = new ArrayList<>();
    entries.add(service.getDefinitionFor("hello"));
    entries.add(service.getDefinitionFor("world"));
    return entries;
  }

}

